package tut3

import scala.io.Source

/**
 * Created by usezer on 29.07.2015.
 */

/**
 * Chapter 8 --> Functions and Closures Example
 */
object LongLines {


  def processFile(filename: String, width: Int): Unit = {
    //val source = Source.fromFile(filename)


    //enclosing function
    def processFile(line: String): Unit = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }



    val source = Source.fromURL(getClass.getResource("/" + filename))

    for (line <- source.getLines())
      processFile(line)
  }

  /*  private def processFile(filename: String, width: Int, line: String): Unit = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }*/

}
