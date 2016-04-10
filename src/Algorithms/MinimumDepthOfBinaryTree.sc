import Algorithms.Utils.Performance

//Given a binary tree, find the minimum depth of the tree.
//Minimum depth of a binary tree is the length of the
//shortest path of all paths from root to any leaf.
case class Tree(value: Int,
                var right: Tree = null,
                var left: Tree = null)

def solution(tree: Tree): Int = {
  def rec(tree: Tree, current: Int): Int = tree match {
    case Tree(_, null, null) => current
    case Tree(_, null, l) => rec(l, current + 1)
    case Tree(_, r, null) => rec(r, current + 1)
    case Tree(_, r, l) => Math.min(rec(r, current + 1), rec(l, current + 1))
  }
  rec(tree, 1)
}
def solution2(tree: Tree): Int = {
  if(tree == null) return 0
  if(tree.left == null && tree.right == null) return 1
  val left = if(tree.left != null) solution2(tree.left) else Int.MaxValue
  val right = if(tree.right != null) solution2(tree.right) else Int.MaxValue
  1 + Math.min(left, right)
}

//          1
//       2     3
//     4   5
//        7 5
val tree = Tree(1, Tree(2, Tree(4), Tree(5, Tree(7), Tree(8))), Tree(3))

Performance.time({solution(tree)}, 10000)
Performance.time({solution2(tree)}, 10000)









