package com.cw.builder;

import com.cw.builder.entity.Computer;

public class ConcreteComputerBuilder implements ComputerBuilder{

    private String cpu;
    private String ram;
    private String storage;

    @Override
    public Computer build() {
        return new Computer(cpu, ram, storage);
    }

    @Override
    public ComputerBuilder cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder storage(String storage) {
        this.storage = storage;
        return this;
    }
}
