//Problem:
//Given an array of size n, find the element which
//occurs more than n/2 times. This element is called
//Majority Element.
//
def solution(array: Array[Int]): Option[Int] = {
  val res = array.foldLeft(Map[Int, Int]().withDefaultValue(0)) { (map, el) =>
    map.updated(el, map(el)+1)
  }
  val max = res.maxBy(_._2)
  if(max._2 > array.length/2) Some(max._1)
  else None
}

//Boyer-Moore Vote Algorithm
def solution2(array: Array[Int]): Option[Int] = {
  var candidate: Int = Int.MaxValue
  var count = 0
  array.foreach{c =>
    if(count == 0){
      candidate = c
      count = 1
    }else{
      if(candidate == c) count += 1
      else count -= 1
    }
  }
  if(count == 0) None
  else{
    val res = array.count(_ == candidate)
    if(res > array.length/2) Option(candidate)
    else None
  }
}

solution(Array(2, 6, 2, 2, 6, 2, 2, 8, 2, 1))
solution(Array(1, 7, 8, 2, 6, 8, 1, 3, 2, 8))
println("=================")
solution2(Array(2, 6, 2, 2, 6, 2, 2, 8, 2, 1))
solution2(Array(1, 7, 8, 2, 6, 8, 1, 3, 2, 8))
//For example:
//Array 1: {2 6 2 2 6 2 2 8 2 1}
//Majority Element: 2
//Array 2: {1 7 8 2 6 8 1 3 2 8}
//Majority Element: none