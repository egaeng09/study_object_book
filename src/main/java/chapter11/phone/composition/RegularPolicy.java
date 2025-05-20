package chapter11.phone.composition;

import chapter11.phone.Call;
import chapter4.Money;
import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
    private Money amount;
    private Duration seconds;

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
