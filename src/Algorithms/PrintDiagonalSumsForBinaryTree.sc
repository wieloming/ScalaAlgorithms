import Algorithms.Utils.DataStructures.Tree

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
