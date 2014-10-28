package com.thoughtworks.iamcoach.pos;

public class BuyTwoOneFreeCalculator extends PromotionCalculator{

    @Override
    public double calculatePromotion(CartItem cartItem) {
        double promotionNumber = ((int) cartItem.getNum())/3;
        double actualNumber = cartItem.getNum() - promotionNumber;
        return actualNumber * cartItem.getPrice();
    }
}
