package chapter11.phone;

import chapter4.Money;
import java.time.Duration;

public class RateDiscountableRegularPhone extends RegularPhone {

    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
