package pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

	public String size;
	public ArrayList<String> toppings = new ArrayList<String>();
	public double totalPrice;
	
	
	public double setPriceS(){
		return  10.00;
	}
	
	public double setPriceM(){
		return 15.00;
	}
	
	public double setPriceL(){
		return  20.00;
	}
	
	public Pizza setSizeS(Pizza currentPizza) {
		 currentPizza.size = "S";
		 return currentPizza;
	}
	
	public Pizza setSizeM(Pizza currentPizza) {
		 currentPizza.size = "M";
		 return currentPizza;
	}
	
	public Pizza setSizeL(Pizza currentPizza) {
		 currentPizza.size = "L";
		 return currentPizza;
	}
	
	//---------------------------------------------------------------
	public ArrayList<String> addPeppers(ArrayList<String> currentToppings){
		currentToppings.add("Peppers");
		 System.out.println("Peppers Added To Toppings");
		return currentToppings;
	}
	
	
	public double addPeppersPrice(double price) {
		  price += 2.00;
		  return price;
		}

	//---------------------------------------------------------------
	public ArrayList<String> addSausage(ArrayList<String> currentToppings){
		currentToppings.add("Sausage");
		 System.out.println("Sausage Added To Toppings");
		return currentToppings;
	}
	
	
	public double addSausagePrice(double price) {
		  price += 4.00;
		  return price;
		}


	
	//---------------------------------------------------------------
	public ArrayList<String> addPepperoni(ArrayList<String> currentToppings){
		currentToppings.add("Pepperoni");
		 System.out.println("Pepperoni Added To Toppings");
		return currentToppings;
	}
	

	public double addPepperoniPrice(double price) {
		  price += 3.00;
		  return price;
		}

//------------------------------------------------
	public Pizza createPizza() {
		Pizza newPizza = new Pizza();
		System.out.println("Creating Pizza.");
	       boolean validValue = false;
		do {
	    	   System.out.println("1 Proceed\n2 Done\nPlease Enter the corresponding number to proceed:");
	    	   Scanner proceedScan= new Scanner(System.in);
	    	   String  selectedOption = proceedScan.next();

	    	   if(selectedOption.trim().equals("1")) {
	    		   
	    		   boolean sizeIsValid = false; 
	    		   do {
			    	   System.out.println("1 Small\n2 Medium\n3 Large\nPlease Enter the corresponding number to proceed:");
			    	   Scanner sizeScan= new Scanner(System.in);
			    	   String  sizeIndex = sizeScan.next();
			    	   
			    	   if(sizeIndex.trim().equals("1")) {
			    		   newPizza = setSizeS(newPizza);
			    		   newPizza.totalPrice = setPriceS();
			    		   sizeIsValid  = true;
			    	   }else if(sizeIndex.trim().equals("2")) {
			    		   newPizza = setSizeM(newPizza);
			    		   newPizza.totalPrice = setPriceM();
			    		   sizeIsValid  = true;
			    	   }else if(sizeIndex.trim().equals("3")) {
			    		   newPizza = setSizeL(newPizza);
			    		   newPizza.totalPrice = setPriceL();
			    		   sizeIsValid  = true;
			    	   }else {
			    		   sizeIsValid = false;
			    			System.out.println("Invalid Input. Please Try Again.");
			    	   }
		    	   
	    		   }while(sizeIsValid == false);
		    	   
	    		   
	    		   boolean toppingIsValid = false; 
	    		   do {
			    	   System.out.println("1 Peppers\n2 Sausage\n3 Pepperoni\n4 Done\nPlease Enter the corresponding number to proceed:");
			    	   Scanner toppingScan= new Scanner(System.in);
			    	   String  toppingIndex = toppingScan.next();
			    	   
			    	   if(toppingIndex.trim().equals("1")) {
			    		   newPizza.toppings = addPeppers(newPizza.toppings);
			    		   newPizza.totalPrice = addPeppersPrice(newPizza.totalPrice);
			    		   
			
			    	   }else if(toppingIndex.trim().equals("2")) {
			    		   newPizza.toppings = addSausage(newPizza.toppings);
			    		   newPizza.totalPrice = addSausagePrice(newPizza.totalPrice);
			    		   
			    	   }else if(toppingIndex.trim().equals("3")) {
			    		   newPizza.toppings = addPepperoni(newPizza.toppings);
			    		   newPizza.totalPrice = addPepperoniPrice(newPizza.totalPrice);
			    		   
			    	   }else if(toppingIndex.trim().equals("4")){	
			    		   toppingIsValid  = true;

			    	   }else {
			    		   toppingIsValid = false;
			    	   }
			    	   
			    	   
			    	   System.out.println("Current Total: " + newPizza.totalPrice );
		    	   
	    		   }while(toppingIsValid == false);
	    		  
	    		   
	    	   }else if(selectedOption.trim().equals("2")) {
	    		   validValue = true;
	    	   }
	    	   
	    	   
	       }while(validValue == false);

		return newPizza;
		
	}
	
	
	
}
