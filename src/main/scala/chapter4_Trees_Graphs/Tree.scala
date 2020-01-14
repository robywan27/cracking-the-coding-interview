package chapter4_Trees_Graphs

// Implementation of A generic tree data structure.
class Tree[A](var root: TreeNode[A]) {

  def findElement(data: A): Option[TreeNode[A]] = {
    def helper(nodesOrLeaf: Option[List[TreeNode[A]]]): Option[TreeNode[A]] =
      nodesOrLeaf match {
        case None => None
        case Some(nodes) =>
          nodes match {
            case Nil => None
            case (first :: others) =>
              if (first.data == data)   Some(first)
              else {
                // search among the children; if the element has not been found among them; go search among the siblings
                val nodeFound = helper(first.children)
                if (nodeFound.isEmpty)  helper(Some(others))
                else nodeFound
              }
          }
      }

    if (root.data == data)  Some(root)
    else helper(root.children)
  }

}


object TreeTester {
  def main(args: Array[String]): Unit = {
    val l1 = new TreeNode('d', None)
    val l2 = new TreeNode('a', None)
    val ch = new TreeNode('f', Some(List(l2)))
    val r = new TreeNode('z', Some(List(l1, ch)))
    val simpleTree = new Tree(r)
    println(simpleTree.findElement('f').getOrElse("The data element was not found"))
    println(simpleTree.findElement('a').getOrElse("The data element was not found"))

    val firstLeaf = new TreeNode(7, None)
    val secondLeaf = new TreeNode(2, None)
    val thirdLeaf = new TreeNode(19, None)
    val fourthLeaf = new TreeNode(6, None)
    val fifthLeaf = new TreeNode(11, None)
    val sixthLeaf = new TreeNode(22, None)
    val firstChild = new TreeNode(5, Some(List(firstLeaf, secondLeaf, thirdLeaf)))
    val secondChild = new TreeNode(3, Some(List(fourthLeaf)))
    val fourthChild = new TreeNode(15, Some(List(sixthLeaf)))
    val thirdChild = new TreeNode(4, Some(List(fifthLeaf, fourthChild)))
    val rootNode = new TreeNode(10, Some(List(firstChild, secondChild, thirdChild, fourthChild)))
    val tree = new Tree(rootNode)

    println(tree.findElement(3).getOrElse("The data element was not found"))
    println(tree.findElement(11).getOrElse("The data element was not found"))
    println(tree.findElement(2).getOrElse("The data element was not found"))
  }
}
