# Circular Linked List Pseudocode
```
BEGIN MAIN
    CREATE CircularLinkedList
    SET head = NULL
    // Insert "Hello" at beginning
    CREATE newNode with data = "Hello"
    IF head IS NULL THEN
        SET newNode.next = newNode
        SET head = newNode
    ELSE
        SET temp = head
        WHILE temp.next ≠ head DO
            MOVE temp TO temp.next
        END WHILE
        SET temp.next = newNode
        SET newNode.next = head
        SET head = newNode
    END IF
    // Insert "Welcome" at end
    CREATE newNode with data = "Welcome"
    IF head IS NULL THEN
        SET newNode.next = newNode
        SET head = newNode
    ELSE
        SET temp = head
        WHILE temp.next ≠ head DO
            MOVE temp TO temp.next
        END WHILE
        SET temp.next = newNode
        SET newNode.next = head
    END IF
    // Display list
    IF head IS NOT NULL THEN
        SET temp = head
        DO
            PRINT temp.data + "-->"
            MOVE temp TO temp.next
        WHILE temp ≠ head
        PRINT "Back to End"
    END IF
    // Insert "to mypage" at end
    CREATE newNode with data = "to mypage"
    SET temp = head
    WHILE temp.next ≠ head DO
        MOVE temp TO temp.next
    END WHILE
    SET temp.next = newNode
    SET newNode.next = head
    // Delete from beginning
    IF head IS NULL THEN
        STOP
    ELSE IF head.next = head THEN
        SET head = NULL
    ELSE
        SET temp = head
        WHILE temp.next ≠ head DO
            MOVE temp TO temp.next
        END WHILE
        SET temp.next = head.next
        SET head = head.next
    END IF
    // Display list again
    IF head IS NOT NULL THEN
        SET temp = head
        DO
            PRINT temp.data + "-->"
            MOVE temp TO temp.next
        WHILE temp ≠ head
        PRINT "Back to End"
    END IF

END MAIN
```
