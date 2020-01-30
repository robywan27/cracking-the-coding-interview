package chapter3_Stacks_Queues

import chapter2_Linked_Lists.SingleLinkedListNode

class Stack[A](var top: SingleLinkedListNode[A] = null) {
  def push(data: A): Unit = {
    val prev = top
    top = new SingleLinkedListNode(data)
    top.next = prev
  }

  def pop: SingleLinkedListNode[A] = {
    if (top != null) {
      val headData = top.data
      top = top.next
      return new SingleLinkedListNode(headData)
    }
    null
  }

  def peek(): SingleLinkedListNode[A] = {
    val topNode = pop
    push(topNode.data)
    topNode
  }
}


object StackTester {
  def main(args: Array[String]): Unit = {
    val s = new Stack[Int]()
    s.push(1)
    s.push(6)
    s.push(5)
    println(s.top.stringRepresentation)

    val n = s.pop
    println(n.data)

    println(s.top.stringRepresentation)
  }
}