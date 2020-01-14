package chapter8_Recursion

object _5_ValidParenthesesNPairsCombinations {
  def generateValidParenthesesNPairs(n: Int): Unit = {
    def helper(openParensCounter: Int, closeParensCounter: Int, accStr: String): Unit =
        if (openParensCounter == 0 && closeParensCounter == 0)
          println(accStr)
        else {
          if (openParensCounter > 0)
            helper(openParensCounter - 1, closeParensCounter, accStr + '(')
          if (closeParensCounter > openParensCounter)
            helper(openParensCounter, closeParensCounter - 1, accStr + ')')
        }

    helper(n, n, "")
  }


  def main(args: Array[String]): Unit = {
    generateValidParenthesesNPairs(1)     // ()
    generateValidParenthesesNPairs(2)     // (()), ()()
    generateValidParenthesesNPairs(3)     // ((())), (()()), (())(), ()(()), ()()()
    generateValidParenthesesNPairs(4)
  }
}
