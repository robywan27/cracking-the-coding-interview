import org.scalatest.FunSuite
import chapter2_Linked_Lists.Node
import chapter2_Linked_Lists._1_RemoveDuplicateNodes
import chapter2_Linked_Lists._2_NthToLastElement
import chapter2_Linked_Lists._3_DeleteNodeInTheMiddle
import chapter2_Linked_Lists._4_SumListDigits
import chapter2_Linked_Lists._5_BeginningOfLoop

class Chapter2Test extends FunSuite {
  test("_1_RemoveDuplicateNodes") {
    var sl = new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2))))))))
    _1_RemoveDuplicateNodes.removeDuplicates(sl)
    assert(sl.stringRepresentation === "1 -> 3 -> 7 -> 5 -> 6 -> 2")

    var sl2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(3, new Node(2))))))
    _1_RemoveDuplicateNodes.removeDuplicates(sl2)
    assert(sl2.stringRepresentation === "1 -> 2 -> 3 -> 4")

    sl = new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2))))))))
    _1_RemoveDuplicateNodes.removeDuplicates_2(sl)
    assert(sl.stringRepresentation === "1 -> 3 -> 7 -> 5 -> 6 -> 2")

    sl2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(3, new Node(2))))))
    _1_RemoveDuplicateNodes.removeDuplicates_2(sl2)
    assert(sl2.stringRepresentation === "1 -> 2 -> 3 -> 4")
  }


  test("_2_NthToLastElement") {
    assert(_2_NthToLastElement.nthElementToLast(new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2)))))))), 5).stringRepresentation === "3 -> 5 -> 6 -> 6 -> 2")
    assert(_2_NthToLastElement.nthElementToLast(new Node(10, new Node(4, new Node(7, new Node(3,
      new Node(5, new Node(8, new Node(6, new Node(2, new Node(2, new Node(9)))))))))), 7)
      .stringRepresentation === "3- > 5 -> 8 -> 6 -> 2 -> 2 -> 9")

    assert(_2_NthToLastElement.nthElementToLast(new Node(1, new Node(3, new Node(7, new Node(3,
      new Node(5, new Node(6, new Node(6, new Node(2)))))))), 5).stringRepresentation === "3 -> 5 -> 6 -> 6 -> 2")
    assert(_2_NthToLastElement.nthElementToLast(new Node(10, new Node(4, new Node(7, new Node(3,
      new Node(5, new Node(8, new Node(6, new Node(2, new Node(2, new Node(9)))))))))), 7)
      .stringRepresentation === "3 -> 5 -> 8 -> 6 -> 2 -> 2 -> 9")
  }


  test("_3_DeleteNodeInTheMiddle") {
    var sl = new Node('c', new Node('d', new Node('e')))
    var sl2 = new Node('a', new Node('b', sl))
    _3_DeleteNodeInTheMiddle.deleteNodeInTheMiddle(sl)
    assert(sl2.stringRepresentation === "a -> b -> d -> e")
  }


  test("_4_SumListDigits") {
    assert(_4_SumListDigits.addLists(new Node(3, new Node(1, new Node(5))),
      new Node(5, new Node(9, new Node(2)))).stringRepresentation === "8 -> 0 -> 8")
    assert(_4_SumListDigits.addLists(new Node(8, new Node(2, new Node(1))),
      new Node(7, new Node(6, new Node(3)))).stringRepresentation === "5 -> 9 -> 4")
  }


  test("_5_BeginningOfLoop") {
    val n: Node[Int] = new Node(1)
    val circularList: Node[Int] = new Node(5, new Node(2, n))
    val l = new Node(5, new Node(7, n))
    circularList.appendNodeToTail(l)
    val bol = _5_BeginningOfLoop.beginningOfLoop(circularList)
    assert(bol == n)
    assert(bol.data === 1)
  }
}
