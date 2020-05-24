package pers.zed.tankwar.model;

import lombok.Data;
import pers.zed.tankwar.ComponentRegistry;
import pers.zed.tankwar.enums.DirectionEnum;
import pers.zed.tankwar.thread.BulletMoveThread;

import java.util.UUID;

/**
 * @ClassName: BaseTank
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 9:48
 * @Version: 1.0
 */
@Data
public class Tank extends BaseMovableComponent{

    private int HP;

    public Tank(int HP, float speed, float x, float y, float length, float width, DirectionEnum dir, boolean isPlayer) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.HP = HP;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.dir = dir;
        this.isPlayer = isPlayer;
    }

    public void shoot() {
        Bullet bullet = new Bullet();
        bullet.setId(UUID.randomUUID().toString().replace("-", ""));
        bullet.setTankId(this.getId());
        bullet.setDir(this.getDir());
        bullet.setX(this.getX());
        bullet.setY(this.getY());
        bullet.setSpeed(10f);
        bullet.setCreateTime(System.currentTimeMillis());
        bullet.setPlayer(this.isPlayer());
        ComponentRegistry.registerBullet(bullet);
    }

    @Override
    protected void preMove(DirectionEnum dir) {
        if (dir != this.getDir()){
            this.setDir(dir);
            return;
        }
    }

    @Override
    protected void checkCrashWall() {
        super.checkCrashWall();
    }

    public static void main(String[] args) {
        Tank tank = new Tank(100,0.1f,5.0f,5.0f,0.2f,0.2f,DirectionEnum.RIGHT, false);
        ComponentRegistry.registerTank(tank);
        tank.shoot();
        new BulletMoveThread().start();

    }


}
