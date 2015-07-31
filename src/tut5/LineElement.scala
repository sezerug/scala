package tut5

/**
 * Created by usezer on 29.07.2015.
 */
class LineElement(s: String) extends Element {

  val contents = Array(s)

  override def width = s.length

  override def height = 1

}
