import Algorithms.Utils.Performance._

//Given a sorted integer array which is rotated
//any number of times, find the
//index of the minimum element of the array.
//Ex: In array {78, 82, 99, 10, 23, 35, 49, 51, 60}
//Pivot index is 3.

def solution(array: Array[Int]): Int = {
  for (i <- 0 until array.length - 1) {
    if (array(i) > array(i + 1)) return i + 1
  }
  0
}

def solution2(array: Array[Int]): Int = {
  def binarySearch(start: Int, end: Int): Int = {
    def notSorted(a: Int, b: Int) = array(a) > array(b)
    val mid = (start + end) / 2
    if (notSorted(mid, mid + 1)) mid + 1
    else {
      if (notSorted(start, mid)) binarySearch(start, mid - 1)
      else binarySearch(mid + 1, end)
    }
  }
  if (array.head <= array.last) 0
  else {
    val start = 0
    val end = array.length - 1
    binarySearch(start, end)
  }
}

time(solution(Array(78, 82, 99, 10, 23, 35, 49, 51, 60)), 100000)
time(solution2(Array(78, 82, 99, 10, 23, 35, 49, 51, 60)), 100000)
