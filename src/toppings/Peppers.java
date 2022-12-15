package toppings;

import java.util.ArrayList;

import pizza.Pizza;

public class Peppers extends Topping{

	@Override 
	public ArrayList<String> addTops(ArrayList<String> currentToppings){
		currentToppings.add("Peppers");
		 System.out.println("Peppers Added To Toppings");
		return currentToppings;
	}
	
	@Override
	public double addPrice(double price) {
		  price += 2.00;
		  return price;
		}

	@Override
	public Pizza setSize(Pizza currentPizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double setPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
