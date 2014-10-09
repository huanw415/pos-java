import java.io.*;
import java.util.ArrayList;

public class Item {

    public String barcode;
    public String name;
    public String unit;
    public double price;
    public ArrayList<String> promotion;
    private ArrayList<String> promotionItems;

    item(String barcode, String name, String unit, String price){
        barcode = barcode;
        name = name;
        unit = unit;
        price = price;
    }
    public void getPromotion(){

        try{
            File promotion1 = new File("buy_two_get_one_free_promotion.txt");
            FileReader promotion1Reader = new FileReader(promotion1);
            BufferedReader reader1 = new BufferedReader(promotion1Reader);

            String line = null;
            while((line = reader1.readLine()) != null){
                promotionItems.add(line);
            }
            boolean isExist = promotionItems.contains(barcode);
            if(isExist){
                promotion.add("buy_two_get_one_free_promotion");
            }
        }catch(IOException ex){
            System.out.println("fail read file!");
        }

    }


}
