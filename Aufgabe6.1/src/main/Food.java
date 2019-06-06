package main;

public abstract class Food
{

	public String name;
	public int kcal; // per 100g
	protected boolean edible;

	public abstract int prepare(int weight);

	public Food(String _name, int _kcal)
	{
		name = _name;
		kcal = _kcal;
		edible = false;
	}

	public float computeCalories(float gramms)
	{
		if (edible)
			return (kcal*gramms)/100;
		else
			return 0.0f;
	}
}
