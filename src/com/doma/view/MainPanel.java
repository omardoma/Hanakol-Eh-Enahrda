package com.doma.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	private JPanel antiResize;
	private JPanel tmp;
	private PanelsOnCircle poc;
	private JButton hungry;

	public MainPanel()
	{
		super(new BorderLayout());
		preparePanel();
	}

	public JPanel getAntiResize()
	{
		return antiResize;
	}

	public JPanel getTmp()
	{
		return tmp;
	}

	public PanelsOnCircle getPoc()
	{
		return poc;
	}

	public JButton getHungry()
	{
		return hungry;
	}

	private void preparePanel()
	{
		setBackground(Color.WHITE);
		tmp = new JPanel();
		tmp.setPreferredSize(new Dimension(40, 0));
		tmp.setOpaque(false);
		add(tmp, BorderLayout.WEST);
		poc = new PanelsOnCircle();
		add(poc, BorderLayout.CENTER);
		hungry = new IconButton("Let's Do It", "res/Button/button.png", 100, 30);
		antiResize = new JPanel();
		antiResize.setBackground(Color.WHITE);
		antiResize.add(hungry);
		add(antiResize, BorderLayout.SOUTH);
	}
}