import java.util.ArrayList;

public class App {

    static ArrayList<Item> items = new ArrayList<Item>();

    public static void main(String[] args) {
        initItems();
    }
    static void initItems(){
        Item item1 = new Item("ITEM00001", "橙汁", "瓶", 5.00);
        Item item2 = new Item("ITEM00002", "可乐", "瓶", 3.00);
        Item item3 = new Item("ITEM00003", "苹果", "斤", 4.50);
        Item item4 = new Item("ITEM00004", "雪碧", "瓶", 5.00);
        Item item5 = new Item("ITEM00005", "方便面", "袋", 2.50);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
//        for(Item item: items){
//            System.out.println(item.name);
//        }
    }
}
