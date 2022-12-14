package payment;

import java.util.Scanner;

public class QRpay implements Payment {

	@Override
	public boolean pay(double payableAmount) {
		 boolean payQRSuccess = false;
	       System.out.println("Paying With QR Selcted.");
	       boolean validValue = false;
	       do {
	    	   System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
	    	   Scanner proceedScan= new Scanner(System.in);
	    	   String  selectedOption = proceedScan.next();

	    	   if(selectedOption.trim().equals("1")) {
	    		   
	    		   try {
	    	    	   Scanner qrToken= new Scanner(System.in); 

	    	    	   
	    		       System.out.println("Enter QR Transaction Token:");
	    		       
	    	    	   String  QRNum = qrToken.nextLine();
	    	    	   
	    	    	   
	    	    	   if(!authQRpay(QRNum)) {
	    			       System.out.println("Autehtication Error Payemnt Failed");

	    	    	   }else {
	    	    		   payQRSuccess = true;
	    	    		   validValue = true;
	    	    		   
	    	    		   System.out.println("Payment Successful With QR Pay");	    		   
	    	    	   	}
	    	       		}catch(Exception e) {
	    	       		 System.out.println("Invalid Value Entered.");
	    	       		validValue = false;
	    	       	}
	    		   
	    	   }else if(selectedOption.trim().equals("2")) {
	    		   validValue = true;
	    		   payQRSuccess = false;
	    		   
	    	   }else {
	       		 System.out.println("Invalid Value Entered.");

	    	   }
	    	   
	       }while(validValue == false);
	
		 return payQRSuccess;		
	}
	
	 public boolean authQRpay(String transactionToken){ 
		 return true;
		
	 }

}
