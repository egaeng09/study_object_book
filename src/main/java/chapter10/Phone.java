package chapter10;

import chapter4.Money;
import java.time.Duration;

public class Phone extends AbstractPhone {

    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return null;
    }
}
