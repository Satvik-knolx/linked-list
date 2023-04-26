
# Linked-List
This project is an implementation of a linked list data structure in Scala. It provides basic functionality such as inserting elements, deleting elements, searching elements and traversing the list.

# Requirements
    Scala

    sbt

# How to Use
To use the linked list, import the LinkedList class from the com.knoldus package. You can create an empty list with val list = new LinkedList[T]() where T is the type of elements you want to store in the list.

## Inserting Elements
To insert an element at the head of the list, use the insertAtHead(element: T): LinkedList[T] method. This returns a new linked list with the given element at the head.

To insert an element at the end of the list, use the insertElementAtEnd(element: T): LinkedList[T] method. This returns a new linked list with the given element at the end.

To insert an element at a specific index, use the insertElementAtIndex(element: T, index: Int): LinkedList[T] method. This returns a new linked list with the given element inserted at the specified index.

## Deleting Elements
To delete an element from the list, use the deleteElement(element: T): LinkedList[T] method. This returns a new linked list with the given element removed.

## Traversing the List
To traverse the list and print its elements, use the traversal(): Node[T] method. This returns the head node of the linked list.

## Searching Elements
To search for elements in the linked list, you can use the following method:
search(elementToBeSearched: B): Option[B]: Searches for an element in the linked list and returns an option containing the element if it is found, or None if it is not found.


# How to run the project

### Clone the project from the repository.

    https://github.com/Satvik-knolx/linked-list.git
### Navigate to the project directory.

    cd linked-list
### Run the following command to build the project.

    sbt clean compile


### To run the test cases, run the following command:

    sbt "test"

# Conclusion
This project provides a password strength checker implementation in Scala using the TDD approach. It also includes additional functionalities and validation for user, company, and email. Proper logging and error handling have been implemented, and consistent code formatting has been ensured using ScalaStyle.