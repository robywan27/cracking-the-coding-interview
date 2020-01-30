package chapter3_Stacks_Queues

/*
  Exercise 2
 */

class StackWithMinimum[Int](top: NodeWithMinimum[Int] = null) extends Stack[Int](top) {
  override def push(data: Int): Unit = {
    val prev = top
    top = if (data < min) new NodeWithMinimum(data, data)
          else new NodeWithMinimum(data, min)
    top.next = prev
  }

  def min: Int =
    if (top == null)  Int.MaxValue.asInstanceOf[Int]
    else peek().asInstanceOf[NodeWithMinimum[Int]].min
}


object _2_MinElementInStack {

}
