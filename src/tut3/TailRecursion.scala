package tut3

import scala.annotation.tailrec

/**
 * Created by usezer on 29.07.2015.
 */
object TailRecursion {

  def main(args: Array[String]) {

    val number = 6;
    println("the factorial of %d is %d".format(number, factorial(number)))
  }

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else
        go(n - 1, acc * n)
    }
    go(n, 1)
  }

}
