package com.playtika.clothes;

class Cotton extends Tissue {
    private double fiberLength;

    Cotton(String name, Type type, Double value, Origin origin, double fiberLength) {
        super(name, type, value, origin);
        this.fiberLength = fiberLength;
    }
}
