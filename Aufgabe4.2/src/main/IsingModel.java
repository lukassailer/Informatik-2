package main;

import java.util.Arrays;

public class IsingModel
{
	// pruefen ob eine Belegung des Schachbrettes gueltig ist
	public static boolean isValid(boolean[] board, int n)
	{
		for (int y = 0; y < n - 1; y++)
		{
			for (int x = 0; x < n - 1; x++)
			{
				if (board[y * n + x] == true) // wenn Feld belegt...
				{
					if (board[(y + 1) * n + x] == true) // ...und rechter Nachbar
					{
						return false;
					}
					if (board[y * n + x + 1] == true) // ...und unterer Nachbar
					{
						return false;
					}
				}
			}
		}
		for (int i = 0; i < n-1; i++) // unterer und rechter Rand
		{
			if ((board[(n - 1) * n + i] == true) && (board[(n - 1) * n + i + 1] == true))
			{
				return false;
			}
			if ((board[(i * n + n - 1)] == true) && (board[(i + 1) * n + n - 1] == true))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		boolean[] example1 =
		{ false, false, false, false, true, true, true, false, false };

		boolean[] example2 =
		{ true, false, true, false, true, false, true, false, false };

		System.out.println(isValid(example1, 3));
		System.out.println(isValid(example2, 3));
	}
}
