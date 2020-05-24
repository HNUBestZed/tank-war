package pers.zed.tankwar.model;

import lombok.Data;

/**
 * @ClassName: Bullet
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 9:47
 * @Version: 1.0
 */
@Data
public class Bullet extends BaseMovableComponent {

    private String TankId;

    private int damage;

    private Long createTime;


    @Override
    protected void checkCrashWall() {
        super.checkCrashWall();
    }
}
