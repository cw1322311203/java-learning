package com.cw.myanno3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 9:26
 */
// 表示Test这个注解的存活时间
// 元注解就是描述注解的注解
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
}
