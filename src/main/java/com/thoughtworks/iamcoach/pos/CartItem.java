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
                allSubTotals.add(promotionCalculator.caculate_buy_two_get_one_free_promotion(cartItem));
            }
            if(getPromotion().get(i).equals("second_half_price_promotion")){
                allSubTotals.add(promotionCalculator.caculate_second_half_price_promotion(cartItem));
            }
            if(getPromotion().get(i).equals("discount_promotion")){
                allSubTotals.add(promotionCalculator.caculate_discount_promotion(cartItem));
            }
        }
        return Collections.min(allSubTotals);
    }
//    private double caculate_buy_two_get_one_free_promotion(){
//
//        double promotionNumber = ((int) num)/3;
//        double actualNumber = num - promotionNumber;
//        return actualNumber * getPrice();
//    }
//
//    private double caculate_second_half_price_promotion(){
//
//        double promotionNumber = ((int) num)/2;
//        double actualNumber = (num - promotionNumber) + promotionNumber/2;
//        return actualNumber * getPrice();
//    }
//
//    private double caculate_discount_promotion(){
//        double discount = getDiscount();
//        return num * discount * getPrice();
//    }
//
//    private double getDiscount(){
//        double discount = 0;
//        ArrayList<String> discountPromitions = getDiscountPromotion();
//        for(int i=0; i<discountPromitions.size(); i++){
//            String[] currentPromotion = discountPromitions.get(i).split(":");
//            if(getBarcode().equals(currentPromotion[0])){
//                discount = Double.parseDouble(currentPromotion[1])/100;
//            }
//        }
//        return discount;
//    }
//    private ArrayList<String> getDiscountPromotion(){
//
//        ArrayList<String> promotionText = new ArrayList<String>();
//        try {
//            File discountPromotion = new File("src/main/resources/discount_promotion.txt");
//            FileReader discountPromotionReader = new FileReader(discountPromotion);
//            BufferedReader reader = new BufferedReader(discountPromotionReader);
//
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                promotionText.add(line);
//            }
//            reader.close();
//        } catch (IOException ex) {
//            System.out.println("fail read file!");
//        }
//        return promotionText;
//    }
}
