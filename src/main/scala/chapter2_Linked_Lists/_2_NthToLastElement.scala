package chapter2_Linked_Lists

object _2_NthToLastElement {
  /*
    Calculate length of list L. The nth to last position is given by L - N + 1.

    Time complexity: O(n) - scan the list twice
    Space complexity: O(1)
   */
  def nthElementToLast[A](node: SingleLinkedListNode[A], pos: Int): SingleLinkedListNode[A] = {
    val listLength = node.length
    val nthToLastPosition = listLength - pos + 1

    @scala.annotation.tailrec
    def loop(node: SingleLinkedListNode[A], c: Int): SingleLinkedListNode[A] = if (c == nthToLastPosition) node else loop(node.next, c + 1)

    loop(node, 1)
  }

  /*
    Move one pointer to position N - 1. Then move simultaneously this pointer to the last head and the other pointer.
    this pointer is at the Nth to last position.

    Time complexity: O(n) - scan the list once
    Space complexity: O(1)
   */
  def nthElementToLast_2[A](head: SingleLinkedListNode[A], pos: Int): SingleLinkedListNode[A] = {
    var ptr1 = head
    var ptr2 = head

    for (_ <- 0 until pos - 1)
      ptr2 = ptr2.next

    while (ptr2.next != null) {
      ptr1 = ptr1.next
      ptr2 = ptr2.next
    }

    ptr1
  }



  def main(args: Array[String]): Unit = {
    val sl = new SingleLinkedListNode(1, new SingleLinkedListNode(3, new SingleLinkedListNode(7, new SingleLinkedListNode(3,
      new SingleLinkedListNode(5, new SingleLinkedListNode(6, new SingleLinkedListNode(6, new SingleLinkedListNode(2))))))))
    println(nthElementToLast(sl, 5).stringRepresentation)
    println(nthElementToLast_2(sl, 5).stringRepresentation)
  }
}
