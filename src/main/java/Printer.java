import com.thoughtworks.iamcoach.pos.CartItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

    public Printer(ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    public String printAllInfo(){
        return printShopName() + "\n"
                + printDate() + "\n"
                + printAllCartItems() + "\n"
                + printTotal();
    }

    private String printShopName() {
        return "        ********Let's Go 购物清单*********" + "\n"
                + "----------------------------------------------------------";
    }

    private String printDate(){
        Date dateAndTime = new Date();

        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(dateAndTime);
        String time = String.format("%tr", dateAndTime);

        return "          " + date + "    " + time;
    }

    private String printAllCartItems(){
        String allCartItems = "************************************************" + "\n";
        for (CartItem cartItem : cartItems) {
            allCartItems += "名称：" + cartItem.getName() + "   数量：" + cartItem.getNum()
                    + "   单价：" + cartItem.getPrice() + "元" + "   单位：" + cartItem.getUnit()
                    + "   小计：" + cartItem.getSubTotal() + "元" +"\n";

        }
        return allCartItems +="************************************************" + "\n";
    }

    private String printTotal(){

        return  "优惠前：" + getTotal() + "元"
                + "   优惠金额：" + (getTotal() - getActutalTotal()) + "元"
                + "   总计：" + getActutalTotal() + "元" + "\n"
                + "----------------------------------------------------------";
    }

    private double getActutalTotal(){

        double actutalTotal = 0;
        for(int i=0; i<cartItems.size(); i++){
            actutalTotal += cartItems.get(i).getSubTotal();
        }
        return actutalTotal;
    }

    private double getTotal(){

        double total = 0;
        for(int i=0; i<cartItems.size(); i++){
            double actualSubTotal = cartItems.get(i).getNum() * cartItems.get(i).getPrice();
            total += actualSubTotal;
        }
        return total;
    }
}
