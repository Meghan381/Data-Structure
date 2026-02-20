 # Round Robin Scheduler Pseudocode
BEGIN MAIN
   PRINT "=== SIMPLE ROUND ROBIN SCHEDULER ==="
    CREATE RoundRobinScheduler
    SET head = NULL
    SET current = NULL
    // Add processes
    ADD Process P1 with BurstTime = 10
    ADD Process P2 with BurstTime = 5
    ADD Process P3 with BurstTime = 8
    PRINT "Initial Queue:"
    DISPLAY all processes in circular queue
    // Execute with Time Quantum = 3
    SET timeQuantum = 3
    SET time = 0
    WHILE there are unfinished processes DO
        IF current.remainingTime > 0 THEN
            SET executeTime = MIN(timeQuantum, current.remainingTime)
            SUBTRACT executeTime from current.remainingTime
            ADD executeTime to time
            PRINT "Process P" + current.processId + 
                  " executed for " + executeTime + " units"
            IF current.remainingTime = 0 THEN
                PRINT "Process P" + current.processId + 
                      " completed at time " + time
                REMOVE process from circular queue
            END IF
        END IF
        MOVE current to current.next
    END WHILE
    PRINT "All processes completed at time " + time
    PRINT "Final Queue:"
    DISPLAY queue (should be empty)
END MAIN