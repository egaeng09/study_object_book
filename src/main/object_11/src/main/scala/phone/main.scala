package phone

class main {
  new RegularPolicy(Money(100), Duration.ofSeconds(10))
  with RateDiscountablePolicy
  with TaxablePolicy {
    val discountAmount: Money = Money(10)
    val taxRate: Double = 0.1
  }
}
