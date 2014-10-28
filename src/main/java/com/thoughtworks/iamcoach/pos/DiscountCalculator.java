package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class DiscountCalculator extends PromotionCalculator{
    @Override
    public double calculatePromotion(CartItem cartItem) {
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
