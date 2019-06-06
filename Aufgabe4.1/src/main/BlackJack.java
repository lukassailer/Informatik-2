package main;

import java.util.Scanner;

public class BlackJack
{

	public static void main(String[] args)
	{
		startGame(1000);
	}

	public static void startGame(int startMoney)
	{
		System.out.println("Welcome to BlackJack");
		int currentBalance = startMoney;
		do
		{
			int cardValuePlayer = 0;
			int cardValueBank = 0;
			System.out.println("Kontostand:" + currentBalance);
			System.out.println("Geben Sie einen Betrag ein, welchen Sie setzen wollen:");
			Scanner s = new Scanner(System.in);
			int bet = s.nextInt();
			if (0 <= validBetPlayer(currentBalance, bet))
			{
				currentBalance -= bet;
				int temp = giveCard();
				System.out.println("Karte:" + temp);
				cardValuePlayer += temp;

				while (cardValuePlayer < 21 && oneMoreCard())
				{
					temp = giveCard();
					cardValuePlayer += temp;
					System.out.println("Karte:" + temp);
					System.out.println("Hand:" + cardValuePlayer);

				}
				while (cardValueBank < cardValuePlayer)
				{
					cardValueBank += giveCard();
				}
				// System.out.println("Bank:" + cardValueBank);
				String winner = evaluateWinner(cardValuePlayer, cardValueBank);
				System.out.println(winner + " gewinnt");
				currentBalance = updateMoney(currentBalance, bet, winner);
			}
		}
		while (currentBalance > 0);
		System.out.println("Das Spiel ist vorbei!");
	}

// alles public wegen den Tests
	public static String evaluateWinner(int cardValuePlayer, int cardValueBank)
	{
		if ((((cardValuePlayer > cardValueBank) || (cardValueBank > 21)) && (cardValuePlayer <= 21))
				|| (cardValuePlayer == 21))
		{
			return "player";
		}
		else if (((cardValuePlayer < cardValueBank) && (cardValueBank <= 21)) || (cardValuePlayer > 21))
		{
			return "bank";
		}
		return "both";
	}

	public static int updateMoney(int currentBalance, int bet, String winner)
	{
		if (winner.equals("player"))
		{
			return currentBalance += bet * 2;
		}
		else if (winner.equals("bank"))
		{
			return currentBalance;
		}
		return currentBalance += bet;
	}

	public static int validBetPlayer(int currentBalance, int bet)
	{

		if ((bet > currentBalance) || (bet == 0))
		{
			return -1;
		}
		return bet;
	}

	public static int giveCard()
	{
		return (int) (Math.random() * 11) + 1;
	}

	public static boolean oneMoreCard()
	{
		System.out.println("Wollen Sie noch eine Karte ziehen? (y/n)");
		Scanner s = new Scanner(System.in);
		return (s.hasNext("y"));
	}
}
