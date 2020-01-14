package chapter9_Sorting_Searching

import scala.util.control.Breaks._

object _1_MergeInSortedOrder {
  def mergeInSortedOrder(A: Array[Int], B: Array[Int], lastNumericValueInAPosition: Int): Unit = {
    var i = lastNumericValueInAPosition - 1
    var j = B.length - 1
    var k = A.length - 1

    while (i >= 0 && j >= 0) {
      if (A(i) >= B(j)) {
        A(k) = A(i)
        k -= 1
        i -= 1
      }
      else {
        A(k) = B(j)
        k -= 1
        j -= 1
      }
    }
    while (j >= 0) {
      A(k) = B(j)
      k -= 1
      j -= 1
    }
  }


  /*
    Inefficient implementation.
   */
  def mergeInSortedOrder2(A: Array[Int], B: Array[Int]): Unit = {
    val ALength = A.length
    // find index of first empty cell in array A
    var firstEmptyValueIndex = 0
    breakable(
      for (i <- A.indices)
        if (A(i) == 0 && i != 0) {
          firstEmptyValueIndex = i
          break
        }
    )
    // check B element by element and insert it into A when current element in A is greater than element in B
    for (k <- B.indices) {
      var lastSavedIndexInA = 0
      breakable(
        for (i <- lastSavedIndexInA until ALength)
          if (B(k) < A(i)) {
            for (j <- firstEmptyValueIndex - 1 to i by -1)
              A(j + 1) = A(j)
            A(i) = B(k)
            firstEmptyValueIndex += 1
            lastSavedIndexInA = i
            break
          }
      )
    }
    // insert in A those elements in B greater than the max in A
    if (firstEmptyValueIndex != ALength)
      for (i <- firstEmptyValueIndex until ALength) {
        A(i) = B(B.length - (ALength - firstEmptyValueIndex))
        firstEmptyValueIndex += 1
      }
  }



  def main(args: Array[String]): Unit = {
    val a: Array[Int] = Array.ofDim(9)
    a(0) = 1; a(1) = 2; a(2) = 5; a(3) = 8; a(4) = 9
    val b: Array[Int] = Array(3, 4, 7, 11)

    mergeInSortedOrder(a, b, 5)
//    mergeInSortedOrder2(a, b)
    a.foreach(println)                                // 1 2 3 4 5 7 8 9 11

    println()

    val c: Array[Int] = Array.ofDim(9)
    c(0) = 1; c(1) = 2; c(2) = 5; c(3) = 8; c(4) = 9
    val d: Array[Int] = Array(3, 4, 10, 15) // two elements in B are greater than max in A

    mergeInSortedOrder(c, d, 5)
//    mergeInSortedOrder2(c, d)
    c.foreach(println)                                // 1 2 3 4 5 8 9 10 15
  }
}
