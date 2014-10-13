package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PromotionCalculator {

    public double caLculateBuyTwoGetOneFreePromotion(CartItem cartItem){

        double promotionNumber = ((int) cartItem.getNum())/3;
        double actualNumber = cartItem.getNum() - promotionNumber;
        return actualNumber * cartItem.getPrice();
    }

    public double caLculateSecondHalfPricePromotion(CartItem cartItem){

        double promotionNumber = ((int) cartItem.getNum())/2;
        double actualNumber = (cartItem.getNum() - promotionNumber) + promotionNumber/2;
        return actualNumber * cartItem.getPrice();
    }

    public double caLculateDiscountPromotion(CartItem cartItem){
        double discount = getDiscount(cartItem);
        return cartItem.getNum() * discount * cartItem.getPrice();
    }

    private double getDiscount(CartItem cartItem){
        double discount = 0;
        ArrayList<String> discountPromotions = getDiscountPromotion();

        for (String aDiscountPromotion: discountPromotions){
            String[] currentPromotion = aDiscountPromotion.split(":");
            if(cartItem.getBarcode().equals(currentPromotion[0])){
                discount = Double.parseDouble(currentPromotion[1])/100;
            }
        }
        return discount;
    }

    private ArrayList<String> getDiscountPromotion(){

        ArrayList<String> promotionText = new ArrayList<String>();
        try {
            Path path = FileSystems.getDefault().getPath("src/main/resources/", "discount_promotion.txt");
            promotionText = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
        return promotionText;
    }
}
