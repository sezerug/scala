package tut8

/**
 * Created by usezer on 30.07.2015.
 */
/**
 * Chapter 16 --> Working with Lists
 */
object AdvancedLists {

  def main(args: Array[String]) {
    tabulate

  }


  def mapFlatMap(): Unit = {

    val list = List(1, 2, 3, 4)
    assert(list.map(_ + 1) == List(2, 3, 4, 5))


    val words = List("the", "quick", "brown", "fox")

    val reverseWords = words map (_.toList.reverse.mkString)

    println(reverseWords) // -->prints List(eht, kciuq, nworb, xof)

    println(words.map(_.toList)) // --> prints List(List(t, h, e), List(q, u, i, c, k), List(b, r, o, w, n), List(f, o, x))
    println(words.flatMap(_.toList)) // --> prints List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x)
  }


  //Unlike map and flatMap, however, foreach takes a procedure(A function with result type Unit) as right operand.
  //It simply applies the procedure to each list element. The result of the operation itself is again Unit.
  def foreachTest(): Unit = {
    var sum = 0
    val numList = List.range(1, 6)

    numList.foreach(sum += _)
    assert(sum == 15)

  }


  //The operations xs forall p takes as arguments a list xs and a predicate p.
  //Its result is true if all elements in the list satisfy p.
  def forallTest {
    val list = List(1, 2, -3, 5, 6)
    println(list forall (_ > 0)) // --> prints false
  }

  def filterPartitionFindTakeWhile {
    val list = List(1, 2, 3, -4, 5, 6)

    val filtered = list.filter(_ % 2 == 0)
    println(filtered) // --> prints List(2, 4, 6)


    //The find method is also similar to filter but it returns the first element satisfying a given predicate
    val found = list.find(_ % 2 == 0)
    println(found) // --> prints Some(2)


    val takeWhileList = list.takeWhile(_ > 0)
    println(takeWhileList) // --> prints List(1, 2, 3)

  }


  def sortWith(): Unit = {
    val list = List(1, 2, -3, -6, 4, 5, 8, 9)

    println(list sortWith (_ < _)) // --> prints List(-6, -3, 1, 2, 4, 5, 8, 9)
  }


  def fill: Unit = {
    val list = List.fill(5)('a')
    println(list) // --> prints List(a, a, a, a, a)


    val list2 = List.fill(2, 3)('a')
    println(list2) // --> prints List(List(a, a, a), List(a, a, a))
  }


  def tabulate: Unit = {
    val list = List.tabulate(5)(s => s * s)
    println(list) // --> prints List(0, 1, 4, 9, 16)


  }
}
