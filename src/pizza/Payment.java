package pizza;

import java.util.Scanner;

public class Payment {

	
	 public boolean payCash(double payableAmount) {
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
	 
	 
	 public boolean payCreditCard(double payableAmount) {
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
	 
	 
	 public boolean payQR(double payableAmount) {
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
	 
	 
	 public boolean  pay(double payableAmount){
		 boolean paymentSuccess = false;
		 
		 boolean isValidValue = false;
		 do {
			 System.out.println("1 Cash\n2 Credit Card\n3 QRpay\n4 Cancel Order\nPlease Enter the corresponding number to proceed:");
	    	  Scanner proceedScan= new Scanner(System.in);
	    	  String selectedOption = proceedScan.next();
			 if(selectedOption.trim().equals("1")) {
				 isValidValue = true;
				 paymentSuccess = payCash(payableAmount);
			 }else if(selectedOption.trim().equals("2")) {
				 isValidValue = true;
				 paymentSuccess = payCreditCard(payableAmount);
			 }else if(selectedOption.trim().equals("3")){
				 isValidValue = true;
				 paymentSuccess = payQR(payableAmount); 
			 }else if(selectedOption.trim().equals("4")){
				 isValidValue = true;
				 paymentSuccess = false;
			 }else {
	       		 System.out.println("Invalid Value Entered.");
	       		 isValidValue = false;
			 }
		}while(isValidValue == false);	 
		 return paymentSuccess;
	 }
	
	
	
	
}
