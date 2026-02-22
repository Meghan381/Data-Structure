 # Doubly Linked List Pseudocode
 ```
BEGIN MAIN
    CREATE DoublyLinkedList
    SET head = NULL
    CREATE newNode with data = 2
    IF head IS NOT NULL THEN
        SET head.prev = newNode
    END IF
    SET newNode.next = head
    SET head = newNode
    CREATE newNode with data = 8
    IF head IS NULL THEN
        SET head = newNode
    ELSE
        SET temp = head
        WHILE temp.next IS NOT NULL DO
            MOVE temp TO temp.next
        END WHILE
        SET temp.next = newNode
        SET newNode.prev = temp
    END IF
    SET temp = head
    WHILE temp IS NOT NULL DO
        PRINT temp.data + "-->"
        MOVE temp TO temp.next
    END WHILE
    PRINT "null"
    CREATE newNode with data = 4
    SET temp = head
    WHILE temp.next IS NOT NULL DO
        MOVE temp TO temp.next
    END WHILE
    SET temp.next = newNode
    SET newNode.prev = temp
    IF head IS NOT NULL THEN
        SET head = head.next
        IF head IS NOT NULL THEN
            SET head.prev = NULL
        END IF
    END IF
    SET temp = head
    WHILE temp IS NOT NULL DO
        PRINT temp.data + "-->"
        MOVE temp TO temp.next
    END WHILE
    PRINT "null"
END MAIN
```
