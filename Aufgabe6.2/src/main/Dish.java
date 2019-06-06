package main;

public class Dish
{
	public float dirty;
	public float dirtReduction;
	public int size;

	public Dish(float _dirty)
	{
		dirty = _dirty;
		dirtReduction = 0.3f;
	}

	public void printStatus()
	{
		if (dirty > 0.1)
			System.out.println(getClass().getSimpleName() + " still dirty");
		else
			System.out.println(getClass().getSimpleName() + " is clean");
	}

	public void clean()
	{
		if (dirty - dirtReduction <= 0)
			dirty = 0;
		else
			dirty -= dirtReduction;
	}
}
