//TODO: in progress
import Algorithms.Utils.DataStructures.Tree

//    4
//  2  6
// 1 3 5 7
val good = new Tree(10)
good.left = new Tree(5)
good.right = new Tree(15)
good.left.left = new Tree(4)
good.left.right = new Tree(7)
good.right.left = new Tree(14)
good.right.right = new Tree(17)

//    10
//   5  15
// 4  7 14 17
val swapped = new Tree(10)
swapped.left = new Tree(15)
swapped.right = new Tree(14)
swapped.left.left = new Tree(4)
swapped.left.right = new Tree(7)
swapped.right.left = new Tree(5)
swapped.right.right = new Tree(17)

def inOrderTraversal(t: Tree): List[Int] = {
  if(t != null)
    (inOrderTraversal(t.left) :+ t.value) ++ inOrderTraversal(t.right)
  else List.empty
}

inOrderTraversal(good)
inOrderTraversal(swapped)

//if in IOR one pair is in wrong order, just swap
//if two pairs, swap first from first pair, with second from second

def recover(t: Tree) = {
  val pairs = inOrderTraversal(t).sliding(2)
  val swappedPairs = pairs.count{case List(a, b) => a > b}
  if(swappedPairs == 0) t
  else if(swappedPairs == 1) pairs.map{case }
}

recover(swapped)
