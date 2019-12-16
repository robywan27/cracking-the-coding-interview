package chapter1

/*
  String has C-style format with null pointer at the end: "abcd" as "abcd\0"
 */
object _2_ReverseString {
  /*
    Solution 1.
      Concise functional style recipe for:
        - take all characters but the last one (init)
        - concatenate them in reverse order (foldLeft)
        - concatenate last character (last)

      Time complexity: O(n) - scan of the string
      Space complexity: O(1) - no data structure created
   */
  def reverseString(cStyleStr: String): String = cStyleStr.init.foldLeft("") ((acc, x) => x + acc) + cStyleStr.last



  def main(args: Array[String]): Unit = {
    println(reverseString("abcd\u0000"))  // "dcba\u0000"
  }
}
