package chapter11.phone.composition;

import chapter4.Money;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        Phone 일반요금 = new Phone(
                new RegularPolicy(
                        Money.wons(10),
                        Duration.ofSeconds(10)
                )
        );

        Phone 심야요금 = new Phone(
                new NightlyDiscountPolicy(
                        Money.wons(10),
                        Money.wons(5),
                        Duration.ofSeconds(10)
                )
        );

        Phone 일반요금_세금적용 = new Phone(
                new TaxablePolicy(
                        new RegularPolicy(
                                Money.wons(10),
                                Duration.ofSeconds(10)
                        ),
                        0.1
                )
        );

        Phone 일반요금_기본할인_세금적용 = new Phone(
                new TaxablePolicy(
                        new RateDiscountablePolicy(
                                new RegularPolicy(
                                        Money.wons(10),
                                        Duration.ofSeconds(10)
                                ),
                                Money.wons(5)
                        ),
                        0.1
                )
        );

        Phone 일반요금_세금적용_기본할인 = new Phone(
                new RateDiscountablePolicy(
                        new TaxablePolicy(
                                new RegularPolicy(
                                        Money.wons(10),
                                        Duration.ofSeconds(10)
                                ),
                                0.1
                        ),
                        Money.wons(5)
                )
        );

        Phone 심야요금_기본할인_세금적용 = new Phone(
                new RateDiscountablePolicy(
                        new TaxablePolicy(
                                new NightlyDiscountPolicy(
                                        Money.wons(10),
                                        Money.wons(5),
                                        Duration.ofSeconds(10)
                                ),
                                0.1
                        ),
                        Money.wons(10)
                )
        );
    }
}
