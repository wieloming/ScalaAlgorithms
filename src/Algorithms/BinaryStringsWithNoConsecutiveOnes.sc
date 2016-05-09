//
// n = 2 (00, 01, 10)
// n = 3 (000, 001, 010, 100, 101)
//

def rec(n: Int): List[String] = {
  if (n == 0) List.empty
  else if (n == 1) List("0", "1")
  else {
    val r = rec(n - 1)
    val addZero = r.map(_ + "0")
    val addOne = r.map(s => if(s.last == '1') s else s + "1")
    (addZero ++ addOne).filter(_.length == n)
  }
}

def tailRec(n: Int, res: List[String]): List[String] = ???

rec(20)