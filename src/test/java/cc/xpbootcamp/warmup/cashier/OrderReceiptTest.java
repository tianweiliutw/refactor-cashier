package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order(new Customer("Mr X", "Chicago, 60601"), new ArrayList<LineItem>(), LocalDateTime.now());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    void shouldPrintOrderDate() {
        Order order = new Order(null, new ArrayList<LineItem>(), LocalDateTime.of(2020, 7, 16, 18, 0, 0));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年07月16日，星期四"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2, 0.1d));
            add(new LineItem("biscuits", 5.0, 5, 0.1d));
            add(new LineItem("chocolate", 20.0, 1, 0.1d));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, lineItems, LocalDateTime.of(2020, 7, 16, 18, 0, 0)));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("--------------------"));
        assertThat(output, containsString("税额\t6.5"));
        assertThat(output, containsString("总价\t71.5"));
        assertThat(output, not(containsString("折扣")));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxAndDiscountInformationOnWednesdays() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2, 0.1d));
            add(new LineItem("小白菜", 10.0, 1, 0.1d));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, lineItems, LocalDateTime.of(2020, 7, 15, 18, 0, 0)));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力\t21.5\t2\t43.0\n"));
        assertThat(output, containsString("小白菜\t10.0\t1\t10.0\n"));
        assertThat(output, containsString("--------------------"));
        assertThat(output, containsString("税额\t5.3"));
        assertThat(output, containsString("折扣\t1.17"));
        assertThat(output, containsString("总价\t57.13"));
    }

}