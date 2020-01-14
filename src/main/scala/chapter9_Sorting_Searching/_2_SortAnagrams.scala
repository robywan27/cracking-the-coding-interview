package chapter9_Sorting_Searching

class _2_SortAnagrams {
  def sortAnagrams(strings: List[String]): List[String] = {

  }


  def main(args: Array[String]): Unit = {
    val strings = List("CASA", "TOMBOLA", "CORDA", "SACA", "BIBITA", "ASAC")
    val sortedStrings = sortAnagrams(strings)
    sortedStrings.foreach(println)
  }
}
