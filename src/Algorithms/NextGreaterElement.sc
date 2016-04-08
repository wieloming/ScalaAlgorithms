import scala.collection.mutable

def getNextGreaterElements(array: List[Int]): List[Option[Int]] = {
  val result = mutable.Map[Int, Int]()
  array match {
    case x::Nil => List(None)
    case Nil => List(None)
    case x::xs =>
      val stack = new mutable.Stack[Int]
      stack.push(x)
      xs.foreach{ el =>
        while(stack.nonEmpty && el > stack.top){
          val d = stack.pop()
          result(d) = el
        }
        stack.push(el)
      }
      array.map(e => result.get(e))
  }
}
val list = List(98,23,54, 12, 20,7, 27)
list zip getNextGreaterElements(list) foreach println