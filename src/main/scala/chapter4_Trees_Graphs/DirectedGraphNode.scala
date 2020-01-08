package chapter4_Trees_Graphs

import chapter2_Linked_Lists.Node

class DirectedGraphNode[A](data: A, var adjacentEdges: Option[List[DirectedGraphNode[A]]] = None) extends Node(data) {

}
