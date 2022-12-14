package pizza;

public class SizeSmall extends Pizza{

	@Override
	public Pizza setSize(Pizza currentPizza) {
		 currentPizza.size = "S";
		 return currentPizza;
	}
	
	@Override
	public double setPrice(){
		return  10.00;
	}
	
}
