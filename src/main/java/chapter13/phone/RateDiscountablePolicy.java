package chapter13.phone;

import chapter11.phone.composition.AdditionalRatePolicy;
import chapter11.phone.composition.RatePolicy;
import chapter4.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

    private Money discountAmount;

    public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
