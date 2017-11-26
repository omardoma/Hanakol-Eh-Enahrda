package com.doma.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintedPanel extends JPanel
{
	private BufferedImage image;
	private int id;

	public PaintedPanel()
	{
		super();
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		if (image == null)
		{
			this.image = null;
			return;
		}
		this.image = toCompatibleImage(image);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public BufferedImage toCompatibleImage(final BufferedImage image)
	{
		GraphicsConfiguration gfxConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		if (image.getColorModel().equals(gfxConfig.getColorModel()))
			return image;
		// image is not optimized, so create a new image that is
		final BufferedImage newImage = gfxConfig.createCompatibleImage(image.getWidth(), image.getHeight(),
				image.getTransparency());
		// get the graphics context of the new image to draw the old image on
		final Graphics2D g2d = (Graphics2D) newImage.getGraphics();
		// actually draw the image and dispose of context no longer needed
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return newImage;
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth() - 10, getHeight() - 10, this);
	}
}