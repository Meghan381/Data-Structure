public class DoublyTest {
    public static void main(String[] args) {
        
        DoublyBrowserHistory browser = new DoublyBrowserHistory("google.com");

       
        browser.visit("youtube.com");
        browser.visit("github.com");

       
        System.out.print("After visiting: ");
        browser.displayCurrentPage(); // github

        // Test back navigation
        System.out.println("\n--- Going back ---");
        browser.back();
        System.out.print("After back: ");
        browser.displayCurrentPage(); // youtube

        browser.back();
        System.out.print("After back again: ");
        browser.displayCurrentPage(); // google

        // Test forward navigation
        System.out.println("\n--- Going forward ---");
        browser.forward();
        System.out.print("After forward: ");
        browser.displayCurrentPage(); // youtube

        // Test boundary conditions
        System.out.println("\n--- Testing boundaries ---");
        browser.forward(); 
        browser.back();
        browser.back();
        browser.back(); 

        
        System.out.println("\n--- new page after navigation ---");
        
        browser = new DoublyBrowserHistory("amazon.com");
        browser.visit("ebay.com");
        browser.visit("walmart.com");
        
        browser.back();
        System.out.print("After back to ebay: ");
        browser.displayCurrentPage();
        
        browser.visit("target.com"); 
        System.out.print("After visiting target.com: ");
        browser.displayCurrentPage();
        
        browser.forward(); 
    }
}
