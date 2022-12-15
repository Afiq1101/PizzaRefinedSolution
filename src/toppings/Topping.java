package toppings;

import java.util.ArrayList;

import pizza.Pizza;

public abstract class  Topping extends Pizza {

	public abstract ArrayList<String> addTops(ArrayList<String> currentToppings);
	
	public abstract double addPrice(double price);

}
