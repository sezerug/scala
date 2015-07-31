package tut6.geometric.dos

/**
 * Created by usezer on 30.07.2015.
 */
trait Rectangular{

  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left

}
