package chapter10;

import chapter4.Money;
import java.time.Duration;

public class NightlyDiscountPhone extends AbstractPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
       if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
           return nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
       }
       return regularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
