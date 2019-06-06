package main;

public class Fruit extends Food
{

	private boolean hasPeel; // boolean default = false

	public Fruit(String _name, int _kcal, boolean _hasPeel)
	{
		super(_name, _kcal);
		hasPeel = _hasPeel;
		edible = !_hasPeel;
	}

	public int prepare(int weight)
	{
		if (hasPeel)
		{
			hasPeel = false;
			edible = true;
			weight = (int) (weight * 0.9);
		}
		return weight;
	}
}
