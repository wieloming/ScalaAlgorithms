package Algorithms.Utils

object DataStructures {
  class Node(value: Int, val nextNode: Option[Node]) extends Iterable[Node] {
    val t = this
    override def toString: String = "<" + value.toString + ">"
    override def iterator: Iterator[Node] = new Iterator[Node] {
      var currentN: Node = t
      var nextN = nextNode
      override def hasNext: Boolean = nextN.isDefined
      override def next(): Node = {
        currentN = currentN.nextNode.get
        nextN = currentN.nextNode
        currentN
      }
    }
  }
  ////////////////////////////////////////////////////////////////////
  sealed case class LinkedList(head: Node2) {
    def add(int: Int) = {
      var curr = head
      var next = head.nextNode
      while (next.isDefined) {
        curr = next.get
        next = curr.nextNode
      }
      curr.nextNode = Option(Node2(int, None))
    }
    override def toString: String = {
      var curr = head
      var res = head.value.toString
      while (curr.nextNode.isDefined) {
        res += "->" + curr.nextNode.get.value
        curr = curr.nextNode.get
      }
      res
    }
  }
  case object LinkedList {
    def apply(n: Int*): LinkedList = {
      val l = LinkedList(Node2(n.head, None))
      n.tail.foreach(l.add)
      l
    }
  }
  sealed case class Node2(value: Int, var nextNode: Option[Node2])

  case class Tree(var value: Int,
                  var right: Tree = null,
                  var left: Tree = null)

}
