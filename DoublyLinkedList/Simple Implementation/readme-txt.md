# Doubly Linked List in Java
This project implements a simple Doubly Linked List in Java.
A doubly linked list is a linear data structure where:

Each node contains data

A reference to the next node

A reference to the previous node

This allows traversal in both forward and backward directions.

## Classes Included
1️⃣ DoublyNode

Represents a node in the list.

Attributes:

int data

DoublyNode Next

DoublyNode prev

2️⃣ DoublyLinkedList

Implements the operations of the doubly linked list.

Attributes:

DoublyNode head

## Methods:
insertAtBeginning(int data) → Inserts a node at the start

insertAtEnd(int data) → Inserts a node at the end

deleteFromBeginning() → Deletes the first node

deleteFromEnd() → Deletes the last node

display() → Displays the list elements

3️⃣ DoublyList (Main Class)

Contains the main() method to test the list operations.

## Operations Demonstrated in Main
DoublyLinkedList list = new DoublyLinkedList();

list.insertAtBeginning(2);
list.insertAtEnd(8);
list.display();

list.insertAtEnd(4);
list.deleteFromBeginning();
list.display();

## Sample Output
2–>8–>null
8–>4–>null

img(<img width="544" height="445" alt="DoublySimple" src="https://github.com/user-attachments/assets/3f413e6f-8eb8-4328-a3cc-3c93f3193b11" />

