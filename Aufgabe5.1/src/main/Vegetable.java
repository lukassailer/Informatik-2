package main;

public class Vegetable
{
	public String name;
	public int kcal; // per 100g
	private boolean edible;
	private int cookingMinutes;
	private int cooked;

	public Vegetable(String _name, int _kcal, int _cookingMinutes)
	{
		name = _name;
		kcal = _kcal;
		cookingMinutes = _cookingMinutes;
		edible = false;
		cooked = 0;
	}

	public boolean isEdible()
	{
		return edible;
	}
	
	public void cookIt()
	{
		cooked++;
		if(cooked>=cookingMinutes)
			edible=true;
	}
	
	public float computeCalories(float gramms)
	{
		if (edible)
			return (kcal / 100.0f) * gramms;
		return 0;
	}
}
