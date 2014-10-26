package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Promotion {

    private ArrayList<String> promotion = new ArrayList<String>();
    private ArrayList<String> promotionText = new ArrayList<String>();

    public Promotion() {
    }


    public ArrayList<String> getPromotion(String barcode) {
        generatePromotions(barcode);
        return promotion;
    }

    private void generatePromotions(String barcode) {
        ArrayList<Path> promotionLocations = new ArrayList<Path>();
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "buy_two_get_one_free_promotion.txt"));
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "second_half_price_promotion.txt"));
        promotionLocations.add(FileSystems.getDefault().getPath("src/main/resources/", "discount_promotion.txt"));

        for (int i = 0; i < promotionLocations.size(); i++) {
            generateOnePromotion(promotionLocations, i, barcode);
        }
    }

    private void generateOnePromotion(ArrayList<Path> promotionLocations, int i, String barcode) {
        ArrayList<String> promotionNames = new ArrayList<String>();
        promotionNames.add("buy_two_get_one_free_promotion");
        promotionNames.add("second_half_price_promotion");
        promotionNames.add("discount_promotion");

        try {
            promotionText = (ArrayList<String>) Files.readAllLines(promotionLocations.get(i));

            ArrayList<String> barcodes = splitPromotionText();
            boolean isExist = barcodes.contains(barcode);
            if (isExist) {
                promotion.add(promotionNames.get(i));
            }
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
    }

    private ArrayList<String> splitPromotionText(){
        ArrayList<String> barcodes = new ArrayList<String>();

        for(String aPromotionText: promotionText){
            String[] barcodeAndDiscount = aPromotionText.split(":");
            barcodes.add(barcodeAndDiscount[0]);
        }
        return barcodes;
    }
}
