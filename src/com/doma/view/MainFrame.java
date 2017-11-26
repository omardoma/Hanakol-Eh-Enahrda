package com.doma.view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	private MainPanel mainPanel;

	public MainFrame()
	{
		super("Hanakol Eh Enahrda?");
		prepareFrame();
	}

	public MainPanel getMainPanel()
	{
		return mainPanel;
	}

	private void prepareFrame()
	{
		setMinimumSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("res/Images/icon.png")).getImage());
		getContentPane().setLayout(new CardLayout());
		mainPanel = new MainPanel();
		getContentPane().add(mainPanel, "main");
	}
}