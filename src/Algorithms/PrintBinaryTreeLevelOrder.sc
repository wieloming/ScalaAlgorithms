import Algorithms.Utils.DataStructures._

import scala.collection.mutable
//    4
//  2  6
// 1 3 5 7
val tree = new Tree(4)
tree.left = new Tree(2)
tree.right = new Tree(6)
tree.left.left = new Tree(1)
tree.left.right = new Tree(3)
tree.right.left = new Tree(5)
tree.right.right = new Tree(7)

def printTree(tree: Tree): Unit = {
  val queue = mutable.Queue[Tree]()
  queue += tree
  while(queue.nonEmpty){
    val node = queue.dequeue()
    print(node.value + " ")
    if(node.left != null) queue += node.left
    if(node.right != null) queue += node.right
  }
}

printTree(tree)
println("4 2 6 1 3 5 7")