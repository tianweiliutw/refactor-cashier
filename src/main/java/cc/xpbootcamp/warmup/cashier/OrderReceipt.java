package cc.xpbootcamp.warmup.cashier;

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
        printOrderInfo(output);
        double[] results = processLineItems(output);
        printTotal(output, results[0], results[1]);
    }

    private void printHeader(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }

    private void printOrderInfo(StringBuilder output) {
        if (order.getCustomer() != null) {
            output.append(order.getCustomer().getName());
            output.append(order.getCustomer().getAddress());
        }
    }

    private double[] processLineItems(StringBuilder output) {
        double totalSalesTax = 0d;
        double subTotal = 0d;

        for (LineItem lineItem : order.getLineItems()) {

            printLineItem(lineItem, output);

            double salesTax = lineItem.getSalesTax();
            totalSalesTax += salesTax;
            subTotal += lineItem.getSubTotal();
        }

        return new double[] { totalSalesTax, subTotal };
    }

    private void printLineItem(LineItem lineItem, StringBuilder output) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private void printTotal(StringBuilder output, double totalSalesTax, double subTotal) {
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(subTotal);
    }
}
