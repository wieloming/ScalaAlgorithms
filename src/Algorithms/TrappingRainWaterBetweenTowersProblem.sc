//Problem:
// We have an array where each element
// represents height of a tower. If it starts raining,
// what is the amount of water that can be collected
// between the towers? Assumption is that the width
// of every tower is 1.
//Example:-
//  [1,5,2,3,1,7,2,4] – then answer is 11 units.
def solution(list: List[Int]): Int = {
  val mutable = list.toArray
  for(i <- 1 until list.length - 1){
    val prev = list.slice(0, i).max
    val curr = list(i)
    val next = list.slice(i+1, list.length).max
    val min = Math.min(prev, next)
    mutable(i) = if(min < curr) 0 else min - curr
  }

  mutable.init.tail.sum
}

solution(List(1,5,2,3,1,7,2,4))