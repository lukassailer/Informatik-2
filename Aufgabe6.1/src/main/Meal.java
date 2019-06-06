package main;

public class Meal
{

	private float kcalSum;
	private String[] ingredients; // ingredient names
	private int[] amounts; // weights of ingredients
	private int ingredientCount; // number of ingredients that were added

	public Meal()
	{
		kcalSum = 0;
		ingredientCount = 0;
		ingredients = new String[100];
		amounts = new int[100];
	}

	public void addFood(Food f, int am)
	{
		ingredients[ingredientCount] = f.name;
		amounts[ingredientCount] = f.prepare(am);
		kcalSum += f.computeCalories(am);
		ingredientCount++;
	}

	public void printStatus()
	{
		System.out.println("Your meal has: " + kcalSum + "kcal.");
		for (int i = 0; i < ingredientCount; i++)
		{
			System.out.println(amounts[i] + "g of " + ingredients[i]);
		}
	}

}
