package com.playtika.clothes;

class Viscose extends Tissue {
    private boolean ifMattingElementsAdded;

    Viscose(String name, Type type, Double value, Origin origin, boolean ifMattingElementsAdded) {
        super(name, type, value, origin);
        this.ifMattingElementsAdded = ifMattingElementsAdded;
    }
}
