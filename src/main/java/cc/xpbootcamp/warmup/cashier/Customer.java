package cc.xpbootcamp.warmup.cashier;

public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void Print(StringBuilder output) {
        output.append(this.name);
        output.append(this.address);
    }
}
