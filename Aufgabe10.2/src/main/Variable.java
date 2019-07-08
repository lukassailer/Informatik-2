package main;

import java.util.Map;

public class Variable implements ComputationalNode
{
	private String label;

	public Variable(String label)
	{
		this.label = label;
	}

	public String toString()
	{
		return label;
	}

	@Override
	public double evaluate(String unknowns)
	{
		// "x = 2, y=12.22"
		unknowns = unknowns.replace(" ", ""); // "x=2,y=12.22"
		unknowns = unknowns.replace("=", ","); // "x,2,y,12.22"
		String u[] = unknowns.split(","); // { x , 2 , y , 12.22 }
		for (int i = 0; i < u.length; i++)
		{
			if (u[i].equals(label))
				return Double.parseDouble(u[i + 1]);
		}
		throw new IllegalArgumentException("failed to evaluate variable");
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		if (unknown.equals(label))
			return new Constant(1);
		return new Constant(0);
	}

	@Override
	public ComputationalNode cleanUp()
	{
		return new Variable(label);
	}

	@Override
	public boolean isZero()
	{
		return false;
	}

	@Override
	public boolean isOne()
	{
		return false;
	}

}
