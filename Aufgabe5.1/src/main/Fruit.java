package main;

public class Fruit
{
	public String name;
	public int kcal; // per 100g
	private boolean hasPeel;

	public Fruit(String _name, int _kcal, boolean _hasPeel)
	{
		name = _name;
		kcal = _kcal;
		hasPeel = _hasPeel;
	}

	public float computeCalories(float gramms)
	{
		if (hasPeel)
			return (kcal / 100.0f) * .9f * gramms;
		return (kcal / 100.0f) * gramms;
	}

}
