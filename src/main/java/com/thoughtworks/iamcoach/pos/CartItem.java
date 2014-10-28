package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.Collections;

public class CartItem extends Item{
    private double num;

    private ArrayList<String> promotion = new ArrayList<String>();

    public CartItem(Item item, double num){
        super(item.getBarcode(), item.getName(), item.getUnit(), item.getPrice());
        this.setNum(num);

        Promotion promotion = new Promotion();
        this.promotion = promotion.getPromotion(getBarcode());
    }

    public ArrayList<String> getPromotion() {
        return promotion;
    }

    public double getNum(){
        return this.num;
    }
    public void setNum(double num){
        this.num = num;
    }

    public double getSubTotal(){
        ArrayList<Double> allSubTotals = new ArrayList<Double>();

        Item item = new Item(this.getBarcode(), this.getName(), this.getUnit(), this.getPrice());
        CartItem cartItem = new CartItem(item, this.num);

        for(int i=0; i<getPromotion().size(); i++){
            if(getPromotion().get(i).equals("buy_two_get_one_free_promotion")){
                BuyTwoOneFreeCalculator buyTwoOneFreeCalculator = new BuyTwoOneFreeCalculator();
                allSubTotals.add(buyTwoOneFreeCalculator.calculatePromotion(cartItem));
            }
            if(getPromotion().get(i).equals("second_half_price_promotion")){
                SecondHalfCalculator secondHalfCalculator = new SecondHalfCalculator();
                allSubTotals.add(secondHalfCalculator.calculatePromotion(cartItem));
            }
            if(getPromotion().get(i).equals("discount_promotion")){
                DiscountCalculator discountCalculator = new DiscountCalculator();
                allSubTotals.add(discountCalculator.calculatePromotion(cartItem));
            }
        }
        return Collections.min(allSubTotals);
    }
}
