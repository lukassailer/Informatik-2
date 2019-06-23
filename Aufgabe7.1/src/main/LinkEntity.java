package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

abstract public class LinkEntity
{
	protected Color col;
	private Vector pos;
	protected LinkEntity next;

	public LinkEntity(int _x, int _y)
	{
		pos = new Vector(_x, _y);
		setNext(this);
	}

	public int getLength()
	{
		if (!isLast())
		{
			return 1 + next.getLength();
		}
		return 1;
	}

	public Vector getPos()
	{
		return pos;
	}

	public LinkEntity setNext(LinkEntity _next)
	{
		next = _next;
		return next;
	}

	public LinkEntity getNext()
	{
		return next;
	}

	public boolean isLast()
	{
		return next == this;
	}

	public boolean isOccupied(int x, int y)
	{
		if (!isLast())
			return ((pos.x == x) && (pos.y == y)) || next.isOccupied(x, y);
		else
			return ((pos.x == x) && (pos.y == y));
	}

	public void draw(Graphics2D g, Rectangle snakeArea, int tileSize)
	{
		g.setColor(col);
		g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
		if (!isLast())
		{
			next.draw(g, snakeArea, tileSize);
		}
	}
}
