package chapter10;

import chapter4.Money;
import java.time.Duration;

public class NightlyDiscountPhone extends Phone {
    public NightlyDiscountPhone(Money nightlyAmount, Money reqularAmount, Duration seconds, double taxRate) {
        super(nightlyAmount, reqularAmount, seconds, taxRate);
    }

    @Override
    public Money calculateFee() {
        Money result = super.calculateFee();

        Money nightlyAmount = Money.ZERO;

        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyAmount = nightlyAmount.plus(
                        getAmount().minus(nightlyAmount)
                                .times((double) call.getDuration().getSeconds() / getSeconds().getSeconds())
                );
            }
        }
        return result.minus(nightlyAmount.plus(nightlyAmount.times(getTaxRate())));
    }
}
