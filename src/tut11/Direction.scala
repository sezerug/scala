package tut11

/**
 * Created by usezer on 31.07.2015.
 *
 * Chapter 20 --> Abstract Members
 *
 * Enumerations
 */
object Direction extends Enumeration {


  val North = Value("North")

  val East = Value("East")

  val South = Value("South")

  val West = Value("West")


  /**
   * test
   * @param args
   */
  def main(args: Array[String]) {
    for (d <- Direction.values)
      println(d.id + "->" + d) // prints --> 0->North 1->East 2->South 3->West
  }
}
