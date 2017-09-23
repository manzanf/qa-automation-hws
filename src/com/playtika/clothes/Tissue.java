package com.playtika.clothes;

abstract class Tissue {
    private String name;
    enum Type {natural, synthetic, mixed}
    private Type type;
    private Double value;
    enum Origin {animal, green, manufactured}
    private Origin origin;

    Tissue(String name, Type type, Double value, Origin origin) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.origin = origin;
    }

    double getValue() {
        return value;
    }
}
