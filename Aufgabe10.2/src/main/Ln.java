package main;

import java.util.Map;

public class Ln implements ComputationalNode
{
	private ComputationalNode x;

	public Ln(ComputationalNode x)
	{
		this.x = x;
	}

	@Override
	public double evaluate(String unknowns)
	{
		return Math.log(x.evaluate(unknowns));
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		return new Multiply((new Divide(new Constant(1), x)), x.derivative(unknown));
	}

	@Override
	public ComputationalNode cleanUp()
	{
		if (x.isOne())
			return new Constant(0);
		/*
		 * if(x.isZero()) //sicherheitshalber mal auskommentiert return new
		 * Constant(Double.NEGATIVE_INFINITY);
		 */
		if (x instanceof Constant && x.evaluate("") == Math.E)
			return new Constant(1);
		return new Ln(x);
	}

	@Override
	public boolean isZero()
	{
		return cleanUp().isZero();
	}

	@Override
	public boolean isOne()
	{
		return cleanUp().isOne();
	}

}
