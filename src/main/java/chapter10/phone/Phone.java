package chapter10.phone;

import chapter4.Money;
import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<Call> calls;
    private double taxRate;

    public Phone(double taxRate) {
        this.calls = new ArrayList<>();
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(result.times(taxRate));
    }

    abstract protected Money calculateCallFee(Call call);


    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
