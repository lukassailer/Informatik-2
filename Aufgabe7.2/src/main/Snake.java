package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The snake has two constructors, the first one (public) is for the head only,
 * the other one for the rest of the body (private). As the snake moves, it can
 * eat and extend its length, run into itself and lose length or run into a
 * barrier and die.
 */
public class Snake extends LinkEntity
{
	private boolean alive;
	private int lives;
	private int wait;
	private Vector dir;
	protected boolean rainbowMode;
	protected boolean doubleMode;

	public Snake(int _x, int _y, int _lives, int _startLength)
	{
		super(_x, _y);

		alive = true;
		lives = _lives;
		wait = 0;

		dir = SnakeGame.initialSnakeDir;

		extend(_startLength - 1);

		try
		{
			img = ImageIO.read(new File("./src/textures/snakeHeadUp.png"));
		}
		catch (IOException e)
		{
			System.out.println("keine Textur");
		}
	}

	private Snake(Vector _pos, Vector _dir, int n)
	{
		super(_pos.x, _pos.y);

		alive = true;
		wait = n;

		dir = _dir;

		try
		{
			img = ImageIO.read(new File("./src/textures/snakeBody0.png"));
		}
		catch (IOException e)
		{
			System.out.println("keine Textur");
		}
	}

	public void changeDirection(Vector newDir)
	{
		if (!isLast())
			((Snake) next).changeDirection(dir);
		dir = newDir;
	}

	public boolean isAlive()
	{
		alive = lives > 0;
		return alive;
	}

	public int getLives()
	{
		return lives;
	}

	private void extend(int n)
	{
		if (n != 0)
		{
			if (!isLast())
				((Snake) next).extend(n);
			else
			{
				setNext(new Snake(getPos(), dir, this.wait + 1));
				n--;
				((Snake) next).extend(n);
			}
		}
	}

	public void rainbowTexture()
	{
		try
		{
			int random = (int) (Math.random() * 3);
			switch (random)
			{
			case 0:
				img = ImageIO.read(new File("./src/textures/snakeBody1.png"));
				break;
			case 1:
				img = ImageIO.read(new File("./src/textures/snakeBody2.png"));
				break;
			case 2:
				img = ImageIO.read(new File("./src/textures/snakeBody3.png"));
			}
		}
		catch (IOException e)
		{
			System.out.println("keine Textur");
		}
		if (!isLast())
			((Snake) next).rainbowTexture();
	}

	public void regularTexture()
	{
		try
		{
			img = ImageIO.read(new File("./src/textures/snakeBody0.png"));
		}
		catch (IOException e)
		{
			System.out.println("keine Textur");
		}
		if (!isLast())
			((Snake) next).regularTexture();
	}

	private boolean eat(Food food)
	{
		if (getPos().x == food.getPos().x && getPos().y == food.getPos().y)
		{
			if (food.getValue() == SnakeGame.maxFoodValue)
			{
				lives++;
			}
			if (doubleMode)
				extend(food.getValue() * 2);
			else
				extend(food.getValue());
			return true;
		}
		return false;
	}

	public boolean move(Food food, Barrier barrier)
	{
		move();

		if (!isLast())
			if (rainbowMode)
				((Snake) next).rainbowTexture();

		int tempx = getPos().x;
		int tempy = getPos().y;

		if (barrier.isOccupied(tempx, tempy))
		{
			if (rainbowMode)
			{
				//
			}
			else
				this.lives = 0;
		}
		if (selfCollision(getPos()))
			lives--;
		return eat(food);
	}

	private void move()
	{
		if (wait > 0)
		{
			wait -= 1;
		}
		else
		{
			getPos().x += dir.x;
			getPos().y += dir.y;
		}

		if (!isLast())
		{
			((Snake) next).move();
		}

	}

	private boolean selfCollision(Vector headPos)
	{
		if (rainbowMode)
		{
			return false;
		}
		else
		{
			if (this.isLast())
				return false;
			if (next.getPos().x == headPos.x && next.getPos().y == headPos.y)
			{
				this.setNext(this);
				return true;
			}
			return ((Snake) next).selfCollision(headPos);
		}
	}
}
