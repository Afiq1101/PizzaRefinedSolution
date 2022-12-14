package pizza;

import java.util.ArrayList;
import java.util.Scanner;

import toppings.Pepperoni;
import toppings.Peppers;
import toppings.Sausage;
import toppings.Topping;

public abstract class Pizza {
	
	public String size;
	public ArrayList<String> toppings = new ArrayList<String>();
	public double totalPrice;
	
	public abstract Pizza setSize(Pizza currentPizza);
	public abstract double setPrice();
	
	//------------------------------------------------
	
	public Pizza createPizza() {
	    Pizza newPizza = new SizeSmall();
	    System.out.println("Creating Pizza.");

	    while (true) {
	        System.out.println("1 Proceed\n2 Done\nPlease Enter the corresponding number to proceed:");
	        Scanner proceedScan = new Scanner(System.in);
	        String selectedOption = proceedScan.next();

	        if (selectedOption.trim().equals("1")) {
	            newPizza = selectPizzaSize(newPizza);
	            newPizza = addToppings(newPizza);
	            break;
	        } else if (selectedOption.trim().equals("2")) {
	            break;
	        }else {
	        	System.out.println("Invalid Input. Please Try Again.");
	        }
	    }

	    return newPizza;
	}

	
		Pizza selectPizzaSize(Pizza newPizza ){
			
    		   while(true) {
		    	   System.out.println("1 Small\n2 Medium\n3 Large\nPlease Enter the corresponding number to proceed:");
		    	   Scanner sizeScan= new Scanner(System.in);
		    	   String  sizeIndex = sizeScan.next();
		    	   
		    	   if(sizeIndex.trim().equals("1")) {
		    		   newPizza = new SizeSmall();
		    		   newPizza = newPizza.setSize(newPizza);
		    		   newPizza.totalPrice = newPizza.setPrice();
		    		   break;
		    	   }else if(sizeIndex.trim().equals("2")) {
		    		   newPizza = new SizeMedium();
		    		   newPizza = newPizza.setSize(newPizza);
		    		   newPizza.totalPrice = newPizza.setPrice();
		    		   break;
		    	   }else if(sizeIndex.trim().equals("3")) {
		    		   newPizza = new SizeLarge();
		    		   newPizza = newPizza.setSize(newPizza);
		    		   newPizza.totalPrice = newPizza.setPrice();
		    		   break;
		    	   }else {
		    			System.out.println("Invalid Input. Please Try Again.");
		    	   }
	    	   
    		   }
			
			return newPizza;
		}
		
		
		Pizza addToppings(Pizza newPizza) {
		    Scanner toppingScan = new Scanner(System.in);

		    while (true) {
		        System.out.println("1 Peppers\n2 Sausage\n3 Pepperoni\n4 Done\nPlease Enter the corresponding number to proceed:");
		        String toppingIndex = toppingScan.next();

		        if (toppingIndex.trim().equals("1")) {
		            Topping tops = new Peppers();
		            newPizza.toppings = tops.addTops(newPizza.toppings);
		            newPizza.totalPrice = tops.addPrice(newPizza.totalPrice);
		        } else if (toppingIndex.trim().equals("2")) {
		            Topping tops = new Sausage();
		            newPizza.toppings = tops.addTops(newPizza.toppings);
		            newPizza.totalPrice = tops.addPrice(newPizza.totalPrice);
		        } else if (toppingIndex.trim().equals("3")) {
		            Topping tops = new Pepperoni();
		            newPizza.toppings = tops.addTops(newPizza.toppings);
		            newPizza.totalPrice = tops.addPrice(newPizza.totalPrice);
		        } else if (toppingIndex.trim().equals("4")) {
		            break;
		        } else {
		            continue;
		        }

		        System.out.println("Current Total: " + newPizza.totalPrice);
		    }

		    return newPizza;
		}
		
	
		
}
