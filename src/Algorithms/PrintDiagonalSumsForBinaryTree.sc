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

def computeDiagonalSum(tree: Tree, currentLevel: Int, diagonalSum: scala.collection.mutable.Map[Int, Int]):Unit = {
  if(tree == null) return
  computeDiagonalSum(tree.left, currentLevel+1, diagonalSum)

  var prevSumForLevel = 0
  if(diagonalSum.contains(currentLevel)){
    prevSumForLevel = diagonalSum(currentLevel)
  }
  diagonalSum.put(currentLevel, prevSumForLevel + tree.value)

  computeDiagonalSum(tree.right, currentLevel, diagonalSum)
}

val map = mutable.Map[Int, Int]()
computeDiagonalSum(tree, 0, map)

map.foreach(println)


