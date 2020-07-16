package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<LineItem> lineItemList;

    public Order(Customer customer, List<LineItem> lineItemList) {
        this.customer = customer;
        this.lineItemList = lineItemList;
    }

    public void Print(StringBuilder output) {
        if (this.customer != null) {
            this.customer.Print(output);
        }
        double[] results = printLineItems(output);
        printTotal(output, results[0], results[1]);
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
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(subTotal);
    }
}
