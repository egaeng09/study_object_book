package phone

class TaxableRegularPolicy(
                          amount: Money,
                          seconds: Duration,
                          val taxRate: Double
                          )
  extends RegularPolicy(amount, seconds) with TaxablePolicy
