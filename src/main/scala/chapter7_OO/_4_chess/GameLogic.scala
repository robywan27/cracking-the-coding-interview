package chapter7_OO._4_chess

class GameLogic(val players: Array[Player]) {
  // This map contains the mapping between each piece and its coordinates on the grid.
  // The board is a 8x8 grid; each player has 16 pieces. So this map contains 32 elements initially.
  val board: Map[Piece, (Int, Int)] = Map()
  var turn = 0

  // Initialize the board by assigning for each piece its initial position in the grid.
  def initBoard(): Unit = println("Grid initialized")

  def nextTurn(): Unit = turn = (turn + 1) % 2

  // Check if the target cell is valid:
    // Is it in the grid?
    // Is the target cell a valid move for the piece?
    // Is the cell occupied by a piece of the same player?
  def validateMove(piece: Piece, coords: (Int, Int)): Boolean = true

  // Update the board map assigning the new coordinate to the piece.
  // If the cell was occupied by an enemy, remove that piece.
  def makeMove(piece: Piece, coords: (Int, Int)): Unit = println("Piece moved")

  // Check if it is checkmate at the end of the turn
  def checkMate(): Boolean = false
}
