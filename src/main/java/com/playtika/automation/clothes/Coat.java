package com.playtika.automation.clothes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

class Coat extends Clothes {
    private Tissue cover;
    private Tissue lining;
    private double coverQuantity;
    private double liningQuantity;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    Coat(String size, Tissue cover, Tissue lining, double workComplexity, double coverQuantity, double liningQuantity) {
        this.size = size;
        this.cover = cover;
        this.lining = lining;
        this.workComplexity = workComplexity;
        this.coverQuantity = coverQuantity;
        this.liningQuantity = liningQuantity;
    }

    void sew() {
        logger.info("The coat is sewing:");
        joinFurAndLining();
        addChain();
    }

    private void addChain() {
        logger.info("Chain was added");
    }

    private void joinFurAndLining() {
        logger.info("Fur and lining were joined");
    }

    BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal((coverQuantity * cover.getValue() + liningQuantity * lining.getValue()) * (1 + workComplexity));
        return price;
    }

    void chooseMatchedBelt() {
        logger.info("The matched belt was chosen");
    }
}
