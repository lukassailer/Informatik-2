package main;

import java.util.Arrays;

public class Recursion
{

	public static int fibonacci(int n)
	{
		switch (n)
		{
		case 0:
			return 0;
		case 1:
			return 1;
		default:
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}

	public static double gregoryLeibnizRecursive(int n)
	{
		return (n > 0 ? gregoryLeibnizRecursive(n - 1) : 0) + 4.0 / (n * 2 + 1) * (1 - 2 * (n % 2));
	}

	public static double gregoryLeibnizIterative(int n)
	{
		double erg = 0;
		for (int i = 0; i <= n; i++)
		{
			erg += Math.pow(-1, i) / (2 * i + 1);
		}
		return erg * 4;
	}

	public static void main(String[] args)
	{

		int[] fibs = new int[20];
		for (int i = 0; i < fibs.length; i++)
		{
			fibs[i] = fibonacci(i);
		}
		System.out.println("Your first 20 Fibonacci numbers:");
		System.out.println(Arrays.toString(fibs));

		System.out.println("\nApproximations of Pi (" + Math.PI + "):");
		System.out.println("Recursive: " + gregoryLeibnizRecursive(10000));
		System.out.println("Iterative: " + gregoryLeibnizIterative(10000000));
	}
}
