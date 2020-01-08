package chapter4_Trees_Graphs

import chapter2_Linked_Lists.Node

class BinaryTreeNode[A](data: A,
                        var left: Option[BinaryTreeNode[A]] = None,
                        var right: Option[BinaryTreeNode[A]] = None) extends Node(data) {

}
