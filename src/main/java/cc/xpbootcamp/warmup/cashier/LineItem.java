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

	public void Print(StringBuilder output) {
		output.append(this.desc);
		output.append('\t');
		output.append(this.price);
		output.append('\t');
		output.append(this.qty);
		output.append('\t');
		output.append(this.totalAmount());
		output.append('\n');
	}

    double totalAmount() {
        return price * qty;
    }

    double getSalesTax() { return totalAmount() * taxRate; }

    double getSubTotal() { return totalAmount() + getSalesTax(); }
}