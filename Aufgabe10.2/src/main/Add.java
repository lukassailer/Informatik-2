package main;

import java.util.Map;

public class Add implements ComputationalNode
{
	private ComputationalNode left;
	private ComputationalNode right;

	public Add(ComputationalNode left, ComputationalNode right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "(" + left.toString() + " + " + right.toString() + ")";
	}

	@Override
	public double evaluate(String unknowns)
	{
		return left.evaluate(unknowns) + right.evaluate(unknowns);
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Add(left.derivative(unknown), right.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		left = left.cleanUp();
		right = right.cleanUp();
		if (left instanceof Constant && right instanceof Constant)
			return new Constant(this.evaluate(""));// beides Konstanten also kein unknows nötig
		/*else if (!(left instanceof Constant))
			return new Add(left.cleanUp(), right);
		else if (!(right instanceof Constant))
			return new Add(left, right.cleanUp());*/
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
