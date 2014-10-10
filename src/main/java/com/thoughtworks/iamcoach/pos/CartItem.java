package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.util.ArrayList;

public class CartItem extends Item{
    public double num;
    public double subTotal;

    public CartItem(Item item, double num){
        super(item.barcode, item.name, item.unit, item.price);
        this.num = num;

    }

    public double getSubTotal(){
        //promotion

        return 0;
    }
    private double caculate_buy_two_get_one_free_promotion(){

        double promotionNumber = ((int) num)/3;
        double actualNumber = num - promotionNumber;
        return actualNumber * price;
//        return subTotals;
    }

    private double caculate_second_half_price_promotion(){

        double promotionNumber = ((int) num)/2;
        double actualNumber = (num - promotionNumber) + promotionNumber/2;
        return actualNumber * price;
//        return subTotals;
    }

    private double caculate_discount_promotion(){
        double discount = getDiscount();
        return num * discount * price;
    }

    private double getDiscount(){
        double discount = 0;
        ArrayList<String> discountPromitions = getDiscountPromotion();
        for(int i=0; i<discountPromitions.size(); i++){
            String[] currentPromotion = discountPromitions.get(i).split(":");
            if(barcode.equals(currentPromotion[0])){
                discount = Double.parseDouble(currentPromotion[1])/100;
            }
        }
        return discount;
    }
    private ArrayList<String> getDiscountPromotion(){

        ArrayList<String> promotionText = new ArrayList<String>();
        try {
            File discountPromotion = new File("src/main/resources/discount_promotion.txt");
            FileReader discountPromotionReader = new FileReader(discountPromotion);
            BufferedReader reader = new BufferedReader(discountPromotionReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                promotionText.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
//        System.out.println(promotionText);
        return promotionText;
    }
}
