package tut10.s2

/**
 * Created by usezer on 31.07.2015.
 */
/*
* Chapter 19 --> Type Parameterization
* information hiding --> private classes
* Instead of hiding individual constructors and methods this version hides the whole implementation class
*/
trait Queue[T] {
  def head: T

  def tail: Queue[T]

  def enqueue(x: T): Queue[T]
}

/**
 * By placing this object int he same source file as class Queue you make the object a companion object of the class.
 * Companion object has the same access rights as its class
 */
object Queue {
  //Note that factory method called apply, it is legal to use Queue(1,2,3)
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)


  private class QueueImpl[T](private val leading: List[T], private val trailing: List[T]) extends Queue[T] {

    private def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head


    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) = new QueueImpl(leading, x :: trailing)
  }

}


object Test {
  def main(args: Array[String]) {
    val queue = Queue("1", "2", "3", "4")
    println(queue.head)
    println(queue.enqueue("12").tail.head)

  }
}
