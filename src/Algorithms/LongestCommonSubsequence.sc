import Algorithms.Utils.Performance._

//Given two strings S1 and S2. Find the longest common subsequence between S1 and S2.
//
//  Example:
//S1 = "ACBEA"
//S2 = "ADCA"
//
//LCS = "ACA"

//RECURSIVE
def solution(s1: String, s2: String): List[Char] = {
  def lcs(s1: List[Char], s2: List[Char]): List[Char] = (s1, s2) match {
    case (Nil, Nil) => List.empty
    case (x, y) if x == y => x
    case (xs :+ x, ys :+ y) if x == y => lcs(xs, ys) :+ x
    case (xs, Nil) => lcs(xs.init, Nil)
    case (Nil, ys) => lcs(Nil, ys.init)
    case (xs, ys) => List(lcs(xs, ys.init), lcs(xs.init, ys)).maxBy(_.size)
  }
  lcs(s1.toList, s2.toList)
}
//DYNAMIC PROGRAMMING
def solution2(a: String, b: String): String = {
  def readFromMatrix(matrix: Array[Array[Int]]): String = {
    val sb = new StringBuilder()
    var x = a.length
    var y = b.length
    while (x != 0 && y != 0){
      if (matrix(x)(y) == matrix(x - 1)(y))
        x -= 1
      else if (matrix(x)(y) == matrix(x)(y - 1))
        y -= 1
      else {
        sb += a(x - 1)
        x -= 1
        y -= 1
      }
    }
    sb.toString.reverse
  }
  def fillMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    for (i <- a.indices; j <- b.indices)
      if (a(i) == b(j))
        matrix(i + 1)(j + 1) =  matrix(i)(j) + 1
      else
        matrix(i + 1)(j + 1) = Math.max(matrix(i + 1)(j), matrix(i)(j + 1))
    matrix
  }
  if (a.isEmpty || b.isEmpty) ""
  else if (a == b) a
  else {
    val matrix = Array.ofDim[Int](a.length + 1, b.length + 1)
    fillMatrix(matrix)
    readFromMatrix(matrix)
  }
}

time(solution("ACBEA", "ADCA"), 1000)
time(solution2("ACBEA", "ADCA"), 1000)