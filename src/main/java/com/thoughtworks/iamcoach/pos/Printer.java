package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Printer {
    public ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Printer(ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    public void printAllCartItems(){

        for(int i=0; i<cartItems.size(); i++){
            System.out.println("名称：" + cartItems.get(i).name + "   数量：" + cartItems.get(i).num
                    + "   单价：" + cartItems.get(i).price + "   单位：" + cartItems.get(i).unit
                    + "   小计：" + cartItems.get(i).getSubTotal()
            );

        }

    }


}
