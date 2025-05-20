package phone

class RateDiscountableNightDiscountPolicy(
                                           nightlyAmount: Money,
                                           regularAmount: Money,
                                           seconds: Duration,
                                           val discountAmount: Money
)
extends NightDiscountPolicy(nightlyAmount, regularAmount, seconds)
with RateDiscountablePolicy
