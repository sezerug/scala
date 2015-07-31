package tut10.s1

/**
 * Created by usezer on 31.07.2015.
 */
/*
* Chapter 19 --> Type Parameterization
 */
//information hiding --> private constructors
class Queue[T] private(private val leading: List[T], private val trailing: List[T]) {

  private def mirror =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head


  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) = new Queue(leading, x :: trailing)
}

/**
 * By placing this object int he same source file as class Queue you make the object a companion object of the class.
 * Companion object has the same access rights as its class
 */
object Queue {
  //Note that factory method called apply, it is legal to use Queue(1,2,3)
  def apply[T](xs: T*): Queue[T] = new Queue[T](xs.toList, Nil)
}

object Test {
  def main(args: Array[String]) {
    val queue = Queue(1, 2, 3, 4)
    println(queue.head)
    println(queue.enqueue(12).head)

  }
}
