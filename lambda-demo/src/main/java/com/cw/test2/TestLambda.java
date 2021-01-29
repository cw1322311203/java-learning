package com.cw.test2;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 16:07
 */
public class TestLambda {

    /**
     * 格式：(形式参数) -> {代码块}
     * 1.形式参数：如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可
     * 2.->：由英文中画线和大于符号组成，固定写法。代表指向动作
     * 3.代码块：是我们具体要做的事情，也就是以前我们写的方法体内容
     * 组成Lambda表达式的三要素：形式参数，箭头，代码块
     * <p>
     * Lambda表达式的使用前提
     * 1.有一个接口
     * 2.接口中有且仅有一个抽象方法
     */
    public static void main(String[] args) {
        useShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类中的show方法");
            }
        });

        useShowHandler(() -> {
            System.out.println("我是lambda表达式中的show方法");
        });

        useShowHandler(() -> System.out.println("我是省略版lambda表达式中的show方法"));
    }

    public static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }
}

interface ShowHandler {
    void show();
}