package pers.zed.tankwar;

import pers.zed.tankwar.model.Bullet;
import pers.zed.tankwar.model.Tank;
import pers.zed.tankwar.model.Wall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ComponentRegistry
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 9:53
 * @Version: 1.0
 */
public class ComponentRegistry {

    public static Map<String, Tank> tankMap = new HashMap<>();

    public static Map<String, List<Bullet>> bulletMap = new HashMap<>();

    public static Map<String, Wall> wallMap = new HashMap<>();

    public static void registerTank(Tank tank){
        if(tank != null){
            tankMap.put(tank.getId(), tank);
        }
    }

    public static void registerBullet(Bullet bullet){
        if(bullet != null){
            List<Bullet> bulletList = bulletMap.get(bullet.getTankId());
            if(bulletList == null || bulletList.size() == 0){
                bulletList = new ArrayList<>();
            }
            bulletList.add(bullet);
            bulletMap.put(bullet.getTankId(), bulletList);
        }
    }

    public static void registerWall(Wall wall){
        if(wall != null){
            wallMap.put(wall.getId(), wall);
        }
    }


    public static void destroyTank(Tank tank){
        tankMap.remove(tank.getId());
    }

    public static void destroyBullet(Bullet bullet){
        bulletMap.get(bullet.getTankId()).remove(bullet);
    }

    public static void destroyWall(Wall wall){
        wallMap.remove(wall.getId());
    }
}
