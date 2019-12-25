package chapter3_Stacks_Queues

import chapter2_Linked_Lists.Node

class Queue[A](var first: Node[A] = null, var last: Node[A] = null) {
  def enqueue(data: A): Unit = {
    if (first != null) {
      last.next = new Node(data)
      last = last.next
    }
    else {
      last = new Node(data)
      first = last
    }
  }

  def dequeue: Node[A] = {
    if (first != null) {
      val temp = first
      first = first.next
      return new Node(temp.data)
    }
    null
  }
}


object QueueTester {
  def main(args: Array[String]): Unit = {
    val q = new Queue[Int]()

    q.enqueue(5)
    q.enqueue(7)
    q.enqueue(12)
    q.enqueue(1)
    println(q.first.stringRepresentation)
    println(q.last.stringRepresentation)

    q.dequeue
    println(q.first.stringRepresentation)
    q.dequeue
    println(q.first.stringRepresentation)
  }
}