package main;

import java.util.Map;

public class Divide implements ComputationalNode
{
	private ComputationalNode left;
	private ComputationalNode right;

	public Divide(ComputationalNode left, ComputationalNode right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return left.toString() + " / " + right.toString();
	}

	@Override
	public double evaluate(String unknowns)
	{
		if (right.evaluate(unknowns) == 0)
			throw new IllegalArgumentException("div0!");
		return left.evaluate(unknowns) / right.evaluate(unknowns);
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Divide(new Subtract(new Multiply(left.derivative(unknown), right),
				new Multiply(left, right.derivative(unknown))), new Power(right, 2));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		left = left.cleanUp();
		right = right.cleanUp();
		if (left.isZero())
			return new Constant(0);
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
