package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.Date;

public class Printer {
    public ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Printer(ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    public void printShopName(){
        System.out.println("        ********Let's Go 购物清单*********");
    }
    public void printDate(){
        Date date = new Date();
        System.out.println(date);
    }
    public void printAllCartItems(){
        System.out.println("************************************************");
        for(int i=0; i<cartItems.size(); i++){
            System.out.println("名称：" + cartItems.get(i).name + "   数量：" + cartItems.get(i).num
                    + "   单价：" + cartItems.get(i).price + "   单位：" + cartItems.get(i).unit
                    + "   小计：" + cartItems.get(i).getSubTotal()
            );
        }
        System.out.println("************************************************");
    }

    public void printTotal(){

        double actutaTotal = 0;
        for(int i=0; i<cartItems.size(); i++){
            actutaTotal += cartItems.get(i).getSubTotal();
        }

        double total = 0;
        for(int i=0; i<cartItems.size(); i++){
            double actualSubTotal = cartItems.get(i).num * cartItems.get(i).price;
            total += actualSubTotal;
        }

        System.out.println("优惠前：" + total);
        System.out.println("优惠金额：" + (total - actutaTotal));
        System.out.println("总计：" + actutaTotal);
    }
}
