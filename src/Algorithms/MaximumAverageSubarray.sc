//Given an integer array and a number k,
//print the maximum average subarray of size k.
//
//Maximum average subarray of size k is a subarray
//(sequence of contiguous elements in the array)
//for which the average is maximum among all
//subarrays of size k in the array.
//Average of k elements = (sum of k elements)/k
//Since k is greater than 0, the maximum sum subarray
//of size k will also be maximum average subarray of
//size k. So, the problem reduces to finding maximum
//sum subarray of size k in the array.

def solution1(array: Array[Int], k: Int) = {
  array sliding k maxBy(_.sum)
}
def solution2(array: Array[Int], k: Int) = {
  var maxSum = array.take(k).sum
  var curSum = maxSum
  var maxInd = 0
  for(i <- k until array.length){
    val prev = array(i - k)
    val next = array(i)
    curSum = curSum - prev + next
    if(curSum > maxSum){
      maxSum = curSum
      maxInd = i - k + 1
    }
  }
  array.slice(maxInd, maxInd + k)
}

solution1(Array(11, -8, 16, -7, 24, -2, 3), 3)
solution2(Array(11, -8, 16, -7, 24, -2, 3), 3)
