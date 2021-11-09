package com.stonebridge.domain;

public class HappyComponent {
    private String name;
    private HappyMachine machine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HappyMachine getMachine() {
        return machine;
    }

    public void setMachine(HappyMachine machine) {
        this.machine = machine;
    }

    public void happyInitMethod() {
        System.out.println("HappyComponent初始化");
    }

    public void happyDestroyMethod() {
        System.out.println("HappyComponent销毁");
    }

    public HappyComponent() {
    }
}
