package chapter9_Sorting_Searching

import java.util

/*
  Define a comparator class - Java style.
 */
class AnagramComparator extends java.util.Comparator[String] {
  def sortChars(s: String): String = {
    val content = s.toCharArray
    util.Arrays.sort(content)
    content.toString
  }

  def compare(s1: String, s2: String): Int = sortChars(s1).compareTo(sortChars(s2))
}



object _2_SortAnagrams {
  /*
    Define a function for detecting anagrams and group together anagrams in the array.
   */
  def sortAnagrams(strings: Array[String]): Unit = {
    def anagrams(s1: String, s2: String): Boolean = s1.sortWith(_ < _) == s2.sortWith(_ < _)

    for (i <- 0 until strings.length - 1) {
      val k = i + 1
      for (j <- k + 1 until strings.length)
        if (anagrams(strings(i), strings(j))) {
          val temp = strings(j)
          strings(j) = strings(k)
          strings(k) = temp
        }
    }
  }



  def main(args: Array[String]): Unit = {
    val strings = Array("CASA", "TOMBOLA", "CORDA", "SACA", "BIBITA", "ASAC")
    util.Arrays.sort(strings, new AnagramComparator())
    strings.foreach(println)
    println()
    sortAnagrams(strings)
    strings.foreach(println)

    println()

    val strings2 = Array("ABBA", "BABA", "LITA", "HEAD", "ABCA", "TAIL", "ABAB")
    util.Arrays.sort(strings2, new AnagramComparator())
    strings2.foreach(println)
    println()
    sortAnagrams(strings2)
    strings2.foreach(println)
  }
}
