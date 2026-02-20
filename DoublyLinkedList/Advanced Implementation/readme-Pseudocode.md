# Doubly Browser Pseudocode
BEGIN MAIN

CREATE browser WITH homepage "google.com"

CALL visit("youtube.com")
CALL visit("github.com")

PRINT "After visiting: "
CALL displayCurrentPage()

PRINT "--- Going back ---"
CALL back()
PRINT "After back: "
CALL displayCurrentPage()

CALL back()
PRINT "After back again: "
CALL displayCurrentPage()

PRINT "--- Going forward ---"
CALL forward()
PRINT "After forward: "
CALL displayCurrentPage()

PRINT "--- Testing boundaries ---"
CALL forward()
CALL back()
CALL back()
CALL back()

PRINT "--- new page after navigation ---"

CREATE browser WITH homepage "amazon.com"
CALL visit("ebay.com")
CALL visit("walmart.com")

CALL back()
PRINT "After back to ebay: "
CALL displayCurrentPage()

CALL visit("target.com")
PRINT "After visiting target.com: "
CALL displayCurrentPage()

CALL forward()

END MAIN
