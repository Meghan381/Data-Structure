
public class DoublyLinkedList {
DoublyNode head;

	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
		this.head= null;
	}

	void insertAtBeginning(int data) {
		DoublyNode newNode = new DoublyNode(data);
		if(head != null) {
			head.prev = newNode;
			
		}
		newNode.Next = head;
		head = newNode;
	}
	
	void insertAtEnd(int data) {
		DoublyNode newNode = new DoublyNode(data);
		if (head == null) {
			head = newNode;
			return;
		}
		DoublyNode temp = head;
		while(temp.Next != null) {
			temp = temp.Next;
		}
		temp.Next = newNode;
		newNode.prev = temp;
	}
	void deleteFromBeginning() {
		if(head == null) {
			return;
		}
		head = head.Next;
		if(head != null) {
			head.prev = null;
		}
	}
	void deleteFromEnd() {
			if(head == null) {
				return;
			}
			if (head.Next == null) {
				head =null;
				return;
			}
			DoublyNode temp = head;
			while(temp.Next != null) {
				temp = temp.Next;
			}
			temp.prev.Next = null;
	}
	Void display() {
		DoublyNode temp = head;
		while(temp != null) {
			System.out.print( temp.data + "-->");
			temp = temp.Next;
		}
		System.out.println("null");
		return null;}
	

		
	}


