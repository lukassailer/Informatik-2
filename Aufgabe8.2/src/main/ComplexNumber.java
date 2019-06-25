package main;

public class ComplexNumber
{
private double real;
private double imaginary;
	public ComplexNumber(double real, double imaginary)
	{
	this.real = real;
	this.imaginary = imaginary;
	}

	public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) 
	{
		return new ComplexNumber(z1.real+z2.real,z1.imaginary+z2.imaginary);
	}
	
	public static ComplexNumber square(ComplexNumber z) //ich glaube x*x ist ein gutes St�ck schneller als Math.pow(x,2)
	{
		return new ComplexNumber(z.real*z.real-z.imaginary*z.imaginary,2*z.real*z.imaginary);
	}
	
	public double abs()
	{
		return Math.sqrt(real*real+imaginary*imaginary);
	}
}
