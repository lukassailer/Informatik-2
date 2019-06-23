package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Food objects are very simple and do not implement much functionality. The
 * foods value is determined randomly (with a maximum defined in the game) and
 * defines the color.
 */
public class Food extends LinkEntity
{
	private int value;

	public Food(int _x, int _y)
	{
		super(_x, _y);
		value = (int) (Math.random() * SnakeGame.maxFoodValue) + 1;
		if (value < 0.8 * SnakeGame.maxFoodValue)
			col = SnakeGame.foodBasic;
		else if (value == SnakeGame.maxFoodValue)
			col = SnakeGame.foodUltra;
		else
			col = SnakeGame.foodSuper;
	}

	public int getValue()
	{
		return value;
	}
}
