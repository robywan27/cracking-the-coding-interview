package chapter2_Linked_Lists

object _3_DeleteNodeInTheMiddle {
  /*
    Note that you have to overwrite the content of the node, not the reference, otherwise there is no side effect.
    So something like curr = next would not alter the list.

    Time complexity: O(1)
    Space complexity: O(1)
   */
  def deleteNodeInTheMiddle[A](n: SingleLinkedListNode[A]): Unit = {
    val curr = n
    val next = n.next
    curr.data = next.data
    curr.next = next.next
  }


  def main(args: Array[String]): Unit = {
    var sl = new SingleLinkedListNode('c', new SingleLinkedListNode('d', new SingleLinkedListNode('e')))
    var sl2 = new SingleLinkedListNode('a', new SingleLinkedListNode('b', sl))

    deleteNodeInTheMiddle(sl)
    println(sl.stringRepresentation)
    println(sl2.stringRepresentation)
  }
}
