package phone

import scala.concurrent.duration.Duration

class NightDiscountPolicy(
                           val nightlyAmount: Money,
                           val regularAmount: Money,
                           val seconds: Duration,
                         ) extends BasicRatePolicy {

  def calculateFee(phone: Phone): Money =
    if (call.from.getHour >= NightDiscountPolicy.LateNightHour) {
      nightlyAmount * (call.duration.getSeconds / seconds.getSeconds)
    } else {
      regularAmount * (call.duration.getSeconds / seconds.getSeconds)
    }
}

object nightDiscountPolicy {
  val LateNightHour: Int = 22
}
