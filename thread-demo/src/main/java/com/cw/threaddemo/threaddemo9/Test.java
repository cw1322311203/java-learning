package com.cw.threaddemo.threaddemo9;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 15:40
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        ticket1.setName("窗口一");
        ticket2.setName("窗口二");

        ticket1.start();
        ticket2.start();


    }
}
