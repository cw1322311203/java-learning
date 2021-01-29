package com.cw.threaddemo.threaddemo13;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 17:32
 */
public class Desk {
    // 标记
    // true:表示桌子上有汉堡，此时允许吃货执行
    // false:表示桌子上没有汉堡，此时允许厨师执行
    //public static boolean flag = false;
    private boolean flag;

    // 汉堡的总数量
    //public static int count = 10;
    private int count;

    // 锁对象
    //public static final Object lock=new Object();
    private final Object lock = new Object();


    public Desk() {
        this(false, 10);
    }

    public Desk(boolean flag, int count) {
        this.flag = flag;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "flag=" + flag +
                ", count=" + count +
                ", lock=" + lock +
                '}';
    }
}
