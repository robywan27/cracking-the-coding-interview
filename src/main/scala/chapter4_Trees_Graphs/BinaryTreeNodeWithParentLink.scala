package chapter4_Trees_Graphs

class BinaryTreeNodeWithParentLink[A](data: A,
                                      left: Option[BinaryTreeNodeWithParentLink[A]] = None,
                                      right: Option[BinaryTreeNodeWithParentLink[A]] = None,
                                      var parent: Option[BinaryTreeNodeWithParentLink[A]] = None) extends BinaryTreeNode(data) {

}
