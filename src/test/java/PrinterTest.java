import com.thoughtworks.iamcoach.pos.CartItem;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrinterTest {
    @Test
    public void can_print_all_info(){
        ArrayList<CartItem> cartItems = mockCartItem();
        CartItem cartItem = cartItems.get(0);

        String printText = "        ********Let's Go 购物清单*********" + "\n"
                + "----------------------------------------------------------" + "\n"
                + printDate() + "\n"
                + "************************************************" + "\n"
                + "名称：" + cartItem.getName() + "   数量：" + cartItem.getNum()
                + "   单价：" + cartItem.getPrice() + "元" + "   单位：" + cartItem.getUnit()
                + "   小计：" + cartItem.getSubTotal() + "元" + "\n"
                + "************************************************" + "\n"
                + "优惠前：" + 25.0 + "元" + "   优惠金额：" + 5.0 + "元" + "   总计：" + 20.0 + "元" + "\n"
                + "----------------------------------------------------------";
        Printer printer = new Printer(cartItems);
        assertThat(printer.printAllInfo()).isEqualTo(printText);
    }

    private ArrayList<CartItem> mockCartItem (){
        CartItem cartItem = mock(CartItem.class);
        when(cartItem.getName()).thenReturn("橙汁");
        when(cartItem.getBarcode()).thenReturn("ITEM000001");
        when(cartItem.getPrice()).thenReturn(5.00);
        when(cartItem.getUnit()).thenReturn("瓶");
        when(cartItem.getNum()).thenReturn(5.0);
        when(cartItem.getSubTotal()).thenReturn(20.0);

        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);
        return cartItems;
    }

    private String printDate(){
        Date dateAndTime = new Date();

        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(dateAndTime);
        String time = String.format("%tr", dateAndTime);

        return "          " + date + "    " + time;
    }
}
