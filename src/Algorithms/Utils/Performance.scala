package Algorithms.Utils

object Performance {
  def time[R](block: => R, times: Int): Unit = {
    val t0 = System.nanoTime()
    (0 to times).foreach(_ => block) // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
  }
}
