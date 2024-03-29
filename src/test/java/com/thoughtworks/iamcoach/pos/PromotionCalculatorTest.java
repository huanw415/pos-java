package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionCalculatorTest {
    @Test
    public void can_caLculate_buy_two_get_one_free_promotion(){
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getName()).thenReturn("橙汁");
        when(cartItem.getBarcode()).thenReturn("ITEM000001");
        when(cartItem.getPrice()).thenReturn(5.00);
        when(cartItem.getUnit()).thenReturn("瓶");
        when(cartItem.getNum()).thenReturn(5.0);

        BuyTwoOneFreeCalculator buyTwoOneFreeCalculator = new BuyTwoOneFreeCalculator();
        assertThat(buyTwoOneFreeCalculator.calculatePromotion(cartItem)).isEqualTo(20.0);
    }

    @Test
    public void can_caLculate_second_half_price_promotion(){
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getName()).thenReturn("橙汁");
        when(cartItem.getBarcode()).thenReturn("ITEM000001");
        when(cartItem.getPrice()).thenReturn(5.00);
        when(cartItem.getUnit()).thenReturn("瓶");
        when(cartItem.getNum()).thenReturn(5.0);

        SecondHalfCalculator secondHalfCalculator = new SecondHalfCalculator();
        assertThat(secondHalfCalculator.calculatePromotion(cartItem)).isEqualTo(20.00);
    }
    @Test
    public void can_caLculate_discount_promotion(){
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getName()).thenReturn("橙汁");
        when(cartItem.getBarcode()).thenReturn("ITEM000001");
        when(cartItem.getPrice()).thenReturn(5.00);
        when(cartItem.getUnit()).thenReturn("瓶");
        when(cartItem.getNum()).thenReturn(5.0);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        assertThat(discountCalculator.calculatePromotion(cartItem)).isEqualTo(18.75);
    }
}
