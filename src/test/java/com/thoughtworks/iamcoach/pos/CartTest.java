package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartTest {

    private Item mock_Item(){
        Item item = mock(Item.class);
        when(item.getName()).thenReturn("橙汁");
        when(item.getBarcode()).thenReturn("ITEM000001");
        when(item.getPrice()).thenReturn(5.00);
        when(item.getUnit()).thenReturn("瓶");

        return item;
    }

    private CartItem mock_CartItem(){
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getName()).thenReturn("橙汁");
        when(cartItem.getBarcode()).thenReturn("ITEM000001");
        when(cartItem.getPrice()).thenReturn(5.00);
        when(cartItem.getUnit()).thenReturn("瓶");
        when(cartItem.getNum()).thenReturn(5.0);

        return cartItem;
    }

    @Test
    public void can_get_cartItems(){
        ArrayList<String> inputs = new ArrayList<String>();
        inputs.add("ITEM000001-2");

        Item item = this.mock_Item();

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);

        Cart cart = new Cart(inputs, items);
        assertThat(cart.getCartItems().size()).isEqualTo(1);
        assertThat(cart.getCartItems().get(0).getNum()).isEqualTo(2);
    }

    @Test
    public void can_set_cartItems(){
        ArrayList<String> inputs = new ArrayList<String>();
        inputs.add("ITEM000001-2");

        Item item = this.mock_Item();
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);

        CartItem cartItem = this.mock_CartItem();
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);

        Cart cart = new Cart(inputs, items);
        cart.setCartItems(cartItems);

        assertThat(cart.getCartItems().size()).isEqualTo(1);
        assertThat(cart.getCartItems().get(0).getNum()).isEqualTo(5.0);
    }

}
