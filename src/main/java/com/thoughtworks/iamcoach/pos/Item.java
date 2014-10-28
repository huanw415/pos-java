package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Item {

    private String barcode;
    private String name;
    private String unit;
    private double price;
//    private ArrayList<String> promotion = new ArrayList<String>();

    public Item(String barcode, String name, String unit, double price){
        this.setBarcode(barcode);
        this.setName(name);
        this.setUnit(unit);
        this.setPrice(price);
//        Promotion promotion = new Promotion();
//        this.promotion = promotion.getPromotion(barcode);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public String getUnit(){
        return this.unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }

//    public ArrayList<String> getPromotion(){
//        return this.promotion;
//    }
}
