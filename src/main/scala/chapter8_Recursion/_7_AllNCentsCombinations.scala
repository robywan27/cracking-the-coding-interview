package chapter8_Recursion

object _7_AllNCentsCombinations {
  def findAllNCentsCombinations(number: Int): Int = {
    val quarter = 25
    val dime = 10
    val nickel = 5
    val penny = 1

    def helper(amount: Int, unit: Int): Int = {
      var nextUnit = 0
      unit match {
        case 25 => nextUnit = dime
        case 10 => nextUnit = nickel
        case 5 => nextUnit = penny
        case 1 => return 1
      }
      var numberOfCombinations = 0
      var i = 0
      while (i * unit <= amount) {
        numberOfCombinations += helper(amount - i * unit, nextUnit)
        i += 1
      }
      numberOfCombinations
    }

    helper(number, quarter)
  }


  def main(args: Array[String]): Unit = {
    println(findAllNCentsCombinations(7))         // 2
    println(findAllNCentsCombinations(13))        // 4
    println(findAllNCentsCombinations(25))        // 13
    println(findAllNCentsCombinations(100))       // 242
  }
}
