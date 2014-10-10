package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class BarcodeProcessor {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<String> inputs = new ArrayList<String>();

    public BarcodeProcessor(ArrayList<String> inputs, ArrayList<Item> items){
        this.inputs = inputs;
        this.items = items;
    }

    public double[] getNumbers() {

        double numbers[] = new double[items.size()];
        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){

                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                    String[] barcodeAndNumber = inputs.get(j).split("-");
                    if(items.get(i).barcode.equals(barcodeAndNumber[0])){
                        double number = Double.parseDouble(barcodeAndNumber[1]);
                        numbers[i] = number;
                    }
                }else{
                    if(items.get(i).barcode.equals(inputs.get(j))){
                        numbers[i] += 1;
                    }

                }
            }
        }
        return numbers;
    }

}

