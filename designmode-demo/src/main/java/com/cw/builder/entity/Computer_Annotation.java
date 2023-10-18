package com.cw.builder.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // 自动为该类创建链式调用方法
public class Computer_Annotation {
    private String cpu;
    private String ram;
    private String storage;
}
