package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

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
        OrderReceipt receipt = new OrderReceipt(new Order(null, lineItems, LocalDateTime.now()));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("--------------------"));
        assertThat(output, containsString("税额\t6.5"));
        assertThat(output, containsString("总价\t71.5"));
    }

}