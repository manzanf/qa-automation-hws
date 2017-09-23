package com.playtika.clothes;

import java.math.BigDecimal;

abstract class Clothes {
    String size;
    double workComplexity;

    abstract void sew();

    abstract BigDecimal calculatePrice();
}
