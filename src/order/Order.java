package order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import payment.Cash;
import payment.CreditCard;
import payment.QRpay;

import pizza.Pizza;
import pizza.SizeSmall;

public class Order {

	ArrayList<Pizza> pizzas  = new ArrayList<Pizza>(); 
	String orderID;
	double total;
	String orderDate;
	
	
	public double calTotalWithTax(double amount) { //
		System.out.println("6% Tax Applied to total");
		return amount*106/100;
	}
	
	
	public ArrayList<Pizza> addPizza(ArrayList<Pizza>  currentPizzas){//
		
		Pizza p = new SizeSmall();
		
		currentPizzas.add(p.createPizza());
		
		return currentPizzas;
		
	}
	
	public void showPizzaOrder(ArrayList<Pizza>  currentPizzas) {//
	
		if(!currentPizzas.isEmpty()) {
			
			for(int i = 0; i< currentPizzas.size(); i++ ) {
				System.out.println("Created Pizzas");
				System.out.println("-----------------------");
				System.out.println("Pizza Index: " +i);
				System.out.println("Pizza Size: " + currentPizzas.get(i).size);
				System.out.println("Pizza Toppings: " + currentPizzas.get(i).toppings.toString().replace("[", "").replace("]", "") );
				System.out.println("Pizza Price: " + currentPizzas.get(i).totalPrice);
			
			}
		}else {
			System.out.println("No Pizzas Have Been Made");
		}
		
	}
	
	public ArrayList<Pizza> rmvPizza(ArrayList<Pizza>  currentPizzas){ //
		
		if(!currentPizzas.isEmpty()) {
		showPizzaOrder(currentPizzas);
	
		
		  boolean validValue = false;
	       do {
				System.out.println("Enter Pizza Index To Remove Pizza or Enter -1 to Cancel: ");
	    	   Scanner proceedScan= new Scanner(System.in);
	    	   int  selectedOption = proceedScan.nextInt();

	    	   try {
	    	   if(selectedOption < currentPizzas.size()) {
	    		   currentPizzas.remove(selectedOption);
	    		   validValue = true;

	    	   }else if(selectedOption == -1 ) {
	    		   validValue = true;
	    	   }else{
	    		   System.out.println("Invalid Selection");
	    		   validValue = false;
	    	   }   
	    		   
		    		  
		    	    	  
	    	   }catch(Exception e) {
    	       		 System.out.println("Invalid Value Entered.");
    	       		validValue = false;
    	       	}
    		   
	       }while(validValue == false);
		
		}else {
			System.out.println("No Pizzas Have Been Made");
		}
		return currentPizzas;
		
	}
	
	public double calculateTotal(Order order) {//
			double payableAmount = 0;
		
		
		
		for(int i = 0; i< order.pizzas.size(); i++ ) {
			
			payableAmount = payableAmount + order.pizzas.get(i).totalPrice;
			
		}
		
		payableAmount = calTotalWithTax(payableAmount);

		
		return payableAmount;
	}
	
	public void genReceipt(Order order) {//
		System.out.println("------------------------");
		System.out.println("-----Receipt------");
		System.out.println("-----OrderId------");
		System.out.println(order.orderID);
		System.out.println("-----Order Date------");
		System.out.println(order.orderDate);
		System.out.println("-----Ordered Pizzas------");
		showPizzaOrder(order.pizzas);
		System.out.println("-----Total After 6% Tax------");
		System.out.println(order.total);
		System.out.println("------------------------");
	}
	
	
	
	
	public void orderPizza(Order order){//
		
		  boolean sizeIsValid = false; 
		   do {
			   System.out.println("-----------------------");
	    	   System.out.println("1 AddOrder\n2 ViewOrder\n3 Remove Pizza From Order\n4 Pay For Ordern\n5 Cancel Order\nPlease Enter the corresponding number to proceed:");
	    	   Scanner selectionScan= new Scanner(System.in);
	    	   String  sizeIndex = selectionScan.next();
	    	   
	    	   if(sizeIndex.trim().equals("1")) {
	    		   order.pizzas =  addPizza(order.pizzas);
	    		   
	    	   }else if(sizeIndex.trim().equals("2")) {
	    		   showPizzaOrder(order.pizzas);
	    	   }else if(sizeIndex.trim().equals("3")) {
	    		   order.pizzas = rmvPizza(order.pizzas);
	    	   }else if(sizeIndex.trim().equals("4")){
	    		   if(!order.pizzas.isEmpty()) {
	    			   order.orderID = String.valueOf(Math.random());
		    		   order.orderDate = LocalDate.now().toString();
		    		   order.total = calculateTotal(order);
		    		   payOrder(order);
		    		   sizeIsValid = true;
		    		   System.out.println("Order Ended");
	    		   }else {
	    			   System.out.println("No Pizzas Added");
	    		   }
	    		   
	    	   }else if(sizeIndex.trim().equals("5")){
	    		   order = null;
	    		   sizeIsValid = true;
	    		   System.out.println("Order Canceled.");
	    	   }else {
	    		   sizeIsValid = false;
	    		   System.out.println("Invalid Input. Please Try Again.");
	    	   }
		   
		   }while(sizeIsValid == false);
		
		
	}
	
	
	public void payOrder(Order order) {//
		
		if(paySelect(order.total) == true) {
			System.out.println("Payment of "+ order.total + " was Successful.");
			genReceipt(order);
		}else {
			System.out.println("Payment of "+ order.total + " was not Successful.");
		}
		 
	}
	
	
	 public  boolean  paySelect(double payableAmount){
		 boolean paymentSuccess = false;
		 
		 boolean isValidValue = false;
		 do {
			 System.out.println("1 Cash\n2 Credit Card\n3 QRpay\n4 Cancel Order\nPlease Enter the corresponding number to proceed:");
	    	  Scanner proceedScan= new Scanner(System.in);
	    	  String selectedOption = proceedScan.next();
			 if(selectedOption.trim().equals("1")) {
				 Cash pay = new Cash();
				 paymentSuccess = pay.pay(payableAmount);
				 isValidValue = true;
				
			 }else if(selectedOption.trim().equals("2")) {
				 CreditCard pay = new CreditCard();
				 paymentSuccess = pay.pay(payableAmount);
				 isValidValue = true;
				 
			 }else if(selectedOption.trim().equals("3")){
				 QRpay pay = new QRpay();
				 paymentSuccess = pay.pay(payableAmount);
				 isValidValue = true;
				 
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
