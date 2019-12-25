package chapter7_OO._4_chess

sealed trait PieceType
case object Pawn extends PieceType
case object Bishop extends PieceType
case object Knight extends PieceType
case object Rook extends PieceType
case object Queen extends PieceType
case object King extends PieceType
