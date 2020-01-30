package chapter4_Trees_Graphs

class BinaryTree[A](var root: BinaryTreeNode[A]) {
  // Prints elements on one line separated by spaces.
  // First element printed is the root, followed by first left child, ... left leaf, right leaf, ...
  def stringRepresentation: String = {
    var string = ""

    def helper(node: BinaryTreeNode[A]): Unit =
      if (node.left.isEmpty && node.right.isEmpty)
        string = string + " " + node.data
      else {
        string = string + " " + node.data
        if (node.left.isDefined) helper(node.left.get)
        if (node.right.isDefined) helper(node.right.get)
      }

    helper(root)
    string
  }
}



object BinaryTreeTester {
  def main(args: Array[String]): Unit = {
    val lf1 = new BinaryTreeNode(5)
    val lf2 = new BinaryTreeNode(13)
    val lf3 = new BinaryTreeNode(1)
    val lf4 = new BinaryTreeNode(9)
    val firstLevelNode1 = new BinaryTreeNode(10, Some(lf1), Some(lf2))
    val firstLevelNode2 = new BinaryTreeNode(2, Some(lf3), Some(lf4))
    val root = new BinaryTreeNode(7, Some(firstLevelNode1), Some(firstLevelNode2))
    val bt = new BinaryTree(root)
    println(bt.stringRepresentation)
  }
}
