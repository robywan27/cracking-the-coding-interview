package chapter4_Trees_Graphs

object _5_InOrderSuccessor {
  def inOrderSuccessor[A](node: BinaryTreeNodeWithParentLink[A]): Option[BinaryTreeNodeWithParentLink[A]] = {
    @scala.annotation.tailrec
    def leftmost(n: BinaryTreeNode[A]): BinaryTreeNode[A] = {
      if (n.left.isEmpty && n.right.isEmpty)  n
      else leftmost(n.left.get)
    }

    @scala.annotation.tailrec
    def findLeftChild(n: Option[BinaryTreeNodeWithParentLink[A]]): Option[BinaryTreeNodeWithParentLink[A]] = {
      if (n.get.parent.isEmpty)
        None
      else if (n.get.parent.get.left == n)
        n
      else
        findLeftChild(n.get.parent)
    }

    if (node.right.isDefined)
      Some(leftmost(node.right.get).asInstanceOf[BinaryTreeNodeWithParentLink[A]])
    else
      node.parent match {
        case None => None   // node is the root and does not have any right child -> there is no successor
        case Some(p) =>
          if (p.left.get == node)
            Some(p)
          else
            findLeftChild(Some(p.asInstanceOf[BinaryTreeNodeWithParentLink[A]]))
        }
  }


  def main(args: Array[String]): Unit = {

  }
}
