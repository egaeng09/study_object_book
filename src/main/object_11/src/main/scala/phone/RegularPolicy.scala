package phone

import scala.concurrent.duration.Duration

class RegularPolicy(val amount: Money, val seconds Duration) extends BasicRatePolicy {

  def calculateFee(phone: Phone): Money =
    amount * (call.duration.getSeconds / seconds.getSeconds)
}
