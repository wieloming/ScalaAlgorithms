package Algorithms

import Utils.DataStructures._

class FindAllElementsOfLevelInBinaryTree {

  type LevelNum = Int

  def find(tree: Tree, levelToSearch: LevelNum): Unit = {
    findOnLevelRec(tree, 0, levelToSearch).foreach(println)
  }

  private def findOnLevelRec(tree: Tree, current: LevelNum, toFind: LevelNum): List[Int] = {
    if (tree == null || current > toFind) List.empty
    else if (current == toFind) List(tree.value)
    else findOnLevelRec(tree.left, current + 1, toFind) ++ findOnLevelRec(tree.right, current + 1, toFind)
  }
}
