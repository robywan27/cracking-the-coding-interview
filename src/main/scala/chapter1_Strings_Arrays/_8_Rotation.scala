package chapter1_Strings_Arrays

object _8_Rotation {
  /*
    The algorithm goes like:
      - scan s1
      - when you match a character of s1 at index i with the first character of s2, check if the remaining part
        of s1 is substring of s2
        - if it is so, check the unmatched part of s1 from the beginning until index i and see if it matches with
          characters of s2 starting from index (length of s1 - i)

    Time complexity: O(n^2) + isSubstring complexity - scan s1 in isRotation and apply isSubstring
    Space complexity: O(1) - no additional data structure
   */
  def isRotation(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length)
      return false

    val n = s1.length
    for (i <- 0 until n) {
      if (s2(0) == s1(i) && isSubstring(s2, s1.substring(i))) {
        var flag = 0
        for (k <- 0 until i) {
          if (s1(k) != s2(n - i + k))
            flag = 1
        }
        if (flag == 0) return true
      }
    }
    false
  }

  /*
    Time complexity: complexity of isSubstring
    Space complexity: O(n) - another s1 copy is created
   */
  def isRotation_2(s1: String, s2: String): Boolean = if (isSubstring(s1 + s1, s2)) true else false

  /*
    Is s2 substring of s1? Time complexity of this algorithm is probably O(n*logn) or O(n^2)
   */
  @scala.annotation.tailrec
  def isSubstring(s1: String, s2: String): Boolean = {
    @scala.annotation.tailrec
    def helper(s1: String, s2: String): Boolean = {
      if (s1.length < s2.length)
        false
      else if (s2.isEmpty)
        true
      else if (s1.isEmpty)
        false
      else
        if (s1(0) != s2(0))   false
        else helper(s1.substring(1), s2.substring(1))
    }

    if (s1.isEmpty)
      false
    else
      if (helper(s1, s2))   true
      else isSubstring(s1.substring(1), s2)
  }



  def main(args: Array[String]): Unit = {
    println(isSubstring("abracadabra", "cada"))           // true
    println(isSubstring("abracadabra", "cade"))           // false
    println(isRotation("waterbottle", "erbottlewat"))     // true
    println(isRotation("waterbottle", "erbotletwat"))     // false
    println(isRotation_2("waterbottle", "erbottlewat"))   // true
    println(isRotation_2("waterbottle", "erbotletwat"))   // false
  }
}
