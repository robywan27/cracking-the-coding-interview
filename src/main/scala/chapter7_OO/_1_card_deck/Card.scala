package chapter7_OO._1_card_deck

class Card(val color: Color, val suit: Suit, val rank: Rank) {
  def cardValue: Int =
    this.rank match {
      case Jack => 10
      case Queen => 10
      case King => 10
      case Ace => 11
      case Num(x) => x
    }

//  override def toString: String = super.toString
}
