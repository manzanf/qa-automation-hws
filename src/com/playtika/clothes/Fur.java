package com.playtika.clothes;

class Fur extends Tissue {
    private double pileThickness;

    Fur(String name, Type type, Double value, Origin origin, double pileThickness) {
        super(name, type, value, origin);
        this.pileThickness = pileThickness;
    }
}
