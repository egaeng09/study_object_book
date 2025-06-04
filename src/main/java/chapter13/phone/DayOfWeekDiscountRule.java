package chapter13.phone;

import chapter4.Money;
import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks;
    private Duration duration;
    private Money amount;

    public DayOfWeekDiscountRule() {
        this.dayOfWeeks = new ArrayList<>();
        this.duration = Duration.ZERO;
        this.amount = Money.ZERO;
    }

    public DayOfWeekDiscountRule(final List<DayOfWeek> dayOfWeeks, final Duration duration, final Money amount) {
        this.dayOfWeeks = dayOfWeeks;
        this.duration = duration;
        this.amount = amount;
    }

    public Money calculate(DateTimeInterval interval) {
        if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
            return amount.times((double) interval.duration().getSeconds() / duration.getSeconds())
        }
        return Money.ZERO;
    }
}
