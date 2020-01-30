package chapter4_Trees_Graphs

import java.util

import scala.util.control.Breaks._

object _4_LinkedListForTreeLevelNodes {
  /*
    Functional approach.
   */
  def treeLevelsNodesToLinkedLists[A](bt: BinaryTree[A]): List[util.LinkedList[BinaryTreeNode[A]]] = {
    @scala.annotation.tailrec
    def treeLevelNodesToLinkedList(treeLevelsAsLists: List[util.LinkedList[BinaryTreeNode[A]]]): List[util.LinkedList[BinaryTreeNode[A]]] = {
      if (treeLevelsAsLists.head.isEmpty)  treeLevelsAsLists
      else {
        val linkedList = new util.LinkedList[BinaryTreeNode[A]]()
        treeLevelsAsLists.head.forEach(node => {
          if (node.left.isDefined)
            linkedList.add(node.left.get)
          if (node.right.isDefined)
            linkedList.add(node.right.get)
        })
        // prepend instead of append because of some error when doing: treeLevelsAsLists ++ [linkedList]
        treeLevelNodesToLinkedList(linkedList :: treeLevelsAsLists)
      }
    }

    val linkedList = new util.LinkedList[BinaryTreeNode[A]]()
    linkedList.add(bt.root)
    treeLevelNodesToLinkedList(linkedList :: List[util.LinkedList[BinaryTreeNode[A]]]())
  }


  /*
    Standard solution with mutation.
   */
  def treeLevelsNodesToLinkedLists2[A](bt: BinaryTree[A]): util.ArrayList[util.LinkedList[BinaryTreeNode[A]]] = {
    val treeLevelsAsLists = new util.ArrayList[util.LinkedList[BinaryTreeNode[A]]]()
    var level = 0
    val linkedList = new util.LinkedList[BinaryTreeNode[A]]()
    linkedList.add(bt.root)
    treeLevelsAsLists.add(linkedList)
    breakable(
      while (true) {
        val linkedList = new util.LinkedList[BinaryTreeNode[A]]()
        for (i <- 0 until treeLevelsAsLists.get(level).size()) {
          val node: BinaryTreeNode[A] = treeLevelsAsLists.get(level).get(i)
          if (node.left.isDefined)
            linkedList.add(node.left.get)
          if (node.right.isDefined)
            linkedList.add(node.right.get)
        }
        level += 1
        if (linkedList.size() > 0)
          treeLevelsAsLists.add(linkedList)
        else
          break
      }
    )
    treeLevelsAsLists
  }



  def main(args: Array[String]): Unit = {
    val lf1 = new BinaryTreeNode('v')
    val lf2 = new BinaryTreeNode('p')
    val lf3 = new BinaryTreeNode('g')
    val lf4 = new BinaryTreeNode('f')
    val firstLevelNode1 = new BinaryTreeNode('r', Some(lf1), Some(lf2))
    val firstLevelNode2 = new BinaryTreeNode('e', Some(lf3), Some(lf4))
    val root = new BinaryTreeNode('s', Some(firstLevelNode1), Some(firstLevelNode2))
    val bt = new BinaryTree(root)

    // the lists are printed starting with leaves down to root
    treeLevelsNodesToLinkedLists(bt).foreach(l => {
      l.forEach(e => print(s"${e.data} "))
      println()})

    val lists = treeLevelsNodesToLinkedLists2(bt)
    lists.forEach(l => {
      l.forEach(e => print(s"${e.data} "))
      println()}
    )
  }
}
