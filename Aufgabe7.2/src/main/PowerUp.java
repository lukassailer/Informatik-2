package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PowerUp extends LinkEntity
{
	private int value;

	PowerUp(int _x, int _y)
	{
		super(_x, _y);
		value = (int) (Math.random() * 3); // 0,1,2

		switch (value)
		{
		case 0:
			try
			{
				img = ImageIO.read(new File("./src/textures/snail.png"));
			}
			catch (IOException e)
			{
				System.out.println("keine Textur");
			}
			break;
		case 1:
			try
			{
				img = ImageIO.read(new File("./src/textures/double.png"));
			}
			catch (IOException e)
			{
				System.out.println("keine Textur");
			}
			break;
		case 2:
			try
			{
				img = ImageIO.read(new File("./src/textures/rainbow.png"));
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
