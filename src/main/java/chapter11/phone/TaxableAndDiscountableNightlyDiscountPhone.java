package chapter11.phone;

import chapter4.Money;
import java.time.Duration;

public class TaxableAndDiscountableNightlyDiscountPhone extends TaxableNightlyDiscountPhone {

    private Money discountAmount;

    public TaxableAndDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount, double taxRate) {
        super(nightlyAmount, regularAmount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
