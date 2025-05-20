package phone

class RateDiscountableAndTaxableRegularPolicy(
                                               amount: Money,
                                               seconds: Duration,
                                               val discountAmount: Money,
                                               val taxRate: Double
                                             )
  extends RegularPolicy(amount, seconds)
    with TaxablePolicy
    with RateDiscountablePolicy
