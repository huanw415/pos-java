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
                   numbers[i] +=  processSplitedBarcode(i, j);
                }else{
                    if(items.get(i).barcode.equals(inputs.get(j))){
                        numbers[i] += 1;
                    }
                }
            }
        }
//        System.out.println(numbers[2]);
        return numbers;
    }

    private double processSplitedBarcode(int i, int j){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).barcode.equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }
}

