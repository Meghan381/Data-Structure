
public class CircularList {

	public CircularList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList list = new CircularLinkedList();
		list.insertAtBeginning("Hello");
		list.insertAtEnd("Welcome");
		list.display();
		list.insertAtEnd("to mypage");
		list.deleteFromBeginning();
		list.display();

	}

}
