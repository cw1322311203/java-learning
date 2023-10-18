package com.cw.builder;

import com.cw.builder.entity.Computer;

public interface ComputerBuilder {
    Computer build();
    ComputerBuilder cpu(String cpu);
    ComputerBuilder ram(String ram);
    ComputerBuilder storage(String storage);
}
