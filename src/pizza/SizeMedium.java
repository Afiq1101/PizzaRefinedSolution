package pizza;

public class SizeMedium extends Pizza{

	
	@Override
	public Pizza setSize(Pizza currentPizza) {
		 currentPizza.size = "M";
		 return currentPizza;
	}
	
	@Override
	public double setPrice(){
		return 15.00;
	}
	
}
