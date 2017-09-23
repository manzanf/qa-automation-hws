package com.playtika.clothes;

import java.math.BigDecimal;

import static com.playtika.clothes.Tissue.Origin.*;
import static com.playtika.clothes.Tissue.Type.*;

public class Application {
    public static void main(String[] args) {
        Fur alpacaFur = new Fur("Alpaca fur", natural, 103.64, animal, 23);
        Cotton cottonTissue = new Cotton("Cotton tissue", natural, 33.2, green, 23);
        Clothes coat = new Coat("XS", alpacaFur, cottonTissue, 0.7, 2.5, 1.9 );

        Viscose viscose = new Viscose("Viscose", mixed, 54.73, manufactured, true);
        Clothes dress = new Dress("S", viscose, 0.5, 2.1, "red");

        coat.sew();
        BigDecimal coatPrice = coat.calculatePrice();
        System.out.println("Price of the coat is: " + coatPrice);

        ((Coat)coat).chooseMatchedBelt();

        dress.sew();
        BigDecimal dressPrice = dress.calculatePrice();
        System.out.println("Price of the dress is: " + dressPrice);


    }
}
