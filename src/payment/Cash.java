package payment;

import java.util.Scanner;

public class Cash implements Payment{

	@Override
	public boolean pay(double payableAmount) {
		// TODO Auto-generated method stub
		 boolean payCashSuccess = false;
	       System.out.println("Paying With Cash Selcted.");
	       boolean validValue = false;
	       do {
	    	   System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
	    	   Scanner proceedScan= new Scanner(System.in);
	    	   String  selectedOption = proceedScan.next();

	    	   if(selectedOption.trim().equals("1")) {
	    		   
	    		   try {
	    	    	   Scanner scan= new Scanner(System.in); 
	    	    	   
	    		       System.out.println("Enter the amount of cash recived:");
	    		       
	    	    	   double  amountRec = scan.nextDouble();
	    	    	   
	    	    	   if(amountRec < payableAmount) {
	    			       System.out.println("Insuffiecnt Amount Enter Again.");

	    	    	   }else {
	    	    		   payCashSuccess = true;
	    	    		   validValue = true;
	    	    		   
	    	    		   System.out.println("Customers Balance(RM):" + (amountRec - payableAmount));	    		   
	    	    	   }
	    	    	   
	    	       		}catch(Exception e) {
	    	       		 System.out.println("Invalid Value Entered.");
	    	       		validValue = false;
	    	       	}
	    		   
	    	   }else if(selectedOption.trim().equals("2")) {
	    		   validValue = true;
	    		   payCashSuccess = false;
	    		   
	    	   }else {
	       		 System.out.println("Invalid Value Entered.");
	    	   }
	    	   
	    	   
	       }while(validValue == false);
	
		 return payCashSuccess;
	}
	
	

}
