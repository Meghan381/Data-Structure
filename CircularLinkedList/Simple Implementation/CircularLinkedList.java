
public class CircularLinkedList {
CNode head;
	public CircularLinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}
void insertAtBeginning(String data) {
	CNode newNode = new CNode(data);
	if(head == null) {
		newNode.Next= newNode;
		head = newNode;
		return;
	}
	CNode temp = head;
	while(temp.Next != head) {
		temp = temp.Next;
	}
	temp.Next = newNode;
	newNode.Next =head;
	head = newNode;
}
void insertAtEnd(String data) {
	CNode newNode = new CNode(data);
	if( head == null) {
		newNode.Next = newNode;
		head = newNode;
		return;
	}
	CNode temp = head;
	while(temp.Next != head) {
		temp = temp.Next;
	}
	temp.Next = newNode;
	newNode.Next = head;
}
void deleteFromBeginning() {
	if(head == null) {
		return;
	}
	if(head.Next == head) {
		head= null;
		return;
	}
	CNode temp = head;
	while (temp.Next != head) {
		temp= temp.Next;
	}
	temp.Next = head.Next;
	head = head.Next;
}
void display() {
	if(head == null)return;
	CNode temp = head;
	do {
		System.out.print(temp.data + "-->");
		temp= temp.Next;
	}
	while(temp != head);
	System.out.println("Back to End");
}
}
