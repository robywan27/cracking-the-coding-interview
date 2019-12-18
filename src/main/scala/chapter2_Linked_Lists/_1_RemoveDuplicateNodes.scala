package chapter2_Linked_Lists

import scala.collection.mutable.ListBuffer

object _1_RemoveDuplicateNodes {
  /*
    Solution 1.
      Keep track of two pointers, one pointing to the current and the other to the previous.
      If the data is in the array, move the pointer of the previous node to the current's next.
      Note that mutation takes place here: since previous and curr point to the same objects of n, their mutation
      affect n as well; that's why even though no operation is performed on n, it is modified nonetheless.

      Time complexity: O(n) - the list is traversed once
      Space complexity: O(n) - one array
   */
  def removeDuplicates(n: Node): Unit = {
    var distinctDataElements = Array[Int]()
    var previous = n
    var curr = n

    while (curr != null) {
      if (distinctDataElements.contains(curr.data))
        previous.next = curr.next
      else {
        distinctDataElements +:= curr.data
        previous = curr
      }
      curr = curr.next
    }
  }


  /*
    Solution 2.
      Does not use side effects: the node given in input is not altered.
      Recursively navigate the list and check if the current node is not in the array keeping track of duplicates.
      If it is so, append it to a new list which is going to be returned.

      Time complexity: O(n) - the list is traversed once
      Space complexity: O(n^2) - two lists with n elements each
   */
  def removeDuplicates_2(node: Node): Option[Node] = {
    @scala.annotation.tailrec
    def helper(node: Node, distinctDataElements: ListBuffer[Int], newNode: Option[Node]): Option[Node] = {
      if (node.next == null)
        newNode
      else {
        if (!distinctDataElements.contains(node.data)) {
          distinctDataElements += node.data
          newNode match {
            case None => helper(node.next, distinctDataElements, Some(new Node(node.data)))
            case Some(n) => {
              n.appendToTail(node.data)
              helper(node.next, distinctDataElements, Some(n))
            }
          }
        }
        else
          helper(node.next, distinctDataElements, newNode)
      }
    }

    helper(node, ListBuffer[Int](), None)
  }


  /*
    Solution 3.

   */
  /*def removeDuplicates_3(n: Node): Unit = {
    var curr = n

    while (curr != null) {
      var prev = curr
      var sentinel = curr.next
      println(s"${curr.stringRepresentation} &&& ${prev.stringRepresentation} &&& ${sentinel.stringRepresentation}")
      while (sentinel != null || prev != null) {
        if (sentinel.data == curr.data) {
          prev.next = sentinel.next
          println(s"if___ ${prev.stringRepresentation} &&& ${sentinel.stringRepresentation}")
        } else {
          println(s"else__- ${prev.stringRepresentation} &&& ${sentinel.stringRepresentation}")
          prev = sentinel
        }
        sentinel = sentinel.next
      }
      curr = curr.next
    }
  }*/



  def main(args: Array[String]): Unit = {
    val n = new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2))))))))
    println(n.stringRepresentation)                           // 1 -> 3 -> 7 -> 3 -> 5 -> 6 -> 6 -> 2
    val n2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(3, new Node(2))))))
    println(n2.stringRepresentation)                          // 1 -> 2 -> 3 -> 4 -> 3 -> 2

    /*val listWithDistinctElements = removeDuplicates_2(n)
    println(listWithDistinctElements match {                  // 1 -> 3 -> 7 -> 5 -> 6 -> 2
      case None => "List is empty"
      case Some(n) => n.stringRepresentation
    })
    // n has not been changed
    println(n.stringRepresentation)*/                           // 1 -> 3 -> 7 -> 3 -> 5 -> 6 -> 6 -> 2

    /*removeDuplicates(n)
    removeDuplicates(n2)
    println(n.stringRepresentation)                           // 1 -> 3 -> 7 -> 5 -> 6 -> 2
    println(n2.stringRepresentation)*/                          // 1 -> 2 -> 3 -> 4

//    removeDuplicates_3(n)
//    removeDuplicates_3(n2)
//    println(n.stringRepresentation)                           // 1 -> 3 -> 7 -> 5 -> 6 -> 2
//    println(n2.stringRepresentation)                          // 1 -> 2 -> 3 -> 4
  }
}
