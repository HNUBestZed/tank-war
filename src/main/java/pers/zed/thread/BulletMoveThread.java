package pers.zed.thread;

import pers.zed.ComponentRegistry;
import pers.zed.constants.TankWarConstant;
import pers.zed.model.Bullet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BulletMoveThread
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 17:08
 * @Version: 1.0
 */
public class BulletMoveThread extends Thread {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(TankWarConstant.BULLET_LOCATION_THREAD_INTERVAL);
                calBulletLocation();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void calBulletLocation(){
        Map<String, List<Bullet>> bulletMap = ComponentRegistry.bulletMap;
        bulletMap.forEach((tankId,bullets) -> {
            if(bullets != null && bullets.size() != 0){
                Iterator<Bullet> iterator = bullets.iterator();
                while (iterator.hasNext()){
                    Bullet bullet = iterator.next();
                    bullet.move(bullet.getDir(),(float)TankWarConstant.BULLET_LOCATION_THREAD_INTERVAL/1000);
                    System.out.println("子弹坐标：" + bullet.getX() + "-" + bullet.getY());
                    //如果到达游戏边界则统一销毁
                    if(bullet.getX() == 0
                            || bullet.getX() == TankWarConstant.WINDOW_LENGTH
                            || bullet.getY() == 0
                            || bullet.getY() == TankWarConstant.WINDOW_WIDTH){
                        iterator.remove();
                    }
                }
            }
        });
    }


}
