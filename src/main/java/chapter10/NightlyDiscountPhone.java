package chapter10;

import chapter4.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money reqularAmount;
    private Duration seconds;
    private List<Call> calls;

    public NightlyDiscountPhone(Money nightlyAmount, Money reqularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.reqularAmount = reqularAmount;
        this.seconds = seconds;
        this.calls = new ArrayList<>();
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getNightlyAmount() {
        return nightlyAmount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
            }
            else {
                result = result.plus(
                        reqularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }
        return result;
    }
}
