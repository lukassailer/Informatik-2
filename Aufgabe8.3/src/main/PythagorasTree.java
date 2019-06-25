package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PythagorasTree
{
	public static void drawRotatedRect(Graphics2D g, Vector pos, Vector up, int a, int height)
	{
		g.setColor(new Color(255 - a, 0, a));
		Vector upLeft = pos.added(up.scaled(a / 2)).added(up.scaled(a / 2).rotated(Math.PI / 2));
		Vector upRight = upLeft.added(up.scaled(a).rotated(-Math.PI / 2));
		Vector bottomRight = upRight.added(up.scaled(a).rotated(Math.PI));
		Vector bottomLeft = bottomRight.added(up.scaled(a).rotated(Math.PI / 2));
		int xA[] =
		{ (int) upLeft.x, (int) upRight.x, (int) bottomRight.x, (int) bottomLeft.x };
		int yA[] =
		{ height - (int) upLeft.y, height - (int) upRight.y, height - (int) bottomRight.y,
				height - (int) bottomLeft.y };
		g.fillPolygon(xA, yA, 4);
	}

	public static void drawSegment(Graphics2D g, Vector pos, Vector up, int a, int height)
	{
		if (a >= 2)
		{
			drawRotatedRect(g, pos, up, a, height);
			drawSegment(g, pos.added(up.scaled(a)).added(up.rotated(Math.PI / 2).scaled(a / 2)),
					up.rotated(Math.PI / 4), (int) (a / Math.sqrt(2)), height);
			drawSegment(g, pos.added(up.scaled(a)).added(up.rotated(Math.PI / 2).scaled(-a / 2)),
					up.rotated(-Math.PI / 4), (int) (a / Math.sqrt(2)), height);
		}
	}

	// Create the Pythagoras-Tree image and save it as PNG file.
	public static void createPythagorasTreeImage(int startSize) throws IOException
	{
		// Creation of the image object
		int height = 5 * startSize;
		int width = 8 * startSize;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Create a Graphics2D object from the image and set a white background
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, width, height);

		// Initial position and orientation of the first segment
		Vector startPos = new Vector(width / 2, startSize);
		Vector up = new Vector(0, 1);

		// Start the recursion.
		drawSegment(g, startPos, up, startSize, height);

		// Save the image as PNG
		String OS = System.getProperty("os.name").toLowerCase(); // different for win and unix
		String filePath = System.getProperty("user.dir") + (OS.indexOf("win") >= 0 ? "\\" : "/") + "pythagorasTree.png";
		System.out.println("Writing pythagoras-tree image to: " + filePath);
		ImageIO.write(image, "png", new File(filePath));
	}

	public static void main(String[] args) throws IOException
	{

		createPythagorasTreeImage(255);

	}
}
