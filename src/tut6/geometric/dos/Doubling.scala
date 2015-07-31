package tut6.geometric.dos

/**
 * Created by usezer on 30.07.2015.
 */
trait Doubling extends IntQueue {

  abstract override def put(x: Int) = {
    super.put(2 * x)
  }

}
