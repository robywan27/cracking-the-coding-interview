package chapter4_Trees_Graphs

object _3_SortedArrayToBinaryTree {
  /*def minimalHeightBinaryTree(arr: Array[Int]): Option[BinarySearchTree[Int]] = {
    def helper(arr: Array[Int]): Option[BinaryTreeNode[Int]] = {
      if (arr.length == 1)  {
        arr.foreach(e => print(s"$e "))
        println()
        Some(new BinaryTreeNode(arr(0)))
      }
      else {
        arr.foreach(e => print(s"$e "))
        println()
        val m = arr.length / 2
        val root = new BinaryTreeNode(arr(m))
        root.left = helper(arr.slice(0, m))
        root.right =
          if(arr.length == 2) helper(arr.slice(m, arr.length)) else  helper(arr.slice(m + 1, arr.length))
        Some(root)
      }
    }

    if (arr.isEmpty)    None
    else Some(new BinarySearchTree[Int](helper(arr).get, (x: Int) => (y: Int) => x < y))
  }*/

  def minimalHeightBinaryTree(arr: Array[Int]): Option[BinarySearchTree[Int]] = {
    def helper(arr: Array[Int], start: Int, end: Int): Option[BinaryTreeNode[Int]] = {
      if (end < start)
        None
      else {
        println(s"$start - $end")
        val m = (start + end) / 2
        val root = new BinaryTreeNode(arr(m))
        root.left = helper(arr, start, m - 1)
        root.right = helper(arr, m + 1, end)
        Some(root)
      }
    }

    if (arr.isEmpty)    None
    else Some(new BinarySearchTree[Int](helper(arr, 0, arr.length - 1).get, (x: Int) => (y: Int) => x < y))
  }


  def main(args: Array[String]): Unit = {
    minimalHeightBinaryTree(Array(1, 3, 7, 9, 12, 21, 37, 50, 61)) match {
      case None => println("No tree returned")
      case Some(t) => println(t.stringRepresentation)
    }
  }
}
