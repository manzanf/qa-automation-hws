package com.playtika.automation.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

class Dress extends Clothes {
    private Tissue material;
    private double tissueQuantity;
    private String color;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    Dress(String size, Tissue material, double workComplexity, double tissueQuantity, String color) {
        this.size = size;
        this.material = material;
        this.workComplexity = workComplexity;
        this.tissueQuantity = tissueQuantity;
        this.color = color;
    }

    void sew() {
        logger.info("The dress is sewing:");
        addClasp();
        addTucks();
    }

    private void addClasp() {
        logger.info("The clasp was added");
    }

    private void addTucks() {
        logger.info("The 2 tucks were added");
    }

    BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(tissueQuantity * material.getValue() * (1 + workComplexity));
        return price;
    }
}
