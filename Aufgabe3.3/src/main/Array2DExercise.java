package main;

import java.util.Scanner;

public class Array2DExercise
{
	// 3.2 a)
	public static void print_array_2d(int[] array)
	{
		double n = Math.sqrt(array.length); // immer eine gerade Zahl, weil wir ja ein quadratisches Array darstellen
		for (int j = 0; j < n * n; j += n)
		{
			for (int i = 0; i < n; i++)
			{
				System.out.print(array[i + j]);
			}
			System.out.print("\n");
		}
	}

	// 3.2 b)
	public static int[] walk(int[] labyrinth)
	{
		int i = 0;
		labyrinth[0] = 1;
		int n = (int) Math.sqrt(labyrinth.length);
		while (true)
		{
			while (labyrinth[i + 1] == 0)
			{
				labyrinth[i + 1] = 1;
				i++;
				if (i % n == n - 1)
				{
					break;
				}
			}
			if (i % n == n - 1)
			{
				break;
			}
			while (labyrinth[i + n] == 0)
			{
				labyrinth[i + n] = 1;
				i += n;
				if (i >= labyrinth.length - n)
				{
					break;
				}
			}
			if (i >= labyrinth.length - n)
			{
				break;
			}
		}

		return labyrinth;

	}

	public static void main(String[] args)
	{
		{
			int[] array = new int[5 * 5];
			array[0 * 5 + 2] = 8;
			array[2 * 5 + 1] = 8;
			print_array_2d(array);
			System.out.print("\n");
			print_array_2d(walk(array));
		}
		System.out.print("\n\n--------------------\n\n");
		{
			int[] array = new int[5 * 5];
			array[0 * 5 + 2] = 8;
			array[2 * 5 + 1] = 8;
			array[1 * 5 + 3] = 8;
			array[4 * 5 + 2] = 8;
			array[3 * 5 + 4] = 8;
			print_array_2d(array);
			System.out.print("\n");
			print_array_2d(walk(array));
		}
		System.out.print("\n\n--------------------\n\n");

	}
}
