import Algorithms.Utils.Performance._

//
// n = 2 (00, 01, 10)
// n = 3 (000, 001, 010, 100, 101)
//

def rec(n: Int): List[String] = {
  def helper(n: Int): List[String] = n match {
    case 0 => List.empty
    case 1 => List("0", "1")
    case _ =>
      val r = helper(n - 1)
      val addZero = r.map(_ + "0")
      val addOne = r.map(s => if (s.last == '1') s else s + "1")
      addZero ++ addOne
  }
  helper(n).filter(_.length == n)
}

//slower
def fold(n: Int): List[String] = {
  def addZerosAndOnes(acc: List[String], el: Int) =
    acc.map(_ + "0") ++ acc.map(s => if (s.last == '1') s else s + "1")

  (0 until n - 1)
    .foldLeft(List("0", "1"))(addZerosAndOnes)
    .filter(_.length == n)
}

time(fold(3), 1)
time(rec(3), 1)
