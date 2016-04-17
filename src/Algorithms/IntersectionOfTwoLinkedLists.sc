import Algorithms.Utils.Performance._
import Algorithms.Utils.DataStructures._
//Problem:
//  Two linked lists A and B are joined on a particular
//  node, called the point of intersection of the linked lists. Find the point of intersection, i.e. the first node after which both lists have same nodes.

def solution1(list1: Node, list2: Node): Option[Node] = {
  for (n1 <- list1; n2 <- list2) {
    if (n1 == n2) return Some(n1)
  }
  None
}
def solution2(list1: Node, list2: Node): Option[Node] = {
  val set = list1.toSet
  list2.find(set contains)
}

val l3 = new Node(7, Some(new Node(8, None)))
val l1 = new Node(1, Some(new Node(2, Some(new Node(3, Some(l3))))))
val l2 = new Node(4, Some(new Node(5, Some(new Node(6, Some(l3))))))

time(solution1(l1, l2),10000)
time(solution2(l1, l2),10000)
