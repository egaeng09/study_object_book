package chapter11.phone.trait;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<Call> calls;

    public Phone() {
        this.calls = new ArrayList<>();
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);

    protected Money afterCalculated(Money fee) {
        return fee;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }
}
