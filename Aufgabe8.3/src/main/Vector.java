package main;

public class Vector
{
	public double x;
	public double y;

	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector rotated(double alpha)
	{
		double cos = Math.cos(alpha);
		double sin = Math.sin(alpha);
		return new Vector(x * cos - y * sin, x * sin + y * cos);
	}

	public Vector scaled(double s)
	{
		return new Vector(x * s, y * s);
	}

	public Vector added(Vector v)
	{
		return new Vector(x + v.x, y + v.y);
	}
}
