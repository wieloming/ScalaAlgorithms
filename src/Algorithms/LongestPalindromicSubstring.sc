//Given a string S, find the longest palindromic substring of S.
//
//  For e.g.:
//  S = "bananas"
//LPS = "anana"

def solution(s: String): String = {
  val length = s.length
  var startIndex = 0
  var maxLength = 1
  val matrix = Array.ofDim[Boolean](length, length)
  //one letter palindromes
  for (i <- 0 until length) matrix(i)(i) = true
  //two letters palindromes
  for (i <- 0 until length - 1 if s(i) == s(i + 1)) {
    matrix(i)(i + 1) = true
    startIndex = i
    maxLength = 2
  }
  //2+ letters palindromes
  var currentLength = 3
  while (currentLength <= length) {
    def middleIsPalindrome(i: Int, j: Int) = matrix(i + 1)(j - 1)
    for (i <- 0 to length - currentLength) {
      val j = i + currentLength - 1
      if (s(i) == s(j) && middleIsPalindrome(i, j)) {
        matrix(i)(j) = true
        startIndex = i
        maxLength = currentLength
      }
    }
    currentLength += 1
  }
  s.substring(startIndex, maxLength + 1)
}

solution("bananass")