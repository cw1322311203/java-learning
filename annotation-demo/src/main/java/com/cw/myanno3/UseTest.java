package com.cw.myanno3;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 9:25
 */
public class UseTest {
    //没有使用Test注解
    public void show(){
        System.out.println("UseTest....show....");
    }

    //使用Test注解
    @Test
    public void method(){
        System.out.println("UseTest....method....");
    }

    //没有使用Test注解
    @Test
    public void function(){
        System.out.println("UseTest....function....");
    }
}
