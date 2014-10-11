package com.thoughtworks.iamcoach.pos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    public ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Printer(ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    public void printAllInfo(){
        printShopName();
        printDate();
        printAllCartItems();
        printTotal();
    }

    public void printShopName(){
        System.out.println("        ********Let's Go 购物清单*********");
        System.out.println("----------------------------------------------------------");
    }

    public void printDate(){
        Date date = new Date();

        String time = String.format("%tr", date);
        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String s = format1.format(date);

        System.out.println(s + "    " + time);
    }

    public void printAllCartItems(){
        System.out.println("************************************************");
        for(int i=0; i<cartItems.size(); i++){
            System.out.println("名称：" + cartItems.get(i).getName() + "   数量：" + cartItems.get(i).num
                    + "   单价：" + cartItems.get(i).getPrice() + "元" + "   单位：" + cartItems.get(i).getUnit()
                    + "   小计：" + cartItems.get(i).getSubTotal() + "元"
            );
        }
        System.out.println("************************************************");
    }

    private void printTotal(){

        System.out.println("优惠前：" + getTotal() + "元");
        System.out.println("优惠金额：" + (getTotal() - getActutalTotal()) + "元");
        System.out.println("总计：" + getActutalTotal() + "元");
        System.out.println("----------------------------------------------------------");
    }

    private double getActutalTotal(){

        double actutalTotal = 0;
        for(int i=0; i<cartItems.size(); i++){
            actutalTotal += cartItems.get(i).getSubTotal();
        }
        return actutalTotal;
    }

    private double getTotal(){

        double total = 0;
        for(int i=0; i<cartItems.size(); i++){
            double actualSubTotal = cartItems.get(i).num * cartItems.get(i).getPrice();
            total += actualSubTotal;
        }
        return total;
    }
}
