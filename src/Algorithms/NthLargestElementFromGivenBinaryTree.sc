import Algorithms.Utils.DataStructures._

//    10
//  7    12
//5   9     13
//   8
val tree = new Tree(10)
tree.left = new Tree(7)
tree.right = new Tree(12)
tree.left.left = new Tree(5)
tree.left.right = new Tree(9)
tree.right.right = new Tree(13)
tree.left.right.left = new Tree(8)

def nthLargest(n: Int, tree: Tree): Int = {
  def inOrder(tree: Tree): List[Int] = {
    if (tree == null) List.empty
    else {
      val lefts = inOrder(tree.left)
      val middle = List(tree.value)
      val rights = inOrder(tree.right)
      lefts ++ middle ++ rights
    }
  }
  inOrder(tree).dropRight(n).last
}
nthLargest(2, tree)