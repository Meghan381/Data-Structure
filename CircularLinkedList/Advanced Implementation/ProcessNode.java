
public class ProcessNode {

	    int processId;
	    int burstTime;
	    int remainingTime;
	    ProcessNode next;

	    public ProcessNode(int processId, int burstTime) {
	        this.processId = processId;
	        this.burstTime = burstTime;
	        this.remainingTime = burstTime;
	        this.next = null;
	    }
	}

