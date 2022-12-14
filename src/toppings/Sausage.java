package toppings;

import java.util.ArrayList;

public class Sausage extends Topping{

	@Override 
	public ArrayList<String> addTops(ArrayList<String> currentToppings){
		currentToppings.add("Sausage");
		 System.out.println("Sausage Added To Toppings");
		return currentToppings;
	}
	
	@Override 
	public double addPrice(double price) {
		  price += 4.00;
		  return price;
		}
	
}
