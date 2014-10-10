package com.thoughtworks.iamcoach.pos;
import java.util.ArrayList;

public class Cart {

    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<String> barcodeArray = new ArrayList<String>();

    public Cart(ArrayList<Item> items, ArrayList<String> inputs) {
        this.items = items;

        BarcodeProcessor barcodeProcessor = new BarcodeProcessor(inputs);
        this.barcodeArray = barcodeProcessor.barcodes;

        this.getNumber();
    }

    private void getNumber(){
        for(int i = 0; i < items.size(); i++){
            for(int j = 0; j < barcodeArray.size(); j++){
                if(items.get(i).barcode.equals(barcodeArray.get(j))){
                    CartItem cartItem = new CartItem(items.get(i));
                    System.out.println(cartItem.barcode);
                }
            }
        }
    }
}