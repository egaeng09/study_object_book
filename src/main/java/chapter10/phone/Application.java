package chapter10.phone;

import chapter4.Money;
import java.time.Duration;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        RegularPhone regularPhone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10));
        regularPhone.call(new Call(
                LocalDateTime.of(2025, 1, 1, 1, 1, 0),
                LocalDateTime.of(2025, 1, 1, 1, 2, 0)
        ));
        regularPhone.call(new Call(
                LocalDateTime.of(2025, 1, 1, 1, 1, 0),
                LocalDateTime.of(2025, 1, 1, 1, 2, 0)
        ));

        regularPhone.calculateFee(); // Equals : Money.wons(60)
    }
}
