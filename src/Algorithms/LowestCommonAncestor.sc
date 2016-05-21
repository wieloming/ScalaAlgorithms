import Algorithms.Utils.DataStructures._
//Problem:
//Given a binary tree and 2 tree nodes A and B
//(assuming both nodes A and B are present in the tree),
//find the lowest common ancestor of the nodes.

def solution(tree: Tree, n1: Int, n2: Int): Option[Int] = {
  def ancestors(tree: Tree, n: Int, already: List[Int]): List[Int] = tree match {
    case null => List()
    case Tree(value, _, _) if value == n => value::already
    case Tree(value, r, l) => ancestors(r, n, value::already) ++ ancestors(l, n, value::already)
  }
  ancestors(tree, n1, List()) intersect ancestors(tree, n2, List()) headOption
}

val tree = Tree(1, Tree(2, Tree(4), Tree(5, Tree(7), Tree(8))), Tree(3))
solution(tree, 4, 8).get == 2
solution(tree, 2, 3).get == 1
solution(tree, 4, 2).get == 2
solution(tree, 4, 3).get == 1
solution(tree, 5, 1).get == 1