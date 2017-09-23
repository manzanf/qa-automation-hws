package com.playtika.clothes;

import java.math.BigDecimal;

class Coat extends Clothes {
    private Tissue cover;
    private Tissue lining;
    private double coverQuantity;
    private double liningQuantity;

    Coat(String size, Tissue cover, Tissue lining, double workComplexity, double coverQuantity, double liningQuantity) {
        this.size = size;
        this.cover = cover;
        this.lining = lining;
        this.workComplexity = workComplexity;
        this.coverQuantity = coverQuantity;
        this.liningQuantity = liningQuantity;
    }

    void sew() {
        System.out.println("The coat is sewing:");
        joinFurAndLining();
        addChain();
    }

    private void addChain() {
        System.out.println("Chain was added");
    }

    private void joinFurAndLining() {
        System.out.println("Fur and lining were joined");
    }

    BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal((coverQuantity * cover.getValue()+ liningQuantity * lining.getValue())*(1+workComplexity));
        return price;
    }

    void chooseMatchedBelt() {
        System.out.println("The matched belt was chosen");
    }
}
