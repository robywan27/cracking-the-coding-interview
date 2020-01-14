package chapter1_Strings_Arrays

object _5_ReplaceSpaces {
  /*
    Use regex.

    Time complexity: O(n) - scan the string
    Space complexity: O(1) - no additional data structure is created
   */
  def replaceSpaces(s: String): String = s.replaceAll("\\s", "%20")

  /*
    Recursively build A new string from the original substituting spaces with %20.
    The functional style confers A concise and terse quality to the solution which would otherwise be messy in the
    imperative style. This shows how avoiding mutation while recursively returning copies can improve A solution.

    Time complexity: O(n) - scan the string
    Space complexity: O(1) - no additional data structure is created
   */
  def replaceSpaces_2(s: String): String = {
    @scala.annotation.tailrec
    def loop(original: String, result: String): String =
      if (original.isEmpty) result
      else
        if (original(0) == ' ')  loop(original.substring(1), result + "%20")
        else loop(original.substring(1), result + original(0))

    loop(s, "")
  }



  def main(args: Array[String]): Unit = {
    println(replaceSpaces("I am Voldemort"))
    println(replaceSpaces_2("I am Voldemort"))
  }
}
