import Algorithms.Utils.DataStructures._

val l1 = LinkedList(1, 2, 3, 4, 5)

def reverse(list: LinkedList) = {
  def rev(prev: Node2, acc: Option[Node2]): Node2 = prev match {
    case Node2(v, Some(next)) => rev(next, Option(Node2(v, acc)))
    case Node2(v, _) => Node2(v, acc)
  }
  LinkedList(rev(list.head, None))
}

reverse(l1)
reverse(reverse(l1))
