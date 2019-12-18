package chapter1_Strings_Arrays

object _6_Rotate90Degrees {
  /*def rotate90Degrees(img: Array[Array[Int]]): Array[Array[Int]] = {
    val n = img.length
    val m = img(0).length
    var i = 0

    for (j <- 0 until n - 1) {
      var temp = 0
      var temp2 = 0
      if (j % 2 == 0)
        temp = img(i)(j + 1)
      else
        temp2 = img(i)(j + 1)
      img(i)(j + 1) = img(i)(j)
    }
  }
  }



  def main(args: Array[String]): Unit = {
    val m = rotate90Degrees(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)))
    for (i <- 0 until 3) {
      for (j <- 0 until 4)
        print(m(i)(j))   // Array(Array(0, 0, 0, 0), Array(0, 0, 0, 0), Array(2, 0, 7, 0))
      println()
  }*/
}
