package chapter2_Linked_Lists

import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag

object _1_RemoveDuplicateNodes {
  /*
    Keep track of two pointers, one pointing to the current and the other to the previous.
    If the data is in the array, move the pointer of the previous head to the current's next.
    Note that mutation takes place here: since previous and curr point to the same objects of n, their mutation
    affect n as well; that's why even though no operation is performed on n, it is modified nonetheless.

    Time complexity: O(n) - the list is traversed once
    Space complexity: O(n) - one array
   */
  def removeDuplicates[A: ClassTag](head: SingleLinkedListNode[A]): Unit = {
    var distinctDataElements = Array[A]()
    var previous = head
    var curr = head

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
    For each node from the start check if its data value is contained in later nodes; for any duplicate remove it from the list.
   */
  def removeDuplicates_2[A](head: SingleLinkedListNode[A]): Unit = {
    var nodeToCompare = head
    var prev = head
    var curr = head.next

    while (nodeToCompare.next != null) {
      while (curr != null) {
        if (curr.data == nodeToCompare.data)
          prev.next = curr.next
        curr = curr.next
        prev = prev.next
      }
      nodeToCompare = nodeToCompare.next
      prev = nodeToCompare
      curr = nodeToCompare.next
    }
  }


  /*
    Does not use side effects: the head given in input is not altered.
    Recursively navigate the list and check if the current head is not in the array keeping track of duplicates.
    If it is so, append it to A new list which is going to be returned.

    Time complexity: O(n) - the list is traversed once
    Space complexity: O(n^2) - two lists with n elements each
   */
  def removeDuplicates_3[A: ClassTag](node: SingleLinkedListNode[A]): Option[SingleLinkedListNode[A]] = {
    @scala.annotation.tailrec
    def helper(node: SingleLinkedListNode[A], distinctDataElements: ListBuffer[A], newNode: Option[SingleLinkedListNode[A]]): Option[SingleLinkedListNode[A]] = {
      if (node.next == null)
        newNode
      else {
        if (!distinctDataElements.contains(node.data)) {
          distinctDataElements += node.data
          newNode match {
            case None => helper(node.next, distinctDataElements, Some(new SingleLinkedListNode(node.data)))
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

    helper(node, ListBuffer[A](), None)
  }



  def main(args: Array[String]): Unit = {
    val sl = new SingleLinkedListNode(1, new SingleLinkedListNode(3, new SingleLinkedListNode(7, new SingleLinkedListNode(3,
      new SingleLinkedListNode(5, new SingleLinkedListNode(6, new SingleLinkedListNode(6, new SingleLinkedListNode(2))))))))
    println(sl.stringRepresentation)                           // 1 -> 3 -> 7 -> 3 -> 5 -> 6 -> 6 -> 2
    val sl2 = new SingleLinkedListNode(1, new SingleLinkedListNode(2, new SingleLinkedListNode(3, new SingleLinkedListNode(4, new SingleLinkedListNode(3, new SingleLinkedListNode(2))))))
    println(sl2.stringRepresentation)                          // 1 -> 2 -> 3 -> 4 -> 3 -> 2

    /*removeDuplicates(sl)
    removeDuplicates(sl2)
    println(sl.stringRepresentation)                           // 1 -> 3 -> 7 -> 5 -> 6 -> 2
    println(sl2.stringRepresentation)*/                          // 1 -> 2 -> 3 -> 4

    removeDuplicates_2(sl)
    removeDuplicates_2(sl2)
    println(sl.stringRepresentation)                           // 1 -> 3 -> 7 -> 5 -> 6 -> 2
    println(sl2.stringRepresentation)                          // 1 -> 2 -> 3 -> 4

    val listWithDistinctElements = removeDuplicates_3(sl)
    println(listWithDistinctElements match {                  // 1 -> 3 -> 7 -> 5 -> 6 -> 2
      case None => "List is empty"
      case Some(sl) => sl.stringRepresentation
    })
    // sl has not been changed
    println(sl.stringRepresentation)                           // 1 -> 3 -> 7 -> 3 -> 5 -> 6 -> 6 -> 2
  }
}
