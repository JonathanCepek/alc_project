import java.util.ArrayList;

public class User
{
	private String first, last;
	private int weight, height, total_drinks, bac; //height is to be passed as int of inches
	private ArrayList<Drink> consumed;
	
	public User(String first, String last, int weight,int height, int total_drinks)
	{
		this.first = first;
		this.last = last;
		this.weight = weight;
		this.height = height;
		this.total_drinks = total_drinks;
		this.bac = 0;
		this.consumed = new ArrayList<Drink>();
	}

	public void addDrink(Drink add)
	{
		//increment drink if the drink contains 1 Standard drink
		
		//add Drink to ArrayList
		
		//Increment BAC depending on time
	}
	
	//Setters and Getters
	public void setFirst(String first)
	{
		this.first = first;
	}
	
	public void setLast(String last)
	{
		this.last = last;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setDrinks(int drinks)
	{
		this.total_drinks = drinks;
	}

}
