package chapter4_Trees_Graphs

class BinarySearchTree[A](root: BinaryTreeNode[A], precedes: A => A => Boolean) extends BinaryTree[A](root) {
  def find(data: A): Option[BinaryTreeNode[A]] = {
    @scala.annotation.tailrec
    def helper(node: Option[BinaryTreeNode[A]]): Option[BinaryTreeNode[A]] =
      if (node.isEmpty)   None
      else
        if (node.get.data == data)    node
        else if (precedes(data)(node.get.data))   helper(node.get.left)
        else helper(node.get.right)

    helper(Some(root))
  }


  def insert(data: A): Unit = {
    var curr = root
    while (curr.left.isDefined && curr.right.isDefined)
      if (precedes(data)(curr.data)) curr = curr.left.get
      else curr = curr.right.get

    if (precedes(data)(curr.data)) curr.left = Some(new BinaryTreeNode[A](data, None, None))
    else curr.right = Some(new BinaryTreeNode[A](data, None, None))
  }


}



object BinarySearchTreeTester {
  def main(args: Array[String]): Unit = {
    val lf1 = new BinaryTreeNode(2)
    val lf2 = new BinaryTreeNode(7)
    val lf3 = new BinaryTreeNode(13)
    val lf4 = new BinaryTreeNode(22)
    val firstLevelNode1 = new BinaryTreeNode(5, Some(lf1), Some(lf2))
    val firstLevelNode2 = new BinaryTreeNode(20, Some(lf3), Some(lf4))
    val root = new BinaryTreeNode(10, Some(firstLevelNode1), Some(firstLevelNode2))
    val bst = new BinarySearchTree(root, (x: Int) => (y: Int) => x < y)

    println(bst.find(13).getOrElse("The data element was not found"))
    println(bst.find(15).getOrElse("The data element was not found"))

    bst.insert(8)
    println(bst.find(8))
    println(bst.find(7).get.right)
    println(bst.find(7).get.left)
  }
}
