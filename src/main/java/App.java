import com.thoughtworks.iamcoach.pos.*;

import java.util.ArrayList;

public class App {

    public static void main(String[] args){

        ArrayList<Item> items = getItems();
        Scanner scanner = new Scanner();
        ArrayList<String> inputs = scanner.getInputs();

        Cart cart = new Cart(inputs, items);

        Printer printer = new Printer(cart.getCartItems());
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

}
