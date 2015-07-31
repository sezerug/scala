package tut2

/**
 * Created by usezer on 28.07.2015.
 */

/**
 * Programming in Scala by Martin Odersky --> chapter 6
 * @param n
 * @param d
 */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)


  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g;
  val denom: Int = d / g;


  def this(n: Int) = this(n, 1)

  override def toString = numer + "/" + denom

  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational = new Rational(denom * i + numer, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational = new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational = new Rational(numer * i, denom)

  def /(that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational = new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)


  def compare(that: Rational) = (this.numer * that.denom) - (that.numer * this.numer)

}

