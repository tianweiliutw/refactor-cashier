package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<LineItem> lineItemList;

    public Order(Customer customer, List<LineItem> lineItemList) {
        this.customer = customer;
        this.lineItemList = lineItemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
