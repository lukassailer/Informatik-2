package main;

public class Vegetable extends Food
{
	private int cooked;
	private int cookingMinutes;

	public Vegetable(String _name, int _kcal, int _cookingM)
	{
		super(_name, _kcal);
		cookingMinutes = _cookingM;
	}

	public int prepare(int weight)
	{
		while(edible==false)
		{
			cookIt();
		}
		return weight;
	}

	public void cookIt()
	{
		cooked++;
		if (cooked == cookingMinutes)
			edible = true;
	}

}
