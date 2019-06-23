package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		value = (int) (Math.random() * (SnakeGame.maxFoodValue)) + 1;
		if (value < 0.8 * SnakeGame.maxFoodValue)
		{
			//foodBasic;
			try
			{
				img = ImageIO.read(new File("./src/textures/foodMouse.png"));
			}
			catch (IOException e)
			{
				System.out.println("keine Textur");
			}
		}
		else if (value == SnakeGame.maxFoodValue)
		{
			//foodUltra;
			try
			{
				img = ImageIO.read(new File("./src/textures/foodPizza.png"));
			}
			catch (IOException e)
			{
				System.out.println("keine Textur");
			}
		}
		else
		{
			//foodSuper;
			try
			{
				img = ImageIO.read(new File("./src/textures/foodElephant.png"));
			}
			catch (IOException e)
			{
				System.out.println("keine Textur");
			}
		}

	}

	public int getValue()
	{
		return value;
	}
}
