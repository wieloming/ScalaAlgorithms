//design a stack with min(stack) operation in O(1) time.

import scala.collection.mutable

case object Stack {
  private val stack = mutable.Stack[(Int, Int)]()
  private var minimalVal = Int.MaxValue

  def push(el: Int):Unit = {
    if(el < minimalVal) minimalVal = el
    stack.push((el, minimalVal))
  }

  def pop(): Int = {
    val (res, _) = stack.pop()
    minimalVal = stack.top._2
    res
  }

  def min(): Int = minimalVal

  def top(): Int = stack.top._1

  override def toString: String = stack.map(_._1).toString()
}

Stack.push(3)
Stack.push(2)
Stack.push(1)
Stack.push(4)
Stack
"min: " + Stack.min()
Stack.pop()
"min: " + Stack.min()
Stack.pop()
"min: " + Stack.min()
Stack.pop()
"min: " + Stack.min()

