package chapter14.phone;

import chapter4.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
