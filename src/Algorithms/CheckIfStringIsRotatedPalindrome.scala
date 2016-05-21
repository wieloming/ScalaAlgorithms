package Algorithms

class CheckIfStringIsRotatedPalindrome {

  def isRotatedPalindrome(string: String): Boolean = {
    def isRotatedPalindromeRec(chars: List[Char], countLeft: Int): Boolean = {
      if (countLeft <= 0) false
      else if (isPalindrome(chars)) true
      else isRotatedPalindromeRec(chars.tail :+ chars.head, countLeft - 1)
    }

    def isPalindrome(string: List[Char]): Boolean = {
      (string.size > 1) && string == string.reverse
    }

    isRotatedPalindromeRec(string.toList, string.length)
  }
}
