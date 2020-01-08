package chapter2_Linked_Lists

object _4_SumListDigits {
  /*
    Define two recursive functions to convert lists to numbers and number s to lists.

    Time complexity: O(n) - scan three lists each once, so 3 constant is negligible
    Space complexity: O(1)
   */
  def addLists(n1: SingleLinkedListNode[Int], n2: SingleLinkedListNode[Int]): SingleLinkedListNode[Int] = {
    def listToNumber(node: SingleLinkedListNode[Int]): Int = {
      @scala.annotation.tailrec
      def helper(node: SingleLinkedListNode[Int], decimalExp: Int, number: Int): Int =
        if (node == null)   number
        else helper(node.next, decimalExp + 1, number + (node.data * Math.pow(10, decimalExp)).toInt)

      helper(node, 0, 0)
    }

    def numberToList(num: Int): SingleLinkedListNode[Int] = {
      def helper(number: Int): SingleLinkedListNode[Int] =
        if (number == 0) null
        else new SingleLinkedListNode[Int](number % 10, helper(number / 10))

      helper(num)
    }

    numberToList(listToNumber(n1) + listToNumber(n2))
  }




  def main(args: Array[String]): Unit = {
    val sl1 = new SingleLinkedListNode(3, new SingleLinkedListNode(1, new SingleLinkedListNode(5)))
    val sl2 = new SingleLinkedListNode(5, new SingleLinkedListNode(9, new SingleLinkedListNode(2)))
    //    println(numberToList(listToNumber(sl1) + listToNumber(sl2)).stringRepresentation)
    println(addLists(sl1, sl2).stringRepresentation)
  }
}
