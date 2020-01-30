package chapter4_Trees_Graphs

import java.util

object _6_FindFirstCommonAncestor {
  /*
    Solution for trees with nodes having parent pointer.
   */
  def findFirstCommonAncestor[A](n: BinaryTreeNodeWithParentLink[A], n2: BinaryTreeNodeWithParentLink[A]): Option[BinaryTreeNodeWithParentLink[A]] = {
    val nodesInNodePath = new util.ArrayList[BinaryTreeNodeWithParentLink[A]]()
    val nodesInNode2Path = new util.ArrayList[BinaryTreeNodeWithParentLink[A]]()

    @scala.annotation.tailrec
    def helper(n: BinaryTreeNodeWithParentLink[A], n2: BinaryTreeNodeWithParentLink[A]): Unit = {
      if (n.parent.isEmpty && n2.parent.isEmpty)  ()
      else {
        nodesInNodePath.add(n)
        nodesInNode2Path.add(n2)
        helper(n.parent.get, n2.parent.get)
      }
    }

    helper(n, n2)
    for (i <- 0 until nodesInNodePath.size())
      for (j <- 0 until nodesInNode2Path.size())
        if (nodesInNodePath.get(i) == nodesInNode2Path.get(j))
          return Some(nodesInNodePath.get(i))
    None
  }


}
