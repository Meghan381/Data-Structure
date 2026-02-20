
public class DoublyList {

	public DoublyList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBeginning(2);
		list.insertAtEnd(8);
		list.display();
		list.insertAtEnd(4);
		list.deleteFromBeginning();
		list.display();
	}

}
