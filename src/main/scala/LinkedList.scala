package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

sealed trait MyList[+A]

case class Node[+A](element: A, nextNode: MyList[A]) extends MyList[A]

case object EmptyNode extends MyList[Nothing]

class LinkedList[+A](private val list: MyList[A] = EmptyNode) {
  private val logger: Logger = Logger(getClass)

  def insertAtHead[B >: A](elementToInsert: B): LinkedList[B] = {
    new LinkedList[B](Node(elementToInsert, list))
  }

  def insertElementAtEnd[B >: A](elementToInsert: B): LinkedList[B] = {
    def insertionAtEnd(currentNode: MyList[A]): MyList[B] = {
      currentNode match {
        case EmptyNode => Node(elementToInsert, EmptyNode)
        case Node(element, EmptyNode) => Node(element, Node(elementToInsert, EmptyNode))
        case Node(element, nextNode) => Node(element, insertionAtEnd(nextNode))
      }
    }

    new LinkedList[B](insertionAtEnd(list))
  }

  def insertElementAtIndex[B >: A](elementToInsert: B, index: Int): LinkedList[B] = {
    def insertionAtIndex(currentNode: MyList[A], currentIndex: Int): MyList[B] = {
      currentNode match {
        case EmptyNode if currentIndex == 0 => Node(elementToInsert, EmptyNode)
        case Node(element, nextNode) => Node(element, insertionAtIndex(nextNode, currentIndex - 1))
        case EmptyNode => throw new Exception("Error occurred while insertion")
      }
    }

    new LinkedList[B](insertionAtIndex(list, index))
  }

  def search[B >: A](elementToBeSearched: B): Option[B] = {
    def searching(currentNode: MyList[A], currentIndex: Int): Option[B] = {
      currentNode match {
        case EmptyNode => None
        case Node(element, nextNode) => if (element == elementToBeSearched) {
          logger.info(s"$elementToBeSearched is present in the linked list")
          Some(elementToBeSearched)
        } else {
          searching(nextNode, currentIndex + 1)
        }
      }
    }

    searching(list, 0) match {
      case Some(element) => Some(element)
      case None => {
        logger.info(s"$elementToBeSearched not found")
        None
      }
    }
  }

  def traversal(): MyList[A] = {
    @tailrec
    def traversing(currentNode: MyList[A]): MyList[A] = {
      currentNode match {
        case EmptyNode => EmptyNode
        case Node(element, nextNode) =>
          logger.info(s"$element")
          traversing(nextNode)
      }
    }

    traversing(list)
    list
  }

  def deleteElement[B >: A](elementToDelete: B): LinkedList[B] = {
    def deleting(currentNode: MyList[A]): MyList[B] = {
      currentNode match {
        case EmptyNode => EmptyNode
        case Node(element, nextNode) =>
          if (element == elementToDelete) {
            logger.info(s"$elementToDelete is deleted.")
            nextNode
          } else Node(element, deleting(nextNode))
      }
    }

    new LinkedList[B](deleting(list))
  }
}
