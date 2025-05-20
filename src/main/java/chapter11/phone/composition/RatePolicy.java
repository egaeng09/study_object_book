package chapter11.phone.composition;

import chapter4.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
