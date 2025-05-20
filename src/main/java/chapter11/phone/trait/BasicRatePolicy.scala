abstract class BasicRatePolicy {
  def calculateFee(phone: Phone): Money = {
    phone.calls.map(calculateFee(_)).reduce(_ + _)

    def calculateCallFee(call: Call): Money;
  }
}
