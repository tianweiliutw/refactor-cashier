package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;

public class Discount {
    static final double DISCOUNT_RATE = 0.02d;

    public static double Decide(double subTotal, Order order) {
        LocalDateTime timestamp = order.getTimestamp();
        if (timestamp.getDayOfWeek().getValue() == 3) {
            double discount = subTotal * DISCOUNT_RATE;
            return Math.round(discount * 100d) / 100d;
        }
        return 0d;
    }
}
