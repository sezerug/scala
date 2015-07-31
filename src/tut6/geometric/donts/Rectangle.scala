package tut6.geometric.donts

/**
 * Created by usezer on 30.07.2015.
 */
class Rectangle(val topLeft: Point, val bottomRight: Point) {

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}
