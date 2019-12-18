package chapter2_Linked_Lists

object _5_BeginningOfLoop {
  /*
    Keep track of the distinct nodes in an array.

    Time complexity: O(n) - scan nodes once
    Space complexity: O(n)
   */
  def beginningOfLoop[A](head: Node[A]): Node[A] = {
    var curr = head
    var distinctNodes: Array[Node[A]] = Array()

    while (curr.next != null) {
      if (distinctNodes.contains(curr))
        return curr
      distinctNodes +:= curr
      curr = curr.next
    }

    curr
  }



  def main(args: Array[String]): Unit = {
    val n: Node[Int] = new Node(1)
    val circularList: Node[Int] = new Node(5, new Node(2, n))
    val l = new Node(5, new Node(7, n))
    circularList.appendNodeToTail(l)
    val bol = beginningOfLoop(circularList)
    println(bol)
    println(n)
    println(bol.data)
  }
}
