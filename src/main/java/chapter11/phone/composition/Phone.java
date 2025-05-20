package chapter11.phone.composition;

import chapter11.phone.Call;
import chapter4.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls;

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
        this.calls = new ArrayList<>();
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }
}
