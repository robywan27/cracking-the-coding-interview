package chapter2_Linked_Lists

object _5_BeginningOfLoop {
  /*
    Keep track of the distinct nodes in an array.

    Time complexity: O(n) - scan nodes once
    Space complexity: O(n)
   */
  def beginningOfLoop[A](head: SingleLinkedListNode[A]): SingleLinkedListNode[A] = {
    var curr = head
    var distinctNodes: Array[SingleLinkedListNode[A]] = Array()

    while (curr.next != null) {
      if (distinctNodes.contains(curr))
        return curr
      distinctNodes +:= curr
      curr = curr.next
    }

    curr
  }



  def main(args: Array[String]): Unit = {
    val n: SingleLinkedListNode[Int] = new SingleLinkedListNode(1)
    val circularList: SingleLinkedListNode[Int] = new SingleLinkedListNode(5, new SingleLinkedListNode(2, n))
    val l = new SingleLinkedListNode(5, new SingleLinkedListNode(7, n))
    circularList.appendNodeToTail(l)
    val bol = beginningOfLoop(circularList)
    println(bol)
    println(n)
    println(bol.data)
  }
}
