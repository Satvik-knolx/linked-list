package com.knoldus

import org.scalatest.funsuite.AnyFunSuite

class LinkedListTest extends AnyFunSuite {
  private val linkedListObj = new LinkedList

  test("traversing an empty linked list should return Nothing") {
    assert(linkedListObj.traversal() == EmptyNode)
  }

  val listOne: LinkedList[Int] = linkedListObj.insertAtHead(1)
  val listTwo: LinkedList[Int] = listOne.insertElementAtEnd(2)
  val listThree: LinkedList[Int] = listTwo.insertElementAtIndex(3, 2)
  val listFour: LinkedList[Int] = listThree.insertElementAtIndex(4, 3)
  val listFive: LinkedList[Int] = listFour.insertElementAtIndex(5, 4)

  test("inserting elements should return a linked list with elements") {
    assert(listFive.traversal() == Node(1, Node(2, Node(3, Node(4, Node(5, EmptyNode))))))
  }


  test("deleting element should return a linked list without the deleted element") {
    val listSix: LinkedList[Int] = listFive.deleteElement(3)
    assert(listSix.traversal() == Node(1, Node(2, Node(4, Node(5, EmptyNode)))))
  }

  test("searching an element present in the linked list should return the element") {
    assert(listFive.search(4).contains(4))
  }

  test("searching an element not present in the linked list should return None")  {
    assert(listFive.search(7).isEmpty)
  }
}
