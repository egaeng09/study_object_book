package chapter13.phone;

import chapter11.phone.composition.AdditionalRatePolicy;
import chapter11.phone.composition.RatePolicy;
import chapter4.Money;

public class TaxablePolicy extends AdditionalRatePolicy {

    private double taxRate;

    public TaxablePolicy(RatePolicy next, double taxRate) {
        super(next);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
