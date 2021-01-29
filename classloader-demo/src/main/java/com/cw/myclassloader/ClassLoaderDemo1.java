package com.cw.myclassloader;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 10:27
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        // 获取系统类加载器的父加载器 --- 平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();

        // 获取平台类加载器的父加载器 --- 启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println("系统类加载器" + systemClassLoader);// sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("平台类加载器" + classLoader1);// sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println("启动类加载器" + classLoader2);// null
    }
}
