package chapter8_Recursion

object _8_EightQueens {
  def position8Queens(): Unit = {
    val columnForRow: Array[Int] = Array.ofDim(8)

    def check(row: Int): Boolean = {
      for (i <- 0 until row) {
        val diff = Math.abs(columnForRow(i) - columnForRow(row))
        if (diff == 0 || diff == row - i)
          false
      }
      true
    }

    def placeQueen(row: Int): Unit = {
      if (row == 8)
        return
      for (i <- 0 until 8) {
        columnForRow(row) = i
        if (check(row))
          placeQueen(row + 1)
      }
    }

    placeQueen(0)
  }


  def main(args: Array[String]): Unit = {
    position8Queens()
  }
}
