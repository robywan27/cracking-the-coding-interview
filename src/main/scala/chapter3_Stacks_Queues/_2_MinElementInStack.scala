package chapter3_Stacks_Queues

import chapter2_Linked_Lists.Node

object _2_MinElementInStack {
  /*class StackWithMin extends Stack[Int] {
    class NodeWithMin(data: Int, var minIrrespectiveOfData: Int) extends Node[Int](data)

    var min: Int = 0

    override def push(data: Int): Unit = {
      val prev = top

      if (top == null) {
        min = data
        top = new NodeWithMin(data, min)
      }
      else if (data < min) {
        top = new NodeWithMin(data, min)
        min = data
      }
      else
        top = new NodeWithMin(data, min)

      top.next = prev
    }

    override def pop: Node[Int] = {
      if (top != null) {
        if (top.data == min)
          min =  top.minIrrespectiveOfData
        val headContent = top.data
        top = top.next
        return new Node(headContent)
      }
      null
    }

    /*
      Time complexity: O(1)
      Space complexity: O(1)
     */
    def min(st: Stack[Int]): Int = min
  }



  /*
    Solution for the traditional stack.

    Time complexity: O(n) - scan the stack
    Space complexity: O(1)
   */
  def min_2(st: Stack[Int]): Int = {
    var min = Integer.MAX_VALUE
    while (st.top != null) {
      if (st.top.data < min)
        min = st.top.data
      st.top = st.top.next
    }
    min
  }


  def main(args: Array[String]): Unit = {
    val s = new StackWithMin()
    s.push(5)
    s.push(7)
    s.push(3)
    s.push(2)
    s.push(9)
    s.push(7)
    println(min_2(s))

    val d = s.pop
    println(d)
    println(s)
  }*/
}
