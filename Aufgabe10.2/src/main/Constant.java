package main;

import java.util.Map;

public class Constant implements ComputationalNode
{
	private double value;

	public Constant(double value)
	{
		this.value = value;
	}
	
	public String toString()
	{
		return Double.toString(value);
	}

	@Override
	public double evaluate(String unknowns)
	{
		return value;
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Constant(0);
	}

	@Override
	public ComputationalNode cleanUp()
	{
		return new Constant(value);
	}

	@Override
	public boolean isZero()
	{
		return (value == 0);
	}

	@Override
	public boolean isOne()
	{
		return (value == 1);
	}

}
