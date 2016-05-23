//Given two sorted arrays a and b each of size n,
//find the median of the array obtained by merging
//these two arrays.
//
//Example –
//
//a = 1, 3, 5, 11, 17
//b = 9, 10, 11, 13, 14
//
//Sorted(a+b) = 1, 3, 5, 9, 10, 11, 11, 13, 14, 17
//
//Median = (10 + 11)/2 = 10.5

def medianOfSorted(array1: List[Int], array2: List[Int]): Double = {
  def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
    case (x :: xs, y :: ys) if x <= y => x :: merge(xs, right)
    case (x :: xs, y :: ys) => y :: merge(left, ys)
    case _ => if (left.isEmpty) right else left
  }
  val sum = merge(array1, array2)
  val numElements = sum.length - 1
  val middle = numElements.toDouble / 2
  if(numElements % 2 == 0) sum(numElements.toInt/2)
  else (sum(Math.floor(middle).toInt) + sum(Math.ceil(middle).toInt)).toDouble / 2
}

medianOfSorted(List(1,3,5,11), List(9,10,11,13,14))
medianOfSorted(List(1,3,5,11,17), List(9,10,11,13,14))
