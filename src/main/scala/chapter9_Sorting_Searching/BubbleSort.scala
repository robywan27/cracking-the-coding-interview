package chapter9_Sorting_Searching

// Check pair by pair if next element is smaller and swap (second loop goes forward)
object BubbleSort {
  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(j)
    arr(j) = arr(i)
    arr(i) = temp
  }

  def bubbleSort(arr: Array[Int]): Array[Int] = {
    for (i <- 0 until arr.length - 1) {
      var j = i
      while (j < arr.length - 1 && arr(j) > arr(j + 1)) {
        swap(arr, j, j + 1)
        j += 1
      }
    }
    arr
  }


  def main(args: Array[String]): Unit = {
    bubbleSort(Array(1, 7, 3, 5, 4, 10, 8)).foreach(e => print(s"$e "))     // 1, 3, 4, 5, 7, 8, 10
  }
}

