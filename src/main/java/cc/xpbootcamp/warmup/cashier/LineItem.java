package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String desc;
	private double price;
	private int qty;
	private double taxRate;

	public LineItem(String desc, double price, int qty, double taxRate) {
		super();
		this.desc = desc;
		this.price = price;
		this.qty = qty;
		this.taxRate = taxRate;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return qty;
	}

    double totalAmount() {
        return price * qty;
    }

    double getSalesTax() { return totalAmount() * taxRate; }

    double getSubTotal() { return totalAmount() + getSalesTax(); }
}