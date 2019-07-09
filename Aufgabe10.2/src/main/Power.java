package main;

import java.util.Map;

public class Power implements ComputationalNode
{
	private ComputationalNode child;
	private double power;

	public Power(ComputationalNode child, double power)
	{
		this.child = child;
		this.power = power;
	}

	public String toString()
	{
		return child.toString() + "^" + power;
	}

	@Override
	public double evaluate(String unknowns)
	{
		return Math.pow(child.evaluate(unknowns), power);
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Multiply(new Multiply(new Constant(power), new Power(child, power - 1)), child.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		return new Power(child.cleanUp(), power);
	}

	@Override
	public boolean isZero()
	{
		return false;
	}

	@Override
	public boolean isOne()
	{
		if (power == 0)
			return true;
		return false;
	}

	
	public boolean equals(Object obj)
	{
		return (this == obj);
	}
	
	public int hashCode()
	{
		return -1;
	}
}
