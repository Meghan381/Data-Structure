
public class RoundRobinScheduler {
	    private ProcessNode head;
	    private ProcessNode current;

	    public RoundRobinScheduler() {
	        head = null;
	        current = null;
	    }

	   
	    public void addProcess(int processId, int burstTime) {
	        ProcessNode newNode = new ProcessNode(processId, burstTime);
	        
	        if (head == null) {
	            head = newNode;
	            head.next = head;
	            current = head;
	        } else {
	            ProcessNode temp = head;
	            while (temp.next != head) {
	                temp = temp.next;
	            }
	            temp.next = newNode;
	            newNode.next = head;
	        }
	        System.out.println("Added Process P" + processId + " (Burst: " + burstTime + ")");
	    }

	   
	    public void execute(int timeQuantum) {
	        if (head == null) {
	            System.out.println("No processes to execute!");
	            return;
	        }

	        System.out.println("\n=== Starting Round Robin (Quantum: " + timeQuantum + ") ===\n");
	        
	        int time = 0;
	        int completed = 0;
	        int totalProcesses = countProcesses();
	        
	        while (completed < totalProcesses) {
	            if (current.remainingTime > 0) {
	                int executeTime = Math.min(timeQuantum, current.remainingTime);
	                current.remainingTime -= executeTime;
	                time += executeTime;
	                
	                System.out.println("Time " + (time - executeTime) + "-" + time + 
	                                 ": P" + current.processId + " executed (" + executeTime + " units)");
	                
	                if (current.remainingTime == 0) {
	                    completed++;
	                    System.out.println("  P" + current.processId + " COMPLETED at time " + time);
	                    removeProcess(current.processId);
	                }
	            }
	            current = current.next;
	        }
	        
	        System.out.println("\n=== All processes completed at " + time + " ===");
	    }

	    // Remove completed process
	    private void removeProcess(int processId) {
	        if (head == null) return;
	        
	        ProcessNode temp = head;
	        ProcessNode prev = null;
	        
	        do {
	            if (temp.processId == processId) {
	                if (temp == head) {
	                    // Find last node
	                    ProcessNode last = head;
	                    while (last.next != head) {
	                        last = last.next;
	                    }
	                    head = head.next;
	                    last.next = head;
	                    if (current == temp) current = head;
	                } else {
	                    prev.next = temp.next;
	                    if (current == temp) current = temp.next;
	                }
	                return;
	            }
	            prev = temp;
	            temp = temp.next;
	        } while (temp != head);
	    }

	    
	    private int countProcesses() {
	        if (head == null) return 0;
	        int count = 0;
	        ProcessNode temp = head;
	        do {
	            count++;
	            temp = temp.next;
	        } while (temp != head);
	        return count;
	    }

	   
	    public void displayQueue() {
	        if (head == null) {
	            System.out.println("Queue is empty");
	            return;
	        }
	        
	        System.out.print("Current Queue: ");
	        ProcessNode temp = head;
	        do {
	            System.out.print("P" + temp.processId + "(" + temp.remainingTime + ") ");
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println();
	    }
	}

