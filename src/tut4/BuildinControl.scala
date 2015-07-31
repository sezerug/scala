package tut4

/**
 * Created by usezer on 29.07.2015.
 */
object BuildinControl {


  val assertionsEnabled = false

  def main(args: Array[String]) {
    myAssert(() => 37 > 6)
    byNameAssert(3 / 0 == 0)
    boolAssert(3 / 0 == 0)

  }


  def myAssert(predicate: () => Boolean) = if (assertionsEnabled && !predicate())
    throw new AssertionError()


  //this is the build-in control
  def byNameAssert(predicate: => Boolean) = if (assertionsEnabled && !predicate)
    throw new AssertionError()


  def boolAssert(predicate: Boolean) = if (assertionsEnabled && !predicate)
    throw new AssertionError()


}
