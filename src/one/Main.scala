package one

import two.{Rational, ChecksumAccumulator}


/**
 * Created by usezer on 28.07.2015.
 */

object Main {


  def main(args: Array[String]) {


    val checksum = new ChecksumAccumulator
    checksum.add(12)
    println(checksum.checksum())

    val rational1 = new Rational(1, 2)
    val rational2 = new Rational(2, 3)
    implicit def intToRational(x: Int) = new Rational(x)
    println(2 * rational1)

    println("** " + rational2 / 4)
    println("-- " + rational2)
    println(rational1 + rational1 * rational2)
    println(rational1 * new Rational(2))
    println(rational1 lessThan rational2)
    println(rational1 max rational2)

    greet()
    println(max(34, 32))
    arraysTest()
    listsTest()
    tuplesTest()
    setsAndMapsTest();


  }

  def greet() = println("Hello world!");

  //Basic form of a function definition in Scala
  def max(x: Int, y: Int): Int = {
    if (x > y)
      x
    else
      y
  }

  //Arrays are mutable in Scala
  def arraysTest(): Unit = {
    val numNames = Array("One", "Two", "Three")
    numNames(1) = "two";
    val modified = numNames.map(s => s + ":")
    modified.foreach(println)
  }


  //Lists are always  immutable
  def listsTest(): Unit = {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + " and " + threeFour + " were not mutated")
    println("Thus " + oneTwoThreeFour + " is a new list")


    val thrill = "Will" :: "fill" :: "until" :: Nil
    assert(thrill.count(s => s.length == 4) == 2)

    val newList = thrill.filter(s => s.length == 4)

    println(thrill + " is not mutated after filter operation. " + newList + " is a new list")
  }

  //Tuples are immutable like lists
  def tuplesTest(): Unit = {
    var pair = (99, "Luftballons")
    println("tuple ._1:" + pair._1)
    println("tuple ._2:" + pair._2)
  }


  def setsAndMapsTest(): Unit = {

    var jetSet = Set("Boeing", "F-16")
    jetSet += "F-18"
    println(jetSet)

    val movieSet = scala.collection.mutable.Set("Adam", "ForestGump", "Shrek")
    movieSet += "Fight Club"
    println(movieSet)

    val treasureMap = scala.collection.mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island")
    treasureMap += (2 -> "Find big X on the ground")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(1))
    treasureMap.foreach(s => println(s._2))
  }


}
