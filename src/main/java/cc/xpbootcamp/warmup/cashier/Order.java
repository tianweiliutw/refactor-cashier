package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private LocalDateTime timestamp;
    private Customer customer;
    private List<LineItem> lineItemList;

    public Order(Customer customer, List<LineItem> lineItemList, LocalDateTime timestamp) {
        this.customer = customer;
        this.lineItemList = lineItemList;
        this.timestamp = timestamp;
    }

    public void Print(StringBuilder output) {
        printTimestamp(output);
        printCustomer(output);
        double[] results = printLineItems(output);
        printTotal(output, results[0], results[1]);
    }

    private void printTimestamp(StringBuilder output) {
        String weekdays = "一二三四五六日";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日，星期");
        int dayOfWeek = timestamp.getDayOfWeek().getValue();
        output.append(dateTimeFormatter.format(timestamp) + weekdays.substring(dayOfWeek - 1, dayOfWeek)).append('\n');
    }

    private void printCustomer(StringBuilder output) {
        if (this.customer != null) {
            this.customer.Print(output);
        }
    }

    private double[] printLineItems(StringBuilder output) {
        double totalSalesTax = 0d;
        double subTotal = 0d;

        for (LineItem lineItem : this.lineItemList) {

            lineItem.Print(output);

            double salesTax = lineItem.getSalesTax();
            totalSalesTax += salesTax;
            subTotal += lineItem.getSubTotal();
        }

        return new double[] { totalSalesTax, subTotal };
    }

    private void printTotal(StringBuilder output, double totalSalesTax, double subTotal) {
        output.append("--------------------");
        output.append("税额").append('\t').append(totalSalesTax);
        output.append("总价").append('\t').append(subTotal);
    }
}
