import com.thoughtworks.iamcoach.pos.BarcodeProcessor;
import com.thoughtworks.iamcoach.pos.CartItem;
import com.thoughtworks.iamcoach.pos.Item;
import com.thoughtworks.iamcoach.pos.Printer;

import java.io.*;
import java.util.ArrayList;

public class App {


    public static ArrayList<String> inputs = new ArrayList<String>();

    public static ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public static void main(String[] args){

        ArrayList<Item> items = getItems();
        getInputs();
        BarcodeProcessor barcodeProcessor = new BarcodeProcessor(inputs, items);

        double[] numbers = barcodeProcessor.getNumbers();
        CartItem cartItem = new CartItem(items.get(0), numbers[0]);
        cartItems.add(cartItem);

        Printer printer = new Printer(cartItems);
        printer.printAllInfo();
    }

    private static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("ITEM000001", "橙汁", "瓶", 5.00));
        items.add(new Item("ITEM000002", "可乐", "瓶", 3.00));
        items.add(new Item("ITEM000003", "苹果", "斤", 4.50));
        items.add(new Item("ITEM000004", "雪碧", "瓶", 5.00));
        items.add(new Item("ITEM000005", "方便面", "袋", 2.50));

        return items;
    }

    private static void getInputs(){
        try {
            File cartLocation = new File("src/main/resources/cart.txt");
            FileReader cartReader = new FileReader(cartLocation);
            BufferedReader reader = new BufferedReader(cartReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                inputs.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
    }


}
