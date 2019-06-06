package main;

import java.util.Scanner;

public class Series
{
	// Exercise Task
	// 2.1 a)
	public static int sum_up()
	{
		int result = 0;

		for (int i = 1; i <= 1000; i++)
		{
			result = result + i;
		}

		return result;
	}

	// Exercise Task
	// 2.1 b)
	public static void multiplication_table(int n)
	{

		for (int i = 1; i <= 10; i++)
		{
			System.out.println(n + " x " + i + " = " + n * i);
		}

	}

	// Exercise Task
	// 2.1 c)
	public static void fizz_buzz()
	{
		for (int i = 1; i <= 100; i++)
		{
			if (i % 3 == 0)
			{
				System.out.print("Fizz");
			}
			if (i % 5 == 0)
			{
				System.out.print("Buzz");
			}
			else if (i % 3 != 0)
			{
				System.out.print(i);
			}
			System.out.print("\n");
		}
	}

	// Exercise Task
	// 2.1 d)
	public static void chess_board(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			if (i % 2 == 0)
			{
				for (int j = 1; j <= n; j++)
				{
					System.out.print("-#");
				}
			}
			else
			{
				for (int j = 1; j <= n; j++)
				{
					System.out.print("#-");
				}
			}
			System.out.print("\n");
		}
	}

	// Exercise Task
	// 2.1 e)
	public static int factorial(int n)
	{
		int result = 1;

		for (int i = 1; i <= n; i++)
		{
			result = result * i;
		}

		return result;
	}

	// Exercise Task
	// 2.1 f)
	public static double ln2(int n)
	{
		double result = 0;

		for (double i = 1; i <= n; i++)
		{
			if (i % 2 == 0)
			{
				result = result - (1 / i);
			}
			else
			{
				result = result + (1 / i);
			}
		}

		return result;
	}

	// Exercise Task
	// 2.1 g)
	public static void reverse_digits(int n)
	{
		String ns = ("" + n);
		for (int i = 1; i <= ns.length(); i++)
		{
			System.out.println(ns.charAt(ns.length() - i));
		}
	}

	// Exercise Task
	// 2.1 h)
	public static double leibniz_series(int n)
	{
		double res = 0;

		for (int i = 0; i <= n; i++)
		{
			res = res + Math.pow(-1, i) / (2 * i + 1);
		}

		return 4 * res;
	}

	// Exercise Task
	// 2.1 i)
	public static boolean palindrome(String str)
	{
		int i = 0;
		int j = str.length() - 1;
		while (i < j)
		{
			if (str.charAt(i) != str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// Exercise Task
	// 2.1 j)
	public static long max_collatz(long m)
	{
		long max_startwert = 1;
		long n_max = 0;

		for (long a = 1; a <= m; a++)
		{
			long n_akt = 0;
			long a_temp = a;
			while (a_temp != 1)
			{
				n_akt++;
				if (a_temp % 2 == 0)
				{
					a_temp = a_temp / 2;
				}
				else
				{
					a_temp = 3 * a_temp + 1;
				}
			}
			if (n_akt > n_max)
			{
				max_startwert = a;
				n_max = n_akt;
			}
		}

		return max_startwert;
	}

	// Exercise Task
	// 2.1 k)
	public static double gradient_descent(double x0, double a, double b)
	{

		double x_cur = x0;
		double x_old = x0 + 1;
		long n = 0;

		while (Math.abs(x_cur - x_old) > 1e-7 && n < 1000)
		{
			n++;
			x_old = x_cur;
			x_cur = x_old - 0.001 * (2 * (x_old - a));
		}

		return x_cur;

	}

	// Exercise Task
	// 2.1 l)
	public static void pattern_a(int num_rows)
	{
		for (int i = 1; i <= num_rows; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(i + ",");
			}
			System.out.print("\n");
		}

	}

	// Exercise Task
	// 2.1 m)
	public static void pattern_b(int num_rows)
	{
		for (int i = 1; i <= num_rows; i++)
		{
			for (int j = i; j >= 1; j--)
			{
				System.out.print(j + ",");
			}
			System.out.print("\n");
		}
	}

	// Exercise Task
	// 2.1 n)
	public static int seven_sum(int num)
	{
		int sum = 0;
		String temp = "";
		for (int i = 1; i <= num; i++)
		{
			temp = temp + "7";
			sum = sum + Integer.parseInt(temp);
		}

		return sum;
	}

	// Exercise Task
	// 2.1 o)
	public static void ones_and_zeros(int rows)
	{
		String line = "";
		for (int i = 1; i <= rows; i++)
		{
			if (i % 2 == 0)
			{
				line = "1," + line;
			}
			else
			{
				line = "0," + line;
			}
			System.out.println(line);
		}
	}

	// Exercise Task
	// 2.2 p)
	public static boolean is_perfect(int number)
	{
		int sum = 0;

		for (int i = 1; i <= number / 2; i++) // der größte Teiler ist immer <= floor(number/2)
		{
			if (number % i == 0)
			{
				sum = sum + i;
			}
		}
		return sum == number;
	}

	public static void main(String[] args)
	{

		System.out.println("2.1 a) ");
		System.out.println(sum_up());

		System.out.println("2.1 b) ");
		multiplication_table(4);

		System.out.println("2.1 c) ");
		fizz_buzz();

		System.out.println("2.1 d) ");
		chess_board(4);

		System.out.println("2.1 e) ");
		System.out.println(factorial(4));

		System.out.println("2.1 f) ");
		System.out.println(ln2(100000));

		System.out.println("2.1 g) ");
		reverse_digits(1239);

		System.out.println("2.1 h) ");
		System.out.println(leibniz_series(1000));

		System.out.println("2.1 i) ");
		System.out.println(palindrome("1"));
		System.out.println(palindrome("12321"));
		System.out.println(palindrome("12323"));

		System.out.println("2.1 j) ");
		System.out.println(max_collatz(100));

		System.out.println("2.1 k) ");
		System.out.println(gradient_descent(1, 10, 2));

		System.out.println("2.1 l) ");
		pattern_a(5);

		System.out.println("2.1 m) ");
		pattern_b(5);

		System.out.println("2.1 n) ");
		System.out.println(seven_sum(1)); // 7 = 7
		System.out.println(seven_sum(2)); // 7 + 77 = 84
		System.out.println(seven_sum(3)); // 7 + 77 + 777 = 861

		System.out.println("2.1 o) ");
		ones_and_zeros(4);

		System.out.println("2.1 p) ");
		System.out.println(is_perfect(6));
		System.out.println(is_perfect(14));
	}
}
