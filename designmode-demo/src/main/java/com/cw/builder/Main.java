package com.cw.builder;

import com.cw.builder.entity.Computer;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ConcreteComputerBuilder();
        Computer computer = computerBuilder.cpu("Intel i9")
                .ram("32GB")
                .storage("1TB SSD")
                .build();

        System.out.println(computer);
    }
}
