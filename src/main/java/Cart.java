
import java.util.ArrayList;

public class Cart {

    public ArrayList<String> barcodeArray = new ArrayList<String>();
    private ArrayList<Item> items = new ArrayList<Item>();


    public Cart(ArrayList<Item> items, ArrayList<String> inputs) {
        this.items = items;
        this.getBarcodes(inputs);
        this.getNumber();
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
                barcodeArray.add(barcode);
//                System.out.println(barcodeArray);
            }
        }
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