package com.doma.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class IconButton extends JButton
{
	public IconButton(String text, String imageURL, int width, int height)
	{
		super(text);
		setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(imageURL)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		setFocusPainted(false);
		setBorderPainted(false);
		setHorizontalTextPosition(JButton.CENTER);
		setContentAreaFilled(false);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setForeground(Color.WHITE);
	}
}