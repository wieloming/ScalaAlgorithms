import Algorithms.Utils.Performance._

//For example:-
//s1 = "LCLC", s2="CLCL".
//
//  LCS = {"LCL", "CLC"}

def slowLCS(s1: String, s2: String): List[String] = {
  def substrings(s: String) = s.tails.toList.flatMap(_.inits.toList)
  val ss1 = substrings(s1)
  val ss2 = substrings(s2)
  val common = ss1.filter(ss2.contains)
  common.filter(_.length == common.max.length)
}

def dynamicProgLCS(s1: String, s2: String): List[String] = {
  val table = Array.ofDim[Integer](s1.length, s2.length)
  var maxLength = java.lang.Integer.MIN_VALUE
  var result = List[String]()
  for (i <- s1.indices; j <- s2.indices) {
    def charsEquals = s1.charAt(i) == s2.charAt(j)
    def currentPlusOne = if (i == 0 || j == 0) 1 else table(i - 1)(j - 1) + 1
    def startNewMaxList = List(s1.substring(i - maxLength + 1, i + 1))
    def updateMaxList(r: List[String]) = r :+ s1.substring(i - maxLength + 1, i + 1)
//ALGORITHM:
    if (charsEquals) {
      table(i)(j) = currentPlusOne
      if (table(i)(j) > maxLength) {
        maxLength = table(i)(j)
        result = startNewMaxList
      } else if (table(i)(j) == maxLength) {
        result = updateMaxList(result)
      }
    } else table(i)(j) = 0
///////////
  }
  result
}

val s1 = "LCLC"
val s2 = "CLCL"


time(slowLCS(s1, s2), 10000)
time(dynamicProgLCS(s1, s2), 10000)