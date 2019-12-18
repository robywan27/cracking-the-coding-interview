package chapter2_Linked_Lists

object _2_NthToLastElement {
  def nthElement(node: Node, n: Int): Node = {
    @scala.annotation.tailrec
    def helper(node: Node, c: Int): Node = if (c == n) node else helper(node.next, c + 1)

    helper(node, 1)
  }



  def main(args: Array[String]): Unit = {
    val n = new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2))))))))
    println(nthElement(n, 5).stringRepresentation
    )
  }
}
