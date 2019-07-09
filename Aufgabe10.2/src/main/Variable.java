package main;

import java.util.Map;
import java.util.Objects;

public class Variable implements ComputationalNode
{
	private String label;

	public Variable(String label)
	{
		this.label = label;
	}

	public String toString()
	{
		return label;
	}

	@Override
	public double evaluate(String unknowns)
	{
		// "x = 2, y=12.22"
		unknowns = unknowns.replace(" ", ""); // "x=2,y=12.22"
		unknowns = unknowns.replace("=", ","); // "x,2,y,12.22"
		String u[] = unknowns.split(","); // { x , 2 , y , 12.22 }
		for (int i = 0; i < u.length; i++)
		{
			if (u[i].equals(label))
				return Double.parseDouble(u[i + 1]);
		}
		throw new IllegalArgumentException("failed to evaluate variable");
	}

	@Override
	public double evaluate(Map<String, Double> unknowns)
	{
		return 0;
	}

	@Override
	public ComputationalNode derivative(String unknown)
	{
		if (unknown.equals(label))
			return new Constant(1);
		return new Constant(0);
	}

	@Override
	public ComputationalNode cleanUp()
	{
		return new Variable(label);
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Variable other = (Variable) obj;
		if (label == null)
		{
			if (other.label != null)
				return false;
		}
		else if (!label.equals(other.label))
			return false;
		return true;
	}
}
