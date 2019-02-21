package com.ifkbhit.debts.data;

public class Operation {


    private double value;
    private String name;

    public Operation(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public Operation(double value){
        this(value, "");
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
