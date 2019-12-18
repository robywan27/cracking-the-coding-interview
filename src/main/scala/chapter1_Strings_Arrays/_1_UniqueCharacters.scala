package chapter1_Strings_Arrays

object _1_UniqueCharacters {
  /*
    Solution 1.
      Employs a List as auxiliary data structure to keep track of letters encountered. If a letter is found in the list,
      then the string has not unique characters.

      Time complexity: O(n) - scan of the string
      Space complexity: O(n) - a new list is created
   */
  def hasAllUniqueCharacters(s: String): Boolean = {
    @scala.annotation.tailrec
    def loop(word: String, li: List[Char]): Boolean =
      if (word.isEmpty)
        true
      else
        if (li.contains(word(0))) false
        else loop(word.tail, word(0) :: li)

    loop(s, List[Char]())
  }

  /*
    Solution 2.
      No data structures are used but two cycles are needed. If the same letter is encountered twice in the inner loop,
      then the string has not unique characters. Note that the first match is with itself.

      Time complexity: O(n^2) - double scan of the string
      Space complexity: O(1) - no data structure created
   */
  def hasAllUniqueCharacters_2(s: String): Boolean = {
    for (i <- s) {
      var i_counter = 0
      for (j <- s) {
        if (i == j)
          i_counter += 1
        if (i_counter > 1)
          return false
      }
    }
    true
  }

  /*
    Solution 3.
      Sort the string and check if any contiguous letters are the same.

      Time complexity: O(n) or more - sorting plus linear scan of string
      Space complexity: O(1) - no data structure created
   */
  def hasAllUniqueCharacters_3(s: String): Boolean = {
    val sortedS = s.toSeq.sortWith(_ < _).unwrap
    for (i <- 0 to sortedS.length - 2)
      if (sortedS(i) == sortedS(i + 1)) return false
    true
  }

  /*
    Solution 4.
      Convert the string to set and compare length differences. Remember that sets have only distinct elements.

      Time complexity: O(n) - the conversion to set
      Space complexity: O(n) - creation of a new set
   */
  def hasAllUniqueCharacters_4(s: String): Boolean = {
    if (s.toSet.size != s.length) false
    else true
  }



  def main(args: Array[String]): Unit = {
    println(hasAllUniqueCharacters("STRINGA"))    // true
    println(hasAllUniqueCharacters("CASA"))       // false
    println(hasAllUniqueCharacters_2("STRINGA"))  // true
    println(hasAllUniqueCharacters_2("CASA"))     // false
    println(hasAllUniqueCharacters_3("STRINGA"))  // true
    println(hasAllUniqueCharacters_3("CASA"))     // false
    println(hasAllUniqueCharacters_4("STRINGA"))  // true
    println(hasAllUniqueCharacters_4("CASA"))     // false
  }
}
