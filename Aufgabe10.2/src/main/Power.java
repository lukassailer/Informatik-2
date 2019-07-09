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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		long temp;
		temp = Double.doubleToLongBits(power);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Power other = (Power) obj;
		if (child == null)
		{
			if (other.child != null)
				return false;
		}
		else if (!child.equals(other.child))
			return false;
		if (Double.doubleToLongBits(power) != Double.doubleToLongBits(other.power))
			return false;
		return true;
	}
}
