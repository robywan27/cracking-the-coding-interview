package chapter9_Sorting_Searching

// Check pair by pair if previous element is smaller and swap (second loop goes backward)
object InsertionSort {
  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def insertionSort(arr: Array[Int]): Array[Int] = {
    for (i <- 1 until arr.length) {
      if (arr(i) < arr(i - 1)) {
        var j = i
        while (j > 0 && arr(j) < arr(j - 1)) {
          swap(arr, j, j - 1)
          j -= 1
        }
      }
    }
    arr
  }


  def main(args: Array[String]): Unit = {
    insertionSort(Array(1, 7, 3, 5, 4, 10, 8)).foreach(e => print(s"$e "))     // 1, 3, 4, 5, 7, 8, 10
  }
}
