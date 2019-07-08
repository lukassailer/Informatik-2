package main;

import java.util.Map;

public class Multiply implements ComputationalNode
{
	private ComputationalNode left;
	private ComputationalNode right;

	public Multiply(ComputationalNode left, ComputationalNode right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return left.toString() + " * " + right.toString();
	}

	@Override
	public double evaluate(String unknowns)
	{
		return left.evaluate(unknowns) * right.evaluate(unknowns);
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Add(new Multiply(left.derivative(unknown), right), new Multiply(left, right.derivative(unknown)));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		left = left.cleanUp();
		right = right.cleanUp();
		if (left.isZero() || right.isZero())
			return new Constant(0);
		if (left.isOne())
			return right;
		if (right.isOne())
			return left;
		return this;
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
