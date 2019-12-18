package chapter2_Linked_Lists

class Node(var data: Int, var next: Node = null) {
  def appendToTail(d: Int): Unit = {
    val newEntry: Node = new Node(d)
    var current = this
    while (current.next != null)
      current = current.next
    current.next = newEntry
  }

  def deleteNode(head: Node, d: Int): Node = {
    var current = head
    if (current.data == d)
      return head.next

    while (current.next != null) {
      if (current.next.data == d) {
        current.next = current.next.next
        return head
      }
      current = current.next
    }

    head
  }

  def stringRepresentation: String = {
    var curr = this
    val sb = new StringBuilder("")
    while (curr.next != null) {
      sb.append(curr.data + " -> ")
      curr = curr.next
    }
    sb.append(curr.data)
    sb.toString()
  }
}



object NodeTester {
  def main(args: Array[String]): Unit = {
    val n = new Node(3, new Node(11))
    val n2 = new Node(7, n)
    val n3 = new Node(1, n2)
    val node = new Node(15, n3)

    println(node.stringRepresentation)   // 15 -> 1 -> 7 -> 3 -> 11
    println(n2.stringRepresentation)     // 7 -> 3 -> 11

    n2.appendToTail(13)
    println(node.stringRepresentation)   // 15 -> 1 -> 7 -> 3 -> 11 -> 13
    node.appendToTail(12)
    println(node.stringRepresentation)   // 15 -> 1 -> 7 -> 3 -> 11 -> 13 -> 12

    n3.deleteNode(node, 3)
    println(node.stringRepresentation)   // 15 -> 1 -> 7 -> 11 -> 13 -> 12
    n.deleteNode(node, 12)
    println(node.stringRepresentation)   // 15 -> 1 -> 7 -> 11 -> 13
  }
}
