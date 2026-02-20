
#  CircularLinked -List Simple Implementation

This project implements a Circular Linked List using Java.

In a circular linked list:

The last node points back to the first node (head).

There is no null at the end.

Traversal continues in a circular manner.

##  How It Works

Each node contains:

data → Stores the value (String)

Next → Points to the next node

prev → (Declared but not used in this implementation)

The list maintains a head pointer to track the first node.

## Project Structure
1️⃣ CNode.java

Represents a node in the circular linked list.

public class CNode {
    String data;
    CNode Next;
    CNode prev;
    public CNode(String data) {
        this.data = data;
        this.Next = null;
        this.prev = null;
    }
}

2️⃣ CircularLinkedList.java

Contains the main list operations:

✅ Methods Implemented

insertAtBeginning(String data)

insertAtEnd(String data)

deleteFromBeginning()

display()

✔ insertAtBeginning()

Adds a new node at the start

Updates the last node to point to new head

✔ insertAtEnd()

Adds a node at the end

Ensures the last node points back to head

✔ deleteFromBeginning()

Removes the first node

Updates head and last node link

✔ display()

Traverses the list using do-while

Stops when it returns to head

3️⃣ CircularList.java (Main Class)

Used to test the circular linked list.

public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();
    list.insertAtBeginning("Hello");
    list.insertAtEnd("Welcome");
    list.display();
    list.insertAtEnd("to mypage");
    list.deleteFromBeginning();
    list.display();
}

## Sample Output
Hello-->Welcome-->Back to End
Welcome-->to mypage-->Back to End
