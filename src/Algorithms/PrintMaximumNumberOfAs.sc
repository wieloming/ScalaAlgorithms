//Print Maximum number of As using Ctrl-A, Ctrl-C, Ctrl-V


def printAs(n: Int, marked: Int): List[Int] = {
  if (n == 0) List.empty
  else if (n == 1) List(1)
  else if (n == 2) List(1,1)
  else {
    val add = printAs(n - 1, marked) map (_ + 1)
    val markAndCopy = printAs(n - 2, n)
    val paste = printAs(n - 1, marked) map (_ + marked)
    add ++ markAndCopy ++ paste
  }
}

printAs(3, 0).max
printAs(7, 0).max