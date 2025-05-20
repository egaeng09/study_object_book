package chapter11.phone.composition;

import chapter4.Money;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        Phone 일반요금 = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        Phone 심야요금 = new Phone(new NightlyDiscountPolicy(Money.wons(10), Money.wons(5), Duration.ofSeconds(10)));
    }
}
