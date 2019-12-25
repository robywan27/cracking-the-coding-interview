package chapter8_Recursion

object _3_AllSubsets {
  def allSubsets[A](set: List[A]): List[List[A]] = {
    val allSubsets: List[List[A]] = List()

    def helper(smallerSubset: List[A]): List[List[A]] = {
      if (smallerSubset.isEmpty)
        List()
      val allSubsetsOfFirst: List[List[A]] = helper(List(smallerSubset.head)) ++ allSubsets
      helper(smallerSubset.tail) ++ allSubsetsOfFirst
    }

    val first = set.head
    helper(set.tail)
  }

  def main(args: Array[String]): Unit = {
    println(allSubsets(Set(1, 2, 3, 4, 5).toList))
  }
}
