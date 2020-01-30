package chapter1_Strings_Arrays

object _3_RemoveDuplicates {
  /*
    Recursive solution.
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
