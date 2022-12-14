package toppings;

import java.util.ArrayList;

public class Pepperoni extends Topping{

	@Override 
	public ArrayList<String> addTops(ArrayList<String> currentToppings){
		currentToppings.add("Pepperoni");
		 System.out.println("Pepperoni Added To Toppings");
		return currentToppings;
	}
	
	@Override 
	public double addPrice(double price) {
		  price += 3.00;
		  return price;
		}
}
