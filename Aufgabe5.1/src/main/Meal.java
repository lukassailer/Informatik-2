package main;

public class Meal
{

	private float kcalSum;
	private String[] ingredients;
	private int[] amounts;
	private int counter;

	public Meal()
	{
		kcalSum = 0;
		counter = 0;
		ingredients = new String[100];
		amounts = new int[100];
	}

	public void addFruit(Fruit fruit, int weight)
	{
		kcalSum += fruit.computeCalories(weight);
		ingredients[counter] = fruit.name;
		amounts[counter] = weight;
		counter++;
	}

	public void addVegetable(Vegetable vegetable, int gVegetable)
	{
		kcalSum += vegetable.computeCalories(gVegetable);
		ingredients[counter] = vegetable.name;
		amounts[counter] = gVegetable;
		counter++;
	}

	public void printStatus()
	{

		System.out.println("Your meal has: " + kcalSum + "kcal.");
		for (int i = 0; i < counter; i++)
			System.out.println(amounts[i] + "g of " + ingredients[i]);
	}

}
