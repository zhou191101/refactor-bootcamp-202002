package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationWithoutWednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50d, 2));
            add(new LineItem("小白菜", 10.00d, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();
        assertThat(output, containsString("===== 老王超市，值得信赖 ======\n"));
        assertThat(output, containsString(DateUtils.getNowTime() + "，" + DateUtils.getNowWeek() + "\n"));
        assertThat(output, containsString("巧克力, 21.5 x 2, 43.0\n"));
        assertThat(output, containsString("小白菜, 10.0 x 1, 10.0\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额：5.30\n"));
        assertThat(output, containsString("总价：58.30"));


    }


    @Test
    public void shouldPrintLineItemAndSalesTaxInformationWithWednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50d, 2));
            add(new LineItem("小白菜", 10.00d, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, "2020年02月19日", "星期三"));

        String output = receipt.printReceipt();
        assertThat(output, containsString("===== 老王超市，值得信赖 ======\n"));
        assertThat(output, containsString("2020年02月19日，星期三\n"));
        assertThat(output, containsString("巧克力, 21.5 x 2, 43.0\n"));
        assertThat(output, containsString("小白菜, 10.0 x 1, 10.0\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额：5.30\n"));
        assertThat(output, containsString("折扣：1.17\n"));
        assertThat(output, containsString("总价：57.13"));

    }
}