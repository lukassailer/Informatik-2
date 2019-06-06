package main;

public class Dish				//Klasse Dish
{
	private String name;		//Text Name z.B. "Plate"
	private float dirty;		//Flie�kommazahl Schmutzigkeitsgrad (0 bis 1)
	public int size;			//Ganzzahl Gr��e
	
	public Dish(String _name, float _dirty) //Konstruktor
	{							//initialisiert mit
		name = _name;			//Name und
		dirty = _dirty;			//Schmutzigkeitsgrad
		determineSize();
	}

	public void printStatus()	//print Status printet Schmutzigkeitsgrad
	{
		if (dirty > 0.1)
			System.out.println(name + " still dirty");
		else
			System.out.println(name + " is clean");
	}

	public void clean(float amount)  //clean reduziert dirty Wert um amount aber maximal auf 0
	{
		if (dirty - amount <= 0)
			dirty = 0;
		else
			dirty -= amount;
	}
	
	private void determineSize()
	{
		if(name=="Cutlery")
			size = 1;
		else if(name=="Pot")
			size = 5;
		else
			size = 2;
	}
}
