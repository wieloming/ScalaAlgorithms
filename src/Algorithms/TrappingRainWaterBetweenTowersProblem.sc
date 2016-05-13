import Algorithms.Utils.Performance._
//Problem:
// We have an array where each element
// represents height of a tower. If it starts raining,
// what is the amount of water that can be collected
// between the towers? Assumption is that the width
// of every tower is 1.
//Example:-
//  [1,5,2,3,1,7,2,4] – then answer is 11 units.
def solution(list: List[Int]): Int = list match {
  case List(a, b, c) if b < a && b < c =>
    Math.min(a, c) - b
  case l if l.length <= 3 => 0
  case _ =>
    val mutable = list.toArray
    for (i <- 1 until list.length - 1) {
      val prevMax = list.slice(0, i).max
      val curr = list(i)
      val nextMax = list.slice(i + 1, list.length).max
      val min = Math.min(prevMax, nextMax)
      mutable(i) = if (min < curr) 0 else min - curr
    }
    mutable.init.tail.sum
}

def solution2(list: List[Int]): Int = {
  val maxSeenLeft = list.scanLeft(0)((acc, el) => Math.max(acc, el))
  val maxSeenRight = list.scanRight(0)((acc, el) => Math.max(acc, el))
  val res = maxSeenLeft zip list zip maxSeenRight map { case ((left, l), right) =>
    Math.max(Math.min(left, right) - l, 0)
  }
  res.sum
}

time(solution(List(1, 5, 2, 3, 1, 7, 2, 4)), 100000)
time(solution2(List(1, 5, 2, 3, 1, 7, 2, 4)), 100000)
