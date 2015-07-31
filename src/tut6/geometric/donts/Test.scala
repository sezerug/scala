package tut6.geometric.donts

/**
 * Created by usezer on 30.07.2015.
 */
object Test {

  def main(args: Array[String]) {

    val rectangle = new Rectangle(new Point(3, 4), new Point(12, 20))
    println("left:" + rectangle.left)
    println("right:" + rectangle.right)
    println("width:" + rectangle.width)

  }

}
