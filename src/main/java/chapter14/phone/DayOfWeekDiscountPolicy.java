package chapter14.phone;

import chapter4.Money;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
    private List<DayOfWeekDiscountRule> rules;

    public DayOfWeekDiscountPolicy() {
        this.rules = new ArrayList<>();
    }

    public DayOfWeekDiscountPolicy(final List<DayOfWeekDiscountRule> rules) {
        this.rules = rules;
    }

    @Override
    protected Money calculateCallFee(final Call call) {
        Money result = Money.ZERO;

        for (DateTimeInterval interval : call.splitByDay()) {
            for (DayOfWeekDiscountRule rule : rules) {
                result.plus(rule.calculate(interval))
            }
        }

        return result;
    }
}
