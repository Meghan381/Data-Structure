public class DoublyBrowserHistory {
    DNode current;

    public DoublyBrowserHistory(String homepage) {
        current = new DNode(homepage);
    }

    // Visit new page
    public void visit(String data) {
        DNode newPage = new DNode(data);
        current.next = newPage;
        newPage.prev = current;
        current = newPage;
    }

    // Go back
    public void back() {
        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No previous page.");
        }
    }

    // Go forward
    public void forward() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("No forward page.");
        }
    }

    public void displayCurrentPage() {
        System.out.println("Current Page: " + current.data);
    }
}
