package chapter4_Trees_Graphs

object _1_BalancedTree {
  def isTreeBalanced[A](tree: BinaryTree[A]): Boolean = {
    def maxDepth(node: Option[BinaryTreeNode[A]]): Int = {
      if (node.isEmpty)  0
      else 1 + Math.max(maxDepth(node.get.left), maxDepth((node.get.right)))
    }

    def minDepth(node: Option[BinaryTreeNode[A]]): Int = {
      if (node.isEmpty)  0
      else 1 + Math.min(minDepth(node.get.left), minDepth((node.get.right)))
    }

    maxDepth(Some(tree.root)) - minDepth(Some(tree.root)) <= 1
  }


  def main(args: Array[String]): Unit = {
    val lf1 = new BinaryTreeNode(5)
    val lf2 = new BinaryTreeNode(13)
    val lf3 = new BinaryTreeNode(2)
    val firstLevelNode1 = new BinaryTreeNode(10, Some(lf1), Some(lf2))
    val root = new BinaryTreeNode(7, Some(firstLevelNode1), Some(lf3))
    val bt = new BinaryTree(root)

    println(isTreeBalanced(bt))                            // true

    val l1 = new BinaryTreeNode(8)
    val l2 = new BinaryTreeNode(3)
    val l3 = new BinaryTreeNode(13)
    val l4 = new BinaryTreeNode(2)
    val sln1 = new BinaryTreeNode(5, Some(l1), Some(l2))
    val fln1 = new BinaryTreeNode(10, Some(sln1), Some(l3))
    val root2 = new BinaryTreeNode(7, Some(fln1), Some(l4))
    val bt2 = new BinaryTree(root2)

    println(isTreeBalanced(bt2))                            // false
  }
}
