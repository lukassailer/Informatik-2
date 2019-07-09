package main;

import java.util.Map;

public class Cosine implements ComputationalNode
{
	private ComputationalNode x;

	public Cosine(ComputationalNode x)
	{
		this.x = x;
	}

	@Override
	public double evaluate(String unknowns)
	{
		return Math.cos(x.evaluate(unknowns));
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Multiply(new Multiply(new Constant(-1), new Sine(x)), x.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		x.cleanUp();
		if (x.isOne())
			return new Constant(1);
		return new Cosine(x);
	}

	@Override
	public boolean isZero()
	{
		return false;
	}

	@Override
	public boolean isOne()
	{
		return (cleanUp().isOne());
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
		Cosine other = (Cosine) obj;
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
