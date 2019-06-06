package main;

public class Dishwasher
{
	private Dish[] content;
	private int capacity;

	public Dishwasher(int _capacity)
	{
		content = new Dish[_capacity]; //maximal 20*1 also 20*Cutlery
		capacity = _capacity;
	}

	public void fillAndUse(Dish[] arr)
	{
		int j = 0;
		int rest = capacity;
		for (int i = 0; i < arr.length; i++)
		{
			if (rest - arr[i].size >= 0)
			{
				content[j] = arr[i];
				j++;
				rest -= arr[i].size;
			}
		}

		for (int k = 0; k < j; k++)
			content[k].clean(0.3f);
	}

	public static void main(String[] args)
	{
		Dish[] array = new Dish[]
		{ new Dish("Cutlery", 0.1f), new Dish("Cutlery", 0.1f), new Dish("Plate", 0.6f), new Dish("Plate", 0.2f),
				new Dish("Cup", 0.2f), new Dish("Cup", 0.8f), new Dish("Plate", 0.1f), new Dish("Pot", 0.9f),
				new Dish("Pot", 0.4f), new Dish("Plate", 0.4f) };

		Dishwasher dishwasher = new Dishwasher(20);
		dishwasher.fillAndUse(array);

		for (int i = 0; i < array.length; i++)
		{
			array[i].printStatus();
		}
	}

}
