package pers.zed.tankwar.model;

import lombok.Data;

/**
 * @ClassName: Wall
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 16:59
 * @Version: 1.0
 */
@Data
public class Wall extends Component {

    private int solidity;

    public Wall(float x, float y, int solidity) {
        this.x = x;
        this.y = y;
        this.solidity = solidity;
    }
}
