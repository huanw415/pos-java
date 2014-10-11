package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CartItem extends Item{
    private double num;

    public CartItem(Item item, double num){
        super(item.getBarcode(), item.getName(), item.getUnit(), item.getPrice());
        this.setNum(num);

    }

    public double getNum(){
        return this.num;
    }
    public void setNum(double num){
        this.num = num;
    }

    public double getSubTotal(){
        ArrayList<Double> allSubTotals = new ArrayList<Double>();
        PromotionCalculator promotionCalculator = new PromotionCalculator();

        Item item = new Item(this.getBarcode(), this.getName(), this.getUnit(), this.getPrice());
        CartItem cartItem = new CartItem(item, this.num);

        for(int i=0; i<getPromotion().size(); i++){
            if(getPromotion().get(i).equals("buy_two_get_one_free_promotion")){
                allSubTotals.add(promotionCalculator.caLculateBuyTwoGetOneFreePromotion(cartItem));
            }
            if(getPromotion().get(i).equals("second_half_price_promotion")){
                allSubTotals.add(promotionCalculator.caLculateSecondHalfPricePromotion(cartItem));
            }
            if(getPromotion().get(i).equals("discount_promotion")){
                allSubTotals.add(promotionCalculator.caLculateDiscountPromotion(cartItem));
            }
        }
        return Collections.min(allSubTotals);
    }
}
