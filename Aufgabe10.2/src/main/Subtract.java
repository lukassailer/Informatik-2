package main;

import java.util.Map;

public class Subtract implements ComputationalNode
{
	private ComputationalNode left;
	private ComputationalNode right;

	public Subtract(ComputationalNode left, ComputationalNode right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "(" + left.toString() + " - " + right.toString() + ")";
	}

	@Override
	public double evaluate(String unknowns)
	{
		return left.evaluate(unknowns) - right.evaluate(unknowns);
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Subtract(left.derivative(unknown), right.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		left = left.cleanUp();
		right = right.cleanUp();
		if (right.isZero())
			return left;
		return new Subtract(left, right);
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
