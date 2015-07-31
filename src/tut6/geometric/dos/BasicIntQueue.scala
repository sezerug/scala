package tut6.geometric.dos

import scala.collection.mutable.ArrayBuffer

/**
 * Created by usezer on 30.07.2015.
 */
class BasicIntQueue extends IntQueue {


  private val buf = new ArrayBuffer[Int]

  def get(): Int = buf.remove(0)

  def put(x: Int): Unit = {
    buf += x
  }

}
