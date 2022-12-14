package payment;

import java.util.Scanner;

public class CreditCard implements Payment{

	@Override
	public boolean pay(double payableAmount) {
		// TODO Auto-generated method stub
		 boolean payCreditCardSuccess = false;
	       System.out.println("Paying With CreditCard Selcted.");
	       boolean validValue = false;
	       do {
	    	   System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
	    	   Scanner proceedScan= new Scanner(System.in);
	    	   String  selectedOption = proceedScan.next();

	    	   if(selectedOption.trim().equals("1")) {
	    		   
	    		   try {
	    	    	   Scanner scanCardNum= new Scanner(System.in); 
	    	    	   Scanner scanCardPin= new Scanner(System.in); 

	    	    	   
	    		       System.out.println("Enter Credit Card Number(213XXXXX):");
	    		       
	    	    	   int  creditCardNum = scanCardNum.nextInt();
	    	    	   
	    	    	   System.out.println("Enter 6-digt pin:");
	    		       
	    	    	   int  creditCardPin = scanCardPin.nextInt();
	    	    	   
	    	    	   if(!authCreditCard(creditCardNum, creditCardPin )) {
	    			       System.out.println("Autehtication Error Payemnt Failed");

	    	    	   }else {
	    	    		   payCreditCardSuccess = true;
	    	    		   validValue = true;
	    	    		   
	    	    		   System.out.println("Payment Successful With Credit Card");	    		   
	    	    	   	}
	    	    	   
	    	       		}catch(Exception e) {
	    	       		 System.out.println("Invalid Value Entered.");
	    	       		validValue = false;
	    	       	}
	    		   
	    	   }else if(selectedOption.trim().equals("2")) {
	    		   validValue = true;
	    		   payCreditCardSuccess = false;
	    		   
	    	   }else {
	       		 System.out.println("Invalid Value Entered.");

	    	   }
	       }while(validValue == false);
	
		 return payCreditCardSuccess;
	}
	
	 public boolean authCreditCard(int CardNumber, int Pin ){ 
		 return true;
		
	 }
	
	

}
