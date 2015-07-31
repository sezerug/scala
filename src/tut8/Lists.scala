package tut8

/**
 * Created by usezer on 30.07.2015.
 */
/**
 * Chapter 16 --> Working with Lists
 *
 * Lists are immutable and homogeneous:the elements of a list all have the same type
 */
object Lists {

  def main(args: Array[String]) {
    basicOperations
  }


  def basics(): Unit = {
    val fruit: List[String] = List("apples", "oranges", "pears")

    val nums = 1 :: 2 :: 3 :: 4 :: Nil

    fruit.foreach(println)
    nums.foreach(println)

  }

  def basicOperations(): Unit = {
    //head  --> returns the  first element of a list
    //tail  --> returns a list consisting of all elements except the first
    //isEmpty --> returns true if list is empty
    val fruit: List[String] = List("apples", "oranges", "pears")
    println(fruit.head) // --> prints apples
    println(fruit.tail) // --> prints List(oranges, pears)

    //pattern matching
    val List(a, b, c) = fruit
    println(a + ":" + b + ":" + c) // --> prints apples:oranges:pears

  }

  def concatenate(): Unit = {
    //::: is a method in List
    val list = List(1, 2, 3) ::: List(4, 5, 6)
    assert(list == List(1, 2, 3, 4, 5, 6))
  }


  def reverseExample(): Unit = {
    //::: is a method in List
    val list = List(1, 2, 3) ::: List(4, 5, 6)
    assert(list.reverse == List(6, 5, 4, 3, 2, 1))
    assert(list == List(1, 2, 3, 4, 5, 6))
  }

  def dropTakeSplitAt(): Unit = {
    //::: is a method in List
    val abcde = List('a', 'b', 'c', 'd', 'e')

    assert((abcde take 2) == List('a', 'b'))
    assert((abcde drop 2) == List('c', 'd', 'e'))

    val splitted = (abcde splitAt 2)
    println(splitted) //--> prints (List(a, b),List(c, d, e))

    assert(abcde == List('a', 'b', 'c', 'd', 'e'))

    println(abcde.indices) //--> prints Range(0, 1, 2, 3, 4)
  }


  def flatten(): Unit = {
    val list = List(List(1, 2), List(3), List(), List(4, 5))

    val flattedList = list.flatten
    assert(flattedList == List(1, 2, 3, 4, 5))
  }


  def zipUnzip = {
    val abcde = List('a', 'b', 'c', 'd', 'e')
    val nums = List(1, 2, 3)
    println(abcde mkString) //--> prints abcde

    val zipped = abcde zip nums
    assert(zipped == List(('a', 1), ('b', 2), ('c', 3)))

    val unzipped = zipped.unzip
    println(unzipped.toString()) //--> prints (List(a, b, c),List(1, 2, 3))


  }

}
