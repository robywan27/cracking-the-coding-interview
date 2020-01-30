package chapter1_Strings_Arrays

object _7_ResetRowColumn {
  /*
    Scan the matrix to find the coordinates of 0 elements and save them in an array.
    Scan the array and zero all positions in same row and column for each element.
   */
  def resetRowColumn(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val m = mat.length
    val n = mat(0).length
    var zeroPositions: Array[(Int, Int)] = Array()

    for (i <- 0 until m)
      for (j <- 0 until n)
        if (mat(i)(j) == 0)
          zeroPositions :+= (i, j)

    if (zeroPositions.length == m * n)
        return mat

    for (zeroCoord <- zeroPositions) {
      for (k <- 0 until m)
        mat(k)(zeroCoord._2) = 0
      for (k <- 0 until n)
        mat(zeroCoord._1)(k) = 0
    }

    mat
  }

  /*
    Scan the matrix and store A dummy value (1) at the right row/column index in two ancillary arrays.
    Scan the matrix again and check the dummy value in the auxiliary arrays at the corresponding row/column index.

    Time complexity: O(m*n) - scan the matrix twice
    Space complexity: O(m*n) - two arrays of the dimensions of the matrix are created
   */
  def resetRowColumn_2(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val m = mat.length
    val n = mat(0).length
    val rows: Array[Int] = Array.ofDim(m)
    val columns: Array[Int] = Array.ofDim(n)

    for (i <- 0 until m)
      for (j <- 0 until n)
        if (mat(i)(j) == 0) {
          rows(i) = 1
          columns(j) = 1
        }

    for (i <- 0 until m)
      for (j <- 0 until n)
        if (rows(i) == 1 || columns(j) == 1)
          mat(i)(j) = 0

    mat
  }



  def main(args: Array[String]): Unit = {
//    val m = resetRowColumn(Array(Array(1, 2, 3, 0), Array(1, 0, 4, 4), Array(2, 3, 7, 2)))
    val m = resetRowColumn_2(Array(Array(1, 2, 3, 0), Array(1, 0, 4, 4), Array(2, 3, 7, 2)))
    for (i <- 0 until 3) {
      for (j <- 0 until 4)
        print(m(i)(j))   // Array(Array(0, 0, 0, 0), Array(0, 0, 0, 0), Array(2, 0, 7, 0))
      println()
    }
  }
}
