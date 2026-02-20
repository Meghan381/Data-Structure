
# Round Robin Scheduler

This project implements a Round Robin CPU Scheduling Algorithm using a Circular Linked List in Java.

Each process is represented as a node containing:

processId

burstTime

remainingTime

The scheduler executes processes based on a fixed time quantum until all processes are completed.

## Concept Used

Circular Linked List

CPU Scheduling Algorithm

Round Robin Scheduling

Basic OOP (Classes & Objects)

## Project Structure

1️⃣ ProcessNode.java

Represents a single process in the circular linked list.

Attributes:

int processId

int burstTime

int remainingTime

ProcessNode next

2️⃣ RoundRobinScheduler.java

Handles:

Adding processes

Executing processes using Round Robin

Removing completed processes

Displaying the queue

Main Methods:

addProcess(int processId, int burstTime)

execute(int timeQuantum)

displayQueue()

3️⃣ RoundRobinTest.java

Contains the main() method to test the scheduler.

Example processes:

P1 → Burst Time: 10
P2 → Burst Time: 5
P3 → Burst Time: 8
Time Quantum: 3

## How It Works

Processes are added to a circular linked list.

The scheduler runs each process for the given time quantum.

If a process finishes, it is removed from the queue.

Execution continues until all processes complete.

## Sample Output
=== SIMPLE ROUND ROBIN SCHEDULER ===

Added Process P1 (Burst: 10)
Added Process P2 (Burst: 5)
Added Process P3 (Burst: 8)

Initial Queue:
P1(10) P2(5) P3(8)

=== Starting Round Robin (Quantum: 3) ===

Time 0-3: P1 executed (3 units)
Time 3-6: P2 executed (3 units)
Time 6-9: P3 executed (3 units)
=== All processes completed ===
