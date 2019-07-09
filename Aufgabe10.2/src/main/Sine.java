package main;

import java.util.Map;

public class Sine implements ComputationalNode
{
	private ComputationalNode x;

	public Sine(ComputationalNode x)
	{
		this.x = x;
	}

	@Override
	public double evaluate(String unknowns)
	{
		return Math.sin(x.evaluate(unknowns));
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Multiply(new Cosine(x), x.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		x.cleanUp();
		if (x.isZero())
			return new Constant(0);
		return new Sine(x);
	}

	@Override
	public boolean isZero()
	{
		return (cleanUp().isZero());
	}

	@Override
	public boolean isOne()
	{
		return false;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sine other = (Sine) obj;
		if (x == null)
		{
			if (other.x != null)
				return false;
		}
		else if (!x.equals(other.x))
			return false;
		return true;
	}

}
