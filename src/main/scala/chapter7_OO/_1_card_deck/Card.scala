package chapter7_OO._1_card_deck

abstract class Card(val color: Color, val suit: Suit, val rank: Rank) {
  def cardValue: Int

//  override def toString: String = super.toString
}
