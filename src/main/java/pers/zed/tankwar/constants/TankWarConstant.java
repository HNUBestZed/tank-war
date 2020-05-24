package pers.zed.tankwar.constants;

import pers.zed.tankwar.model.Wall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TankWarConstant
 * @Description:
 * @Author: zed
 * @Date: 2020/5/20 16:40
 * @Version: 1.0
 */
public class TankWarConstant {

    /**
     * 地图长度
     */
    public static float WINDOW_LENGTH = 20.0f;

    /**
     * 地图宽度
     */
    public static float WINDOW_WIDTH = 10.0f;

    /**
     * 子弹位置更新线程的执行时间间隔,单位：ms
     */
    public static final long BULLET_LOCATION_THREAD_INTERVAL = 10L;

    /**
     * 轮询组件位置线程的执行时间间隔
     */
    public static final long LOOP_QUERY_LOCATION_THREAD_INTERVAL = 10L;


    /**
     * 地图
     */
    public static final Map<String, List<Wall>> MAP = new HashMap<>();

    static {
        Wall wall1 = new Wall(1f, 5f, 4);
        Wall wall2 = new Wall(15f, 2f, 0);
        Wall wall3 = new Wall(7f, 9f, 2);
        Wall wall4 = new Wall(12f, 7f, 3);
        List<Wall> wallList = new ArrayList<>();
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
        MAP.put("1",wallList);

    }







}
