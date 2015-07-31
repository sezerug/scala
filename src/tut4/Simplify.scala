package tut4

/**
 * Created by usezer on 29.07.2015.
 */
/**
 * Chapter 9 --> Simplifying client code
 */
object Simplify {


  def main(args: Array[String]) {
    val listPos = List(1, 2, 3, 4, 5)
    val listNeg = List(4, 3, 2, 1, 0, -1)
    val listEven = List(2, 4, 6, 8)

    println(containsOdd(listEven))


  }


  def containsNeg(nums: List[Int]): Boolean = {
    var contains = false
    for (i <- nums)
      if (i < 0)
        contains = true

    contains
  }

  //simplified version
  def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)


}
