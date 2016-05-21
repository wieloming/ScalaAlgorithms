import Algorithms.Utils.Performance._

def printAll(list: List[Int], num: Int): List[(Int, Int)] = {
  list
    .flatMap(n => (n, list.find(_ + n == num)) match {
      case (a, Some(b)) if a <= b => Some((a, b))
      case _ => None
    })
    .distinct
}

def printAll2(list: List[Int], num: Int): List[List[Int]] = list match {
  case Nil => Nil
  case head::Nil => Nil
  case head :: tail if head + tail.last == num =>
     List(head, tail.last) :: printAll2(tail.init, num)
  case head :: tail if head + tail.last < num =>
    printAll2(tail, num)
  case head :: tail if head + tail.last > num =>
    printAll2(list.init, num)
}
time(printAll(List(1, 2, 3, 4, 6, 6, 6, 9, 9, 10), 12), 1000)
time(printAll2(List(1, 2, 3, 4, 6, 6, 6, 9, 9, 10), 12), 1000)
