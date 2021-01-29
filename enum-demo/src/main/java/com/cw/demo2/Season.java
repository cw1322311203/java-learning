package com.cw.demo2;


public enum Season {
    SPRING("春") {
        // 如果枚举类中有抽象方法，那么在枚举项中必须要全部重写
        public void show() {
            System.out.println(this.name);
        }
    },
    SUMMER("夏") {
        public void show() {
            System.out.println(this.name);
        }
    },
    AUTUMN("秋") {
        public void show() {
            System.out.println(this.name);
        }
    },
    WINTER("冬") {
        public void show() {
            System.out.println(this.name);
        }
    };

    // 第四个特点的演示:枚举也是一个类，也可以去定义成员变量
    public String name;

    // 空参构造
    private Season() {
    }

    // 有参构造
    private Season(String name) {
        this.name = name;
    }

    // 抽象方法
    public abstract void show();
}