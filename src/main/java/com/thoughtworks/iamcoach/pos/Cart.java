package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Cart(ArrayList<String> inputs, ArrayList<Item> items){
        this.setCartItems(this.generateCartItems(inputs, items));
    }

    public ArrayList<CartItem> getCartItems(){
        return this.cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    private ArrayList<CartItem> generateCartItems(ArrayList<String> inputs, ArrayList<Item> items){
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        double[] numbers = getNumbers(inputs, items);

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0){
                cartItems.add(new CartItem(items.get(i), numbers[i]));
            }
        }
        return cartItems;
    }

    private double[] getNumbers(ArrayList<String> inputs, ArrayList<Item> items) {
        double numbers[] = new double[items.size()];

        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){
                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                   numbers[i] +=  processSplitedBarcode(i, j, inputs, items);
                }else{
                    numbers[i] += processBarcode(i, j, inputs, items);
                }
            }
        }
        return numbers;
    }

    private double processSplitedBarcode(int i, int j, ArrayList<String> inputs, ArrayList<Item> items){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).getBarcode().equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }

    private double processBarcode(int i, int j, ArrayList<String> inputs, ArrayList<Item> items){
        if(items.get(i).getBarcode().equals(inputs.get(j))){
            return 1.0;
        }
        return 0.0;
    }
}

