package chapter10;

import chapter4.Money;
import java.time.Duration;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(
                LocalDateTime.of(2025, 1, 1, 1, 1, 0),
                LocalDateTime.of(2025, 1, 1, 1, 2, 0)
        ));
        phone.call(new Call(
                LocalDateTime.of(2025, 1, 1, 1, 1, 0),
                LocalDateTime.of(2025, 1, 1, 1, 2, 0)
        ));

        phone.calculateFee(); // Equals : Money.wons(60)
    }
}
