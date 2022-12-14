package payment;

import java.time.LocalDate;
import java.util.Scanner;

import order.Order;

public interface Payment {

	
	public boolean pay(double payableAmount);
	
	
	public static double calculateTotal(Order order) {//
		double payableAmount = 0;
	
	
	
	for(int i = 0; i< order.pizzas.size(); i++ ) {
		
		payableAmount = payableAmount + order.pizzas.get(i).totalPrice;
		
	}
	
	payableAmount = order.calTotalWithTax(payableAmount);

	
	return payableAmount;
}


	
public static void payOrder(Order order) {//
		
		if(paySelect(order.total) == true) {
			   order.orderID = String.valueOf(Math.random());
    		   order.orderDate = LocalDate.now().toString();
    		   order.total = calculateTotal(order);
			System.out.println("Payment of "+ order.total + " was Successful.");
			order.genReceipt(order);
		}else {
			System.out.println("Payment of "+ order.total + " was not Successful.");
		}
		 
	}
	
	
	public static boolean paySelect(double payableAmount) {
	    boolean paymentSuccess = false;

	    while (true) {
	        System.out.println("1 Cash\n2 Credit Card\n3 QRpay\n4 Cancel Order\nPlease Enter the corresponding number to proceed:");
	        Scanner proceedScan = new Scanner(System.in);
	        String selectedOption = proceedScan.next();

	        if (selectedOption.trim().equals("1")) {
	            paymentSuccess = new Cash().pay(payableAmount);
	            break;
	        } else if (selectedOption.trim().equals("2")) {
	            paymentSuccess = new CreditCard().pay(payableAmount);
	            break;
	        } else if (selectedOption.trim().equals("3")) {
	            paymentSuccess = new QRpay().pay(payableAmount);
	            break;
	        } else if (selectedOption.trim().equals("4")) {
	            paymentSuccess = false;
	            break;
	        } else {
	            System.out.println("Invalid Value Entered.");
	        }
	    }

	    return paymentSuccess;
	}
	
	
}
