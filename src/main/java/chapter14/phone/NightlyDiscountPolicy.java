package chapter14.phone;

import chapter11.phone.Call;
import chapter11.phone.composition.BasicRatePolicy;
import chapter4.Money;
import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
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
