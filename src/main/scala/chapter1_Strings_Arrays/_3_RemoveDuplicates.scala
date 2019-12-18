package chapter1_Strings_Arrays

object _3_RemoveDuplicates {
  /*
    Recursive solution.

    Time complexity: between O(n*logn) and O(n^2) - s is scanned, and for each letter the remaining of the word is scanned,
      which means at each new iteration the word shrinks
    Space complexity: O(1)
   */
  def removeDuplicates(s: String): String = {
    @scala.annotation.tailrec
    def helper(s: String, ns: String): String = {
      @scala.annotation.tailrec
      def removeLetterDuplicates(c: Char, s: String, ns: String): String = {
        if (s.isEmpty)
          ns
        else
        if (c == s(0))
          removeLetterDuplicates(c, s.substring(1), ns)
        else
          removeLetterDuplicates(c, s.substring(1), ns + s(0))
      }

      if (s.isEmpty)
        ns
      else
        helper(removeLetterDuplicates(s(0), s.substring(1), ""), ns + s(0))
    }

    helper(s, "")
  }


  def main(args: Array[String]): Unit = {
    println(removeDuplicates("PINEAPPLE"))      // PINEAL
  }
}
