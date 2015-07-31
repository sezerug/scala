package tut4

import java.io.{PrintWriter, File}
import java.util.Date

/**
 * Created by usezer on 29.07.2015.
 */
object Currying {


  def main(args: Array[String]) {

    val x = 1;
    val y = 2;
    println("plainOldSum: " + plainOldSum(x, y))
    println("curriedSum: " + curriedSum(x)(y))

    val second = first(1)
    println(second(2))


    val onePlus = curriedSum(1) _
    println("onePlus: " + onePlus(y))

    val twoPlus = curriedSum(2) _
    println("twoPlus: " + twoPlus(y))


    val file = new File("date.txt")

    withPrintWrite(file) {
      writer => {
        writer.println("learning scala")
        writer.println("author:sezerug")
        writer.println(new Date())
      }
    }
  }

  def plainOldSum(x: Int, y: Int): Int = {
    x + y
  }

  def curriedSum(x: Int)(y: Int) = x + y


  def first(x: Int) = (y: Int) => x + y


  def withPrintWrite(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}
