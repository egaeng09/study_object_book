package chapter13.phone;

import chapter11.phone.Call;
import chapter11.phone.composition.Phone;
import chapter11.phone.composition.RatePolicy;
import chapter4.Money;

public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
