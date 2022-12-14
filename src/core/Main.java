package core;

import java.util.Scanner;

import order.Order;


public class Main {

	public static void main( String[] args){
		start();
	}
	
	public static void start() {
		
		String status = "1";
		do {
			 Scanner startScan= new Scanner(System.in); 
		     System.out.println("1 Begin Order\n2 Exit Sytem\nPlease Input The Number for The Corresponding Selection.");
		       
	    	 status = startScan.nextLine();
	    	 
	    	 if(status.equals("1")) {
	    		 
	    		 Order order = new Order();
	    		 order.orderPizza(order);
	    		 
	    	 }else if(status.equals("2")){
	  	       System.out.println("System Exited.");
	    	 }else {
	  	       System.out.println("Invalid Input Selction.");
	    	 }
	    	 
			
		}while(!status.equals("2"));
		
		
	}
	
}
