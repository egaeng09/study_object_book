package chapter14.phone;

import chapter11.phone.composition.NightlyDiscountPolicy;
import chapter11.phone.composition.Phone;
import chapter11.phone.composition.RateDiscountablePolicy;
import chapter11.phone.composition.RegularPolicy;
import chapter11.phone.composition.TaxablePolicy;
import chapter4.Money;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        chapter11.phone.composition.Phone 일반요금 = new chapter11.phone.composition.Phone(
                new RegularPolicy(
                        Money.wons(10),
                        Duration.ofSeconds(10)
                )
        );

        chapter11.phone.composition.Phone 심야요금 = new chapter11.phone.composition.Phone(
                new NightlyDiscountPolicy(
                        Money.wons(10),
                        Money.wons(5),
                        Duration.ofSeconds(10)
                )
        );

        chapter11.phone.composition.Phone 일반요금_세금적용 = new chapter11.phone.composition.Phone(
                new TaxablePolicy(
                        new RegularPolicy(
                                Money.wons(10),
                                Duration.ofSeconds(10)
                        ),
                        0.1
                )
        );

        chapter11.phone.composition.Phone 일반요금_기본할인_세금적용 = new chapter11.phone.composition.Phone(
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

        chapter11.phone.composition.Phone 일반요금_세금적용_기본할인 = new chapter11.phone.composition.Phone(
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

        chapter11.phone.composition.Phone 심야요금_기본할인_세금적용 = new Phone(
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
