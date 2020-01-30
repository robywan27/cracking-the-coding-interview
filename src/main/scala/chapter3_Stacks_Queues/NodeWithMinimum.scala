package chapter3_Stacks_Queues

import chapter2_Linked_Lists.SingleLinkedListNode

class NodeWithMinimum[A](data: A, var min: A, next: NodeWithMinimum[A] = null) extends SingleLinkedListNode(data) {

}
