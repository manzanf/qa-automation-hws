package com.playtika.clothes;

import java.math.BigDecimal;

class Dress extends Clothes {
    private Tissue material;
    private double tissueQuantity;
    private String color;

    Dress(String size, Tissue material, double workComplexity, double tissueQuantity, String color) {
        this.size = size;
        this.material = material;
        this.workComplexity = workComplexity;
        this.tissueQuantity = tissueQuantity;
        this.color = color;
    }

    void sew() {
        System.out.println("The dress is sewing:");
        addClasp();
        addTucks();
    }

    private void addClasp() {
        System.out.println("The clasp was added");
    }

    private void addTucks() {
        System.out.println("The 2 tucks were added");
    }

    BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(tissueQuantity * material.getValue() * (1+workComplexity));
        return price;
    }
}
