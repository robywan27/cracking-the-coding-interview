package chapter7_OO._1_card_deck

class BlackJackCard(color: Color, suit: Suit, rank: Rank) extends Card(color, suit, rank) {
  override def cardValue: Int =
    this.rank match {
      case Jack => 10
      case Queen => 10
      case King => 10
      case Ace => 11
      case Num(x) => x
    }
}
