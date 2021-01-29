package com.cw.demo1;

/**
 * 用常量表示季节的弊端
 * 1.代码不够简洁
 * 2.不同类型的数据是通过名字区分的
 * 3.不安全。由于是数字类型，就有可能使用这几个值做一些运算操作。比如:SEASON_SPRING + SEASON_SUMMER
 * <p>
 * 枚举的作用
 * 为了简洁的表示一些固定的值，Java就给我们提供了枚举
 * 是指将变量的值一一列出来,变量的值只限于列举出来的值的范围内
 *
 * @author 陈小哥cw
 * @date 2021/1/28 17:11
 */
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
