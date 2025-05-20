package chapter11.phone.inheritance;

import chapter4.Money;
import java.time.Duration;

public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {

    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
