package chapter9_Sorting_Searching

// Find minimum of each subarray starting from left and put minimum at start of subarray
object SelectionSort {
  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def insertionSort(arr: Array[Int]): Array[Int] = {
    for (i <- 0 until arr.length - 1) {
      var minIdx = i
      for (j <- i + 1 until arr.length)
        if (arr(j) < arr(minIdx))
          minIdx = j
      swap(arr, minIdx, i)
    }
    arr
  }


  def main(args: Array[String]): Unit = {
    insertionSort(Array(1, 7, 3, 5, 4, 10, 8)).foreach(e => print(s"$e "))     // 1, 3, 4, 5, 7, 8, 10
  }
}
