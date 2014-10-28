package com.thoughtworks.iamcoach.pos;

public class SecondHalfCalculator extends PromotionCalculator{
    @Override
    public double calculatePromotion(CartItem cartItem) {
        double promotionNumber = ((int) cartItem.getNum())/2;
        double actualNumber = (cartItem.getNum() - promotionNumber) + promotionNumber/2;
        return actualNumber * cartItem.getPrice();
    }
}
