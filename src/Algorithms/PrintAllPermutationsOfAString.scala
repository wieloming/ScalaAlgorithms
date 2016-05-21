package Algorithms

import Utils.Performance._

object PrintAllPermutationsOfAString extends App {

  def count(letters: String): List[String] = {
    def count(letters: String, result: String): List[String] = {
      if (letters.length == 0) List.empty
      else {
        letters.toList.map { letter =>
          val filteredLetters = letters.filterNot(_ == letter)
          count(filteredLetters, result + letter).mkString
        }
      }
    }
    count(letters, "")
  }

  def count2(letters: String) = {
    letters.permutations
  }

  time(count("kdjsoaiejdka"), 1)
  time(count2("kdjsoaiejdka"), 1)
}
