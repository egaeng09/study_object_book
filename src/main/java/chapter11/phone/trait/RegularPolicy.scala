package phone

class RegularPolicy(val amount: Money, val seconds Duration) extends BasicRatePolicy {

  def calculateFee(phone: Phone): Money =
    amount * (call.duration.getSeconds / seconds.getSeconds)
}
