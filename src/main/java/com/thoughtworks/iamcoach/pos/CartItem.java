package com.thoughtworks.iamcoach.pos;

public class CartItem extends Item{
    public double num;
    public double subTotal;

    CartItem(Item item){
       super(item.barcode, item.name, item.unit, item.price);
    }

}
