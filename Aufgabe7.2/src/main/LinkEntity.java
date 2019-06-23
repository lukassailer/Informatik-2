package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

abstract public class LinkEntity
{
	private Vector pos;
	protected LinkEntity next;
	
	protected BufferedImage img;

	public LinkEntity(int _x, int _y)
	{
		pos = new Vector(_x, _y);
		setNext(this);
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
		g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
		if (!isLast())
		{
			next.draw(g, snakeArea, tileSize);
		}
		g.drawImage(img, null, snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize);
	}
	
	public int getLength()
	{
		if (!isLast())
		{
			return 1 + next.getLength();
		}
		return 1;
	}
}
