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
        printOrderInfo(output);
        printLineItemsAndSubtotal(output);
    }

    private void printOrderInfo(StringBuilder output) {
        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        if (order.getCustomer() != null) {
            output.append(order.getCustomer().getName());
            output.append(order.getCustomer().getAddress());
//            output.append(order.getCustomerLoyaltyNumber());
        }
    }

    private void printLineItemsAndSubtotal(StringBuilder output) {
        // prints lineItems
        double totalSalesTax = 0d;
        double subTotal = 0d;
        for (LineItem lineItem : order.getLineItems()) {

            printLineItem(lineItem, output);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.getSalesTax();
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            subTotal += lineItem.getSubTotal();
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(subTotal);
    };

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
}