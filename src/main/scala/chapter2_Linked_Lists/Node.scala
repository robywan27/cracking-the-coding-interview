package chapter2_Linked_Lists

class Node[A](var data: A, var next: Node[A] = null) {
  def appendToTail(d: A): Unit = {
    val newEntry: Node[A] = new Node(d)
    var current = this
    while (current.next != null)
      current = current.next
    current.next = newEntry
  }

  def appendNodeToTail(newEntry: Node[A]): Unit = {
    var current = this
    while (current.next != null)
      current = current.next
    current.next = newEntry
  }

  // Returns the head of the list. Note that it also actually delete the head of the list as side effect.
  // However in case of head deletion, there is no side effect. You should just grab the copy of the list returned.
  def deleteNode(head: Node[A], d: A): Node[A] = {
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

  def length: Int = {
    @scala.annotation.tailrec
    def loop(nd: Node[A], len: Int): Int = if (nd == null) len else loop(nd.next, 1 + len)
    loop(this, 0)
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
    var node = new Node(15, n3)

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
    node = n.deleteNode(node, 15)
    println(node.stringRepresentation)   // 1 -> 7 -> 11 -> 13
  }
}
