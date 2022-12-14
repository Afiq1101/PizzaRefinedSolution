package pizza;

public class SizeLarge extends Pizza {

	@Override
	public Pizza setSize(Pizza currentPizza) {
		 currentPizza.size = "L";
		 return currentPizza;
	}
	
	@Override
	public double setPrice(){
		return  20.00;
	}
}
