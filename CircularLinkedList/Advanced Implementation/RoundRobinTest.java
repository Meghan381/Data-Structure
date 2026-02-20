
public class RoundRobinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        System.out.println("\n=== SIMPLE ROUND ROBIN SCHEDULER ===\n");

		      
		        RoundRobinScheduler scheduler = new RoundRobinScheduler();

		    
		        scheduler.addProcess(1, 10);
		        scheduler.addProcess(2, 5);
		        scheduler.addProcess(3, 8);
		        
		     
		        System.out.println("\nInitial Queue:");
		        scheduler.displayQueue();
		        
		       
		        scheduler.execute(3);
		        
		   
		        System.out.println("\nFinal Queue:");
		        scheduler.displayQueue();
		    }
		
	}


