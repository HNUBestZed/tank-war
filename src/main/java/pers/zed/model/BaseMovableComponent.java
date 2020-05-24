package pers.zed.model;

import lombok.Data;
import pers.zed.constants.TankWarConstant;
import pers.zed.enums.DirectionEnum;

/**
 * @ClassName: BaseMovableComponent
 * @Description:
 * @Author: zed
 * @Date: 2020/5/24 17:34
 * @Version: 1.0
 */
@Data
public abstract class BaseMovableComponent extends Component {

    public float speed;

    public DirectionEnum dir;

    public void move(DirectionEnum dir, float time){
        preMove(dir);
        CheckCrashBorderAndMove(time);
        checkCrashWall();

    }

    protected void checkCrashWall() {
    }


    protected void preMove(DirectionEnum dir){}



    public void CheckCrashBorderAndMove(float time){
        float x = this.getX();
        float y = this.getY();
        //与边框碰撞
        switch (dir) {
            case UP:
                this.setY((y + this.getSpeed() * time + this.getWidth() / 2) >= TankWarConstant.WINDOW_WIDTH ? TankWarConstant.WINDOW_WIDTH : (y + this.getSpeed() * time));
                break;
            case DOWN:
                this.setY((y - this.getSpeed() * time - this.getWidth() / 2) <= 0 ? 0 : (y - this.getSpeed() * time));
                break;
            case LEFT:
                this.setX((x - this.getSpeed() * time - this.getLength() / 2) <= 0 ? 0 : (x - this.getSpeed() * time));
                break;
            case RIGHT:
                this.setX((x + this.getSpeed() * time + this.getLength() / 2) >= TankWarConstant.WINDOW_LENGTH ? TankWarConstant.WINDOW_LENGTH : (x + this.getSpeed() * time));
                break;
            default:
                System.out.println("错误的方向");
        }
    }

}
