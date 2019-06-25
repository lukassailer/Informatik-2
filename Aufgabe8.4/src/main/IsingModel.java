package main;

import java.util.Arrays;

public class IsingModel
{

	// Check if a board constellation is valid
	public static boolean isValid(boolean[] board, int n)
	{
		// Iterate over all positions on the board
		for (int x = 0; x < n; x++)
		{
			for (int y = 0; y < n; y++)
			{
				// If a position is occupied: check for its neighbors
				if (board[x * n + y] == true)
				{
					// If the up-field exists, check if occupied
					if (x != 0)
					{
						if (board[(x - 1) * n + y] == true)
						{
							return false;
						}
					}
					// If the down-field exists, check if occupied
					if (x != n - 1)
					{
						if (board[(x + 1) * n + y] == true)
						{
							return false;
						}
					}
					// If the left-field exists, check if occupied
					if (y != 0)
					{
						if (board[x * n + (y - 1)] == true)
						{
							return false;
						}
					}
					// If the right-field exists, check if occupied
					if (y != n - 1)
					{
						if (board[x * n + (y + 1)] == true)
						{
							return false;
						}
					}
				}
			}
		}

		// The board does not contain any neighboring stones and is therefore valid
		return true;
	}

	private static int countTrues(boolean[] array)
	{
		int temp = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i])
				temp++;
		}
		return temp;
	}

	public static int countPossibilities(int stoneCount, int n, int startX, boolean[] board)
	{
		int temp = 0;

		if (startX == board.length)
			if ((countTrues(board) == stoneCount) && isValid(board, n))
				return 1;
			else
				return 0;

		if (countTrues(board) < stoneCount)
		{
			board[startX] = true;
			temp += countPossibilities(stoneCount, n, startX + 1, board);
		}

		board[startX] = false;
		temp += countPossibilities(stoneCount, n, startX + 1, board);
		return temp;
	}

	public static int possibleConstellations(int n)
	{
		int erg = 0;
		boolean[] board = new boolean[n * n];
		for (int i = 0; i <= n * n; i++)
		{
			erg += countPossibilities(i, n, 0, board);
		}
		return erg;
	}

	public static void main(String[] args)
	{
		boolean[] example1 =
		{ false, false, false, false, true, true, true, false, false };
		boolean[] example2 =
		{ true, false, true, false, true, false, true, false, false };

		System.out.println(isValid(example1, 3));
		System.out.println(isValid(example2, 3));

		int n = 4; // Size of the board
		// results: 0 => 0; 1 => 2; 2 => 7; 3 => 63; 4 => 1234; 5 => 55447

		System.out.println(
				"Valid constellations for a board of size " + n + " x " + n + ": " + possibleConstellations(n));
	}
}
