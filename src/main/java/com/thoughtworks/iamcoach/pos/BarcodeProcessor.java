package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;

public class BarcodeProcessor {

    public ArrayList<String> barcodes = new ArrayList<String>();

    public BarcodeProcessor(ArrayList<String> inputs){
        this.getBarcodes(inputs);
    }

    private void getBarcodes(ArrayList<String> inputs) {
        for(int i = 0; i < inputs.size(); i++) {

            String[] barcodeAndNumber = inputs.get(i).split("-");
            String barcode = barcodeAndNumber[0];
            double number;
            if (barcodeAndNumber.length == 1) {
                number = 1;
            } else {
                number = Double.parseDouble(barcodeAndNumber[1]);
            }

            int count = (int) number;
            for(int j = 0; j < count; j++){
                barcodes.add(barcode);
//                System.out.println(barcodes);
            }
        }
    }

}

