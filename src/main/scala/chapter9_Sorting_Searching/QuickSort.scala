package chapter9_Sorting_Searching

object QuickSort {
  // Functional solution. Note the use of List (immutable DS) here
  def quickSortFunctional(l: List[Int]): List[Int] = {
    l match {
      case Nil => Nil
      case (p :: xs) =>
        quickSortFunctional(xs.filter(_ < p)) ++ List(p) ++ quickSortFunctional(xs.filter(_ >= p))
    }
  }


  // Imperative solution with mutation
  def quickSort(arr: Array[Int]): Array[Int] = {
    def swap(arr: Array[Int], i: Int, j: Int): Unit = {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    def partition(arr: Array[Int], left: Int, right: Int, pivot: Int): Int = {
      var l = left
      var r = right
      while (l <= r) {
        while (arr(l) < pivot)
          l += 1
        while (arr(r) > pivot)
          r -= 1
        if (l <= r) {
          swap(arr, l, r)
          l += 1
          r -= 1
        }
      }
      l
    }

    def qsUtility(arr: Array[Int], left: Int, right: Int): Array[Int] = {
      if (left >= right)
        arr
      else {
        val pivot = arr((left + right) / 2)
        val partitionIdx = partition(arr, left, right, pivot)
        qsUtility(arr, left, partitionIdx - 1)
        qsUtility(arr, partitionIdx, right)
      }
    }

    qsUtility(arr, 0, arr.length - 1)
  }



  def main(args: Array[String]): Unit = {
    // List is not mutated after invoking sort function
    val li = List(1, 7, 3, 5, 4, 10, 8)
    li.foreach(e => print(s"$e "))                          // 1, 7, 3, 5, 4, 10, 8
    println()
    quickSortFunctional(li).foreach(e => print(s"$e "))     // 1, 3, 4, 5, 7, 8, 10
    println()
    li.foreach(e => print(s"$e "))                          // 1, 7, 3, 5, 4, 10, 8
    println()

    // Array is mutated after invoking sort function
    val arr = Array(1, 7, 3, 5, 4, 10, 8)
    arr.foreach(e => print(s"$e "))                         // 1, 7, 3, 5, 4, 10, 8
    println()
    quickSort(arr).foreach(e => print(s"$e "))              // 1, 3, 4, 5, 7, 8, 10
    println()
    arr.foreach(e => print(s"$e "))                         // 1, 3, 4, 5, 7, 8, 10
  }
}
