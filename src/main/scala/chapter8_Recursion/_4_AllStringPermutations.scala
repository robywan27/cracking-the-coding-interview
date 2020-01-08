package chapter8_Recursion

object _4_AllStringPermutations {
  def permute(s: String): List[String] = {
    def permuteStringsWithChar(ch: Char, ss: List[String]): List[String] = {
      @scala.annotation.tailrec
      def permuteStringWithChar(s: String, index: Int, permutedStrings: List[String]): List[String] =
        if (index == -1)   permutedStrings
        else permuteStringWithChar(s, index - 1, s.substring(0, index) + ch + s.substring(index) :: permutedStrings)

      ss.flatMap(s => permuteStringWithChar(s, s.length, List()))
    }

    if (s.length <= 0 || s.length == 1)   s :: List()
    else permuteStringsWithChar(s.last, permute(s.init))
  }


  def main(args: Array[String]): Unit = {
    println(permute("STR"))
  }
}
