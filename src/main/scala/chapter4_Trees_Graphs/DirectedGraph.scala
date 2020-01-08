package chapter4_Trees_Graphs

class DirectedGraph[A](var first: DirectedGraphNode[A]) {
  def findElement(data: A): Option[DirectedGraphNode[A]] = {
    def helper(edges: Option[List[DirectedGraphNode[A]]]): Option[DirectedGraphNode[A]] =
      edges match {
        case None => None
        case Some(edges) =>
          edges match {
            case Nil => None
            case (e :: es) =>
              if (e.data == data)   Some(e)
              else {
                // search among the adjacent edges; if the element has not been found among them; go search among the siblings
                val edgeFound = helper(e.adjacentEdges)
                if (edgeFound.isEmpty)  helper(Some(es))
                else edgeFound
              }
          }
      }

    if (first.data == data)   Some(first)
    else helper(first.adjacentEdges)
  }
}


object DirectedGraphTester {
  def main(args: Array[String]): Unit = {
    val n1 = new DirectedGraphNode(7, None)
    val n2 = new DirectedGraphNode(5, Some(List(n1)))
    val n3 = new DirectedGraphNode(3, Some(List(n1)))
    val n4 = new DirectedGraphNode(9, Some(List(n2, n3)))
    val n5 = new DirectedGraphNode(2, Some(List(n3, n4)))
    val graph = new DirectedGraph(n5)

    println(graph.findElement(5))
  }
}
