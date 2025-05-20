package phone

trait TaxablePolicy extends BasicRatePolicy {
  def taxAmount: Money

  override def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    fee + fee * taxAmount
  }
}
