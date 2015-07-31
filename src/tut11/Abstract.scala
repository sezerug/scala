package tut11

/**
 * Created by usezer on 31.07.2015.
 */
/**
 * Chapter 20 --> Abstract Members
 *
 * A member of a class or trait is abstract if the member does not have a complete definition in the class
 * The following trait declares an abstract type(T), method(transform), val(initial), var(current)
 */
trait Abstract {

  type T

  def transform(x: T): T

  val initial: T
  var current: T
}


class Concrete extends Abstract {

  type T = String

  def transform(x: String): String = x + x

  val initial = "hi"
  var current = initial

}


object Test {
  def main(args: Array[String]) {
    val concrete = new Concrete
    println(concrete.initial)
    concrete.current = "Ugur";
    println(concrete.transform("test"))
    println(concrete.current)


  }
}