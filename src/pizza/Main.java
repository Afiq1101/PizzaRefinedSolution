package pizza;

import java.util.Scanner;

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


//Payment pay = new Payment();
//
//pay.pay(23.0);

//
//Pizza p = new Pizza();
//
//Pizza pizza = new Pizza();
//p = pizza.createPizza();
//
//System.out.println(p.size);
//System.out.println(p.totalPrice);

//
//Order o = new Order();
//
//o.payOrder(40);
//
