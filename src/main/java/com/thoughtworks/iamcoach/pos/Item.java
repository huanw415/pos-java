package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.util.ArrayList;

public class Item {

    public String barcode;
    public String name;
    public String unit;
    public double price;
    public ArrayList<String> promotion = new ArrayList<String>();
    private ArrayList<String> promotionText = new ArrayList<String>();

    public Item(String barcode, String name, String unit, double price){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.getPromotions();
    }
    
    public void getPromotions() {
        ArrayList<String> promotionLocations = new ArrayList<String>();
        promotionLocations.add("src/main/resources/buy_two_get_one_free_promotion.txt");
        promotionLocations.add("src/main/resources/second_half_price_promotion.txt");
        promotionLocations.add("src/main/resources/discount_promotion.txt");

        for (int i = 0; i < promotionLocations.size(); i++) {
            getOnePromotion(promotionLocations, i);
        }
    }
    
    private void getOnePromotion(ArrayList<String> promotionLocations, int i) {

        ArrayList<String> promotionNames = new ArrayList<String>();
        promotionNames.add("buy_two_get_one_free_promotion");
        promotionNames.add("second_half_price_promotion");
        promotionNames.add("discount_promotion");

        try {
            File promotionLocation = new File(promotionLocations.get(i));
            FileReader promotionReader = new FileReader(promotionLocation);
            BufferedReader reader = new BufferedReader(promotionReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                promotionText.add(line);
            }
            
            boolean isExist = promotionText.contains(barcode);
            if (isExist) {
                promotion.add(promotionNames.get(i));
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
    }   
}
