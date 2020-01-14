package chapter8_Recursion

sealed trait Color
case object Blue extends Color
case object Red extends Color
case object Yellow extends Color
case object White extends Color
case object Black extends Color

object _6_PaintFill {
  def paintFill(screen: Array[Array[Color]], x: Int, y: Int, newColor: Color): Unit = {
    val n = screen.length
    val startingColor = screen(x)(y)

    def helper(screen: Array[Array[Color]], x: Int, y: Int): Unit = {
      if ((x >= 0 && x < n) && (y >= 0 && y < n) && screen(x)(y) == startingColor) {
        screen(x)(y) = newColor
        helper(screen, x - 1, y)
        helper(screen, x + 1, y)
        helper(screen, x, y - 1)
        helper(screen, x, y + 1)
      }
    }

    helper(screen, x, y)
  }


  def main(args: Array[String]): Unit = {
    val screen: Array[Array[Color]] = Array(Array(Yellow, Yellow, Yellow), Array(Yellow, Yellow, White), Array(Red, Yellow, Blue))
    paintFill(screen, 0, 0, Black)
    screen.foreach(row =>
      {
        row.foreach(col => print(s"$col "))
        println()
      }
    )

  }
}
