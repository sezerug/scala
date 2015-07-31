package tut7

/**
 * Created by usezer on 30.07.2015.
 */
/**
 * Chapter 15 --> Case classes and pattern matching
 */
sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(number: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {

  def main(args: Array[String]) {
    val v = new Var("x")
    println(v.name)

    println(describe(5))
    println(describe(Var("")))
    println(describe(List(0, 1, 2, 5)))

    println(generalizeSize("Ugur SEZER"))
    println(generalizeSize(Map(1 -> "a", 2 -> "b")))
  }


  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case List(0, _*) => "List starts with 0"
    case Nil => "the empty list"
    case _ => "something else"
  }

  def describe(x: Expr):String = x match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  def generalizeSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
}
