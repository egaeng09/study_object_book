package chapter14.phone;

import chapter11.phone.composition.Phone;
import chapter11.phone.composition.RatePolicy;
import chapter4.Money;

public abstract class AdditionalRatePolicy implements chapter11.phone.composition.RatePolicy {

    private chapter11.phone.composition.RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
