import Algorithms.Utils.DataStructures.Tree

import scala.collection.mutable

//    1
//  2   3
//4  5   6
//  8   7
val tree = new Tree(1)
tree.left = new Tree(2)
tree.right = new Tree(3)
tree.left.left = new Tree(4)
tree.left.right = new Tree(5)
tree.right.right = new Tree(6)
tree.left.right.left = new Tree(8)
tree.right.right.left = new Tree(7)

def computeDiagonalSum(tree: Tree): Map[Int, Int] = {
  def helper(tree: Tree, currentLevel: Int, sums: mutable.Map[Int, Int]): mutable.Map[Int, Int] = {
    if (tree != null) {
      val map = helper(tree.left, currentLevel + 1, sums)

      map.update(currentLevel, map(currentLevel) + tree.value)

      helper(tree.right, currentLevel, map)
    } else {
      sums
    }
  }
  val map = mutable.Map[Int, Int]()

  helper(tree, 0, map.withDefaultValue(0)).toMap
}

computeDiagonalSum(tree).foreach(println)


