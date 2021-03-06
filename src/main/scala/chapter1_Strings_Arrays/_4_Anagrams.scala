package chapter1_Strings_Arrays

import util.control.Breaks._

object _4_Anagrams {
  /*
    Imperative style. For each letter in s1, check if there is A match in s2; when the match is encountered,
    remove the matched character from the second string. In case there was no match the two words are not anagrams,
    so break out of the inner cycle and return false.
   */
  def anagrams(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length)
      return false

    var temp = s2
    for (i <- 0 until s1.length) {
      val m = temp.length
      breakable {
        for (j <- 0 until m)
          if (s1(i) == temp(j)) {
            temp = temp.substring(0, j) + temp.substring(j + 1, temp.length)
            break
          }
      }
      // if we didn't break out of the cycle it means there was no match, so temp wasn't modified
      if (m == temp.length)
        return false
    }
    true
  }

  /*
    Sort strings and compare them.
   */
  def anagrams_2(s1: String, s2: String): Boolean = s1.toSeq.sortWith(_ < _).unwrap == s2.toSeq.sortWith(_ < _).unwrap

  /*
    More modular and functional. Check for each character in s1 if there is A match in s2.

    Time complexity: O(n) - both strings (of same length) are scanned from end to end
    Space complexity: O(1) - no other data structures are created
   */
  def anagrams_3(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length)
      return false

    @scala.annotation.tailrec
    def helper(s1: String, s2: String): Boolean = {
      @scala.annotation.tailrec
      def matches(needle: Char, haystack: String): Boolean = {
        if (haystack.isEmpty) false
        else
          if (needle == haystack(0)) true
          else matches(needle, haystack.substring(1))
      }

      if (s1.isEmpty) true
      else
        if (matches(s1(0), s2))   helper(s1.substring(1), s2)
        else false
    }

    helper(s1, s2)
  }



  def main(args: Array[String]): Unit = {
    println(anagrams("restful", "fluster"))   // true
    println(anagrams("placebo", "obacalp"))   // false
    println(anagrams_2("restful", "fluster"))   // true
    println(anagrams_2("placebo", "obacalp"))   // false
    println(anagrams_3("restful", "fluster"))   // true
    println(anagrams_3("placebo", "obacalp"))   // false
  }
}
