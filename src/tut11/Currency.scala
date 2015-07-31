package tut11

import tut11.US._

/**
 * Created by usezer on 31.07.2015.
 */
object Currency {


  def main(args: Array[String]) {

    println(Europe.Euro from US.Dolar + US.Dolar)
    println(US.Dolar + US.Dolar)

  }
}


abstract class CurrencyZone {
  type Currency <: AbstractCurrency

  def make(x: Long): Currency

  abstract class AbstractCurrency {


    val amount: Long

    def designation: String

    override def toString = ((amount.toDouble / CurrencyUnit.amount.toDouble) formatted ("%." + decimals(CurrencyUnit.amount) + "f" + " " + designation))

    def +(that: Currency): Currency = make(this.amount + that.amount)


    private def decimals(n: Long): Int = if (n == 1) 0 else 1 + decimals(n / 10)

    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)))

  }


  val CurrencyUnit: Currency
}

object US extends CurrencyZone {

  abstract class Dolar extends AbstractCurrency {
    def designation = "USD"
  }


  type Currency = Dolar

  def make(cents: Long) = new Dolar {
    val amount = cents
  }

  val Cent = make(1)
  val Dolar = make(100)
  val CurrencyUnit = Dolar


}


object Europe extends CurrencyZone {

  abstract class Euro extends AbstractCurrency {
    def designation = "EUR"
  }


  type Currency = Euro

  def make(cents: Long) = new Euro {
    val amount = cents
  }

  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro


}


object Japan extends CurrencyZone {

  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }


  type Currency = Yen

  def make(yen: Long) = new Yen {
    val amount = yen
  }

  val Yen = make(1)
  val CurrencyUnit = Yen


}


object Converter {
  var exchangeRate: Map[String, Map[String, Double]] = Map(
    "USD" -> Map("USD" -> 1, "EUR" -> 0.7596, "JPY" -> 1.211, "CHF" -> 1.223),
    "EUR" -> Map("USD" -> 1.316, "EUR" -> 1, "JPY" -> 1.594, "CHF" -> 1.623),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272, "JPY" -> 1.0, "CHF" -> 1.018),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160, "JPY" -> 0.982, "CHF" -> 1.0)
  )
}