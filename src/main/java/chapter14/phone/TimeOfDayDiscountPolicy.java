package chapter14.phone;

import chapter4.Money;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOfDayDiscountPolicy extends BasicRatePolicy {
    private List<LocalTime> starts;
    private List<LocalTime> ends;
    private List<Duration> durations;
    private List<Money> amounts;

    public TimeOfDayDiscountPolicy() {
        this.starts = new ArrayList<>();
        this.ends = new ArrayList<>();
        this.durations = new ArrayList<>();
        this.amounts = new ArrayList<>();
    }

    @Override
    protected Money calculateCallFee(final Call call) {
        Money result = Money.ZERO;
        for (DateTimeInterval interval : call.splitByDay()) {
            for (int loop = 0; loop < starts.size(); loop++) {
                result.plus(amounts.get(loop).times(
                        (double) Duration.between(from(interval, starts.get(loop)), to(interval, ends.get(loop)))
                                .getSeconds() / durations.get(loop).getSeconds()
                ))
            }
        }

        return result;
    }

    private LocalTime to(final DateTimeInterval interval, final LocalTime to) {
        return interval.getTo().toLocalTime().isBefore(to) ? interval.getTo().toLocalTime() : to;
    }

    private LocalTime from(final DateTimeInterval interval, final LocalTime from) {
        return interval.getTo().toLocalTime().isAfter(from) ? interval.getTo().toLocalTime() : from;
    }
}
