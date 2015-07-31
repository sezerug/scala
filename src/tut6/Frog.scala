package tut6

import tut10.s1.Queue

/**
 * Created by usezer on 30.07.2015.
 */
class Frog(override val name: String) extends Animal(name) with Philosophical {


  override def toString = "green"

}


object Frog {
  def main(args: Array[String]) {
    val frog = new Frog("Frog")
    println(frog.name)
    frog.philosophize()
    val phil = frog
    phil.philosophize()
  }
}