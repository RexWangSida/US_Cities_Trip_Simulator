package Graph;

public class FoodADT{
	private final double price;
	private final String name;
	private final char restaurant;
	public FoodADT(double price, char restaurant, String name) {
		this.price = price;
		this.name = name;
		this.restaurant = restaurant;
	}
	
	public double Get_price() {
		return this.price;
	}
	
	public String Get_name() {
		return this.name;
	}
	
	public char Get_res() {
		return this.restaurant;
	}

}
