package tut4

import java.io.File

/**
 * Created by usezer on 29.07.2015.
 */

/**
 * Chapter 9 --> Control Abstraction
 */
object FileMatcher {

  private def filesHere: Array[File] =
    (new File(".")).listFiles()

  private def filesMatching(matcher: (String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName)) yield file
  }


  def filesEnding(query: String) = filesMatching(x => x.endsWith(query))


  def filesContaining(query: String) = filesMatching(_.contains(query))


  def filesRegex(query: String) = filesMatching(_.matches(query))


  /*def filesEnding(query: String): Array[File] = {

    for (file <- filesHere; if file.getName.endsWith(query))
      yield file


  }

  def filesContaining(query: String) = {
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  }

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file


  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query)) yield file
  }*/

  def main(args: Array[String]) {

    for (file <- filesEnding("t"))
      println(file.getName)



  }

}
