package chapter7_OO._1_card_deck

object CardDeckTester {
  def main(args: Array[String]): Unit = {
    val c1 = new Card(Red, Diamonds, Num(2))
    val c2 = new Card(Black, Spades, Jack)
//    val deck = new Deck(List(c1, ..., c2, ....))
    println(c1)
    println(c1.cardValue)
    println(c2)
    println(c2.cardValue)
  }
}