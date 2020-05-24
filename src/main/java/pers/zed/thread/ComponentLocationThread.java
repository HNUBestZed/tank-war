package pers.zed.thread;

import pers.zed.ComponentRegistry;
import pers.zed.constants.TankWarConstant;
import pers.zed.model.Bullet;
import pers.zed.model.Tank;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ComponentLocationThread
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 17:11
 * @Version: 1.0
 */
public class ComponentLocationThread implements Runnable {
    @Override
    public void run() {
        while (true){
            loopQueryComponentLocation();
            try {
                Thread.sleep(TankWarConstant.LOOP_QUERY_LOCATION_THREAD_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void loopQueryComponentLocation(){
        List<Tank> tankList = ComponentRegistry.tankMap.values().stream().collect(Collectors.toList());
        List<Bullet> bulletList = ComponentRegistry.bulletMap.values().stream().flatMap(bullets -> bullets.stream()).collect(Collectors.toList());
        for (Tank tank : tankList){
            for (Bullet bullet : bulletList){
                //首先两个坐标相等，发生碰撞，其次碰撞双方不能是同一方的，最后子弹不能是它所属坦克发出来的
                if(tank.getX() == bullet.getX() && tank.getX() == bullet.getX() &&tank.isPlayer()==bullet.isPlayer() && tank.getId() != bullet.getTankId()){
                    //根据伤害扣减血量o
                    int remainHP = tank.getHP() - bullet.getDamage();
                    if(remainHP <= 0){
                        ComponentRegistry.destroyTank(tank);
                        ComponentRegistry.destroyBullet(bullet);
                        //如果是tank是游戏玩家，则游戏结束
                        if(tank.isPlayer()){
                            System.out.println("游戏结束");
                        }
                    }

                }
            }
        }
    }
}
