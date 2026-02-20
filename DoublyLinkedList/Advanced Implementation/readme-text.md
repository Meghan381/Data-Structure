    
# Doubly -Linked List Browser History

A simple Java implementation of browser navigation history demonstrating a browser history system that allows users to:

Visit new web pages

Navigate backwards through history

Navigate forwards through history

View the current page

The implementation uses a doubly linked list where each node represents a web page and contains references to both previous and next pages.

## Project Structure
text
├── DNode.java              # Node class for doubly linked list
├── DoublyBrowserHistory.java # Browser history manager
└── DoublyTest.java         # Test class with main method
🔧 Classes
DNode.java
Represents a single page in the browser history:

String data - URL/page name

DNode prev - Reference to previous page

DNode next - Reference to next page

DoublyBrowserHistory.java
Manages the browser history operations:

visit(String data) - Add a new page to history

back() - Navigate to previous page

forward() - Navigate to next page

displayCurrentPage() - Show current page

## Example 
java
// Create browser with homepage
DoublyBrowserHistory browser = new DoublyBrowserHistory("google.com");

// Visit some pages
browser.visit("youtube.com");
browser.visit("github.com");

// Navigate
browser.back();        // Goes to youtube.com
browser.forward();     // Goes to github.com
browser.displayCurrentPage(); // Shows: github.com
## Sample Output
text
After visiting: Current Page: github.com

--- Going back ---
After back: Current Page: youtube.com
After back again: Current Page: google.com

--- Going forward ---
After forward: Current Page: youtube.com

--- Testing boundaries ---
No forward page.
No previous page.
No previous page.

--- Visiting new page after navigation ---
After back to ebay: Current Page: ebay.com
After visiting target.com: Current Page: target.com
No forward page.