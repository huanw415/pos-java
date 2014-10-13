package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {
    @Test


    public void can_get_arguments_value() {
        Item item = new Item("ITEM000001", "橙汁", "瓶", 5.00);
        assertThat(item.getName()).isEqualTo("橙汁");
        assertThat(item.getBarcode()).isEqualTo("ITEM000001");
        assertThat(item.getUnit()).isEqualTo("瓶");
        assertThat(item.getPrice()).isEqualTo(5.00);
        assertThat(item.getPromotion().get(0)).isEqualTo("buy_two_get_one_free_promotion");
    }



//    public void should_be_mock() {
//        HelloWorld helloWorld = mock(HelloWorld.class);
//        when(helloWorld.beenCalled()).thenReturn("Hello World");
//
//        assertThat(helloWorld.beenCalled()).isEqualTo("Hello World");
//    }

}
