package chapter8_Recursion

object _3_AllSubsets {
  def allSubsets[A](set: Set[A]): Set[Set[A]] = {
    def helper(set: Set[A]): Set[Set[A]] = {
      if (set.isEmpty)  Set()
      else {
        val subsets = helper(set.init)
        subsets ++ subsets.map(e => e + set.last) + Set(set.last)
      }
    }

    helper(set) + Set()
  }

  def main(args: Array[String]): Unit = {
    println(allSubsets(Set()))
    println(allSubsets(Set(1)))
    println(allSubsets(Set(1, 2)))
    println(allSubsets(Set(1, 2, 3)))
    println(allSubsets(Set(1, 2, 3, 4)))
    println(allSubsets(Set(1, 2, 3, 4, 5)))
  }
}
