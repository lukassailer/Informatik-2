package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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

	public Snake(int _x, int _y, int _lives, int _startLength)
	{
		super(_x, _y);

		alive = true;
		lives = _lives;
		wait = 0;

		dir = SnakeGame.initialSnakeDir;
		col = SnakeGame.snakeHead;

		extend(_startLength - 1);
	}

	private Snake(Vector _pos, Vector _dir, int n)
	{
		super(_pos.x, _pos.y);

		alive = true;
		wait = n;

		dir = _dir;
		col = SnakeGame.snakeBody;
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

	private boolean eat(Food food)
	{
		if (getPos().x == food.getPos().x && getPos().y == food.getPos().y)
		{
			if (food.getValue() == SnakeGame.maxFoodValue)
			{
				lives++;
			}
			extend(food.getValue());
			return true;
		}
		return false;
	}

	public boolean move(Food food, Barrier barrier)
	{
		move();

		int tempx = getPos().x;
		int tempy = getPos().y;

		if (barrier.isOccupied(tempx, tempy))
			this.lives = 0;
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
