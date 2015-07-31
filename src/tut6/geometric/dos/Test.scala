package tut6.geometric.dos

/**
 * Created by usezer on 30.07.2015.
 */
object Test {


  def main(args: Array[String]) {
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))

    println(rect.left)


    val myQueue = new MyQueue
    myQueue.put(10)

    println(myQueue.get())
  }
}
