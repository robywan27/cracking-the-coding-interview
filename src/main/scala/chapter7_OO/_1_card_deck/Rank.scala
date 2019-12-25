package chapter7_OO._1_card_deck

sealed trait Rank
case object Jack extends Rank
case object Queen extends Rank
case object King extends Rank
case object Ace extends Rank
case class Num(value: Int) extends Rank
