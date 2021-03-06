def fibbonacci(num: Int) = {
  lazy val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
  fibs(num - 1)
}
def fibbonacci2(num: Int) = {
  lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map(t => t._1 + t._2)
  fibs(num - 1)
}

fibbonacci(5)