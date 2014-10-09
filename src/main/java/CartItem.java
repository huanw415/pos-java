import java.io.*;
import java.util.ArrayList;

public class CartItem extends Item{
    public double num;
    public double subTotal;

    CartItem(Item item){
       super(item.barcode, item.name, item.unit, item.price);

    }

}
