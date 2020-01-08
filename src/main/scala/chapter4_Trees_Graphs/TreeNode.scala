package chapter4_Trees_Graphs

import chapter2_Linked_Lists.Node

class TreeNode[A](data: A, var children: Option[List[TreeNode[A]]] = None) extends Node(data) {

}
