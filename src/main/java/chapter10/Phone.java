package chapter10;

import chapter4.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    protected static final int LATE_NIGHT_HOUR = 22;

    enum PhoneType {
        REGULAR,
        NIGHTLY
    }

    private PhoneType type;

    private Money amount;
    private Money nightlyAmount;
    private Money reqularAmount;
    private Duration seconds;
    private List<Call> calls;
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds, taxRate);
    }

    public Phone(Money nightlyAmount, Money reqularAmount, Duration seconds, double taxRate) {
        this(PhoneType.REGULAR, Money.ZERO, nightlyAmount, reqularAmount, seconds, taxRate);
    }

    public Phone(PhoneType type, Money amount, Money nightlyAmount, Money reqularAmount, Duration seconds, double taxRate) {
        this.type = type;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.reqularAmount = reqularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
        this.calls = new ArrayList<>();
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == PhoneType.REGULAR) {
                result = result.plus(
                        amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
            }
            else {
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(
                            nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
                }
                else {
                    result = result.plus(
                            reqularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }

        }
        return result.plus(result.times(taxRate));
    }
}
