package main;

import java.util.Scanner;
import java.util.Arrays;

public class Methods
{

	public static boolean isEqual(int[] a1, int[] a2)
	{
		if (a1.length == a2.length)
		{
			for (int i = 0; i < a1.length; i++)
			{
				if (a1[i] != a2[i])
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static int[] reverse(int[] a)
	{
		int temp = 0;
		int length = a.length;
		for (int i = 0; i < length / 2; i++)
		{
			temp = a[i];
			a[i] = a[length - i - 1];
			a[length - i - 1] = temp;
		}
		return a;
	}

	public static boolean isReversed(int[] a1, int[] a2)
	{
		return isEqual(a1, reverse(a2));
	}

	public static boolean isPrime(int z)
	{
		if (z == 2)
		{
			return true;
		}
		if (z % 2 != 0)
		{
			for (int i = 3; i <= (z / 3); i += 2)
			{
				if (z % i == 0)
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static boolean belongsToPrimeTwin(int z)
	{
		if (isPrime(z) && (isPrime(z + 2) || isPrime(z - 2)))
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		int[] x =
		{ 1, 2, 3, 4, 5 };
		System.out.println(isEqual(x, x));
		System.out.println(Arrays.toString(reverse(x)).equals("[5, 4, 3, 2, 1]"));
		System.out.println(isReversed(reverse(x), x));
		System.out.println(
				isPrime(1) && isPrime(2) && isPrime(3) && isPrime(5) && isPrime(7) && isPrime(11) && isPrime(13));
		System.out.println(!(isPrime(4) || isPrime(6) || isPrime(8) || isPrime(10) || isPrime(12) || isPrime(14)
				|| isPrime(9) || isPrime(15)));
		System.out.println(
				!belongsToPrimeTwin(10) && belongsToPrimeTwin(11) && belongsToPrimeTwin(13) && !belongsToPrimeTwin(23));
	}
}
