package com.cw.threadatom;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 16:25
 */
public class AtomDemo {
    public static void main(String[] args) {
        MyAtomThread atom = new MyAtomThread();

        for (int i = 0; i < 100; i++) {

            new Thread(atom).start();
        }
    }
}
