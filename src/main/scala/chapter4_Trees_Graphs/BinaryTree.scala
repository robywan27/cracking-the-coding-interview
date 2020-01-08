package chapter4_Trees_Graphs

class BinaryTree[A](var root: BinaryTreeNode[A]) {

}



object BinaryTreeTester {
  def main(args: Array[String]): Unit = {
    val lf1 = new BinaryTreeNode(5, None, None)
    val lf2 = new BinaryTreeNode(13, None, None)
    val lf3 = new BinaryTreeNode(1, None, None)
    val lf4 = new BinaryTreeNode(9, None, None)
    val firstLevelNode1 = new BinaryTreeNode(10, Some(lf1), Some(lf2))
    val firstLevelNode2 = new BinaryTreeNode(2, Some(lf3), Some(lf4))
    val root = new BinaryTreeNode(7, Some(firstLevelNode1), Some(firstLevelNode2))
    val bt = new BinaryTree(root)

    println()
    println()
  }
}
