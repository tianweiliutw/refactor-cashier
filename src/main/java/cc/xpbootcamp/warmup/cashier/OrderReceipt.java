package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printOrder(output);

        return output.toString();
    }

    private void printOrder(StringBuilder output) {
        printHeader(output);
        order.Print(output);
    }

    private void printHeader(StringBuilder output) {
        output.append("====== 老王超市，值得信赖 ======\n");
    }
}
