package com.doma.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.doma.view.MainFrame;

public class Controller implements ActionListener
{
	private MainFrame gui;

	public Controller()
	{
		gui = new MainFrame();
		addListeners();
		gui.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == gui.getMainPanel().getHungry())
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					gui.getMainPanel().getPoc().getPanels().get(10).setVisible(true);
					gui.getMainPanel().getHungry().setEnabled(false);
					gui.getMainPanel().getHungry().setVisible(false);
				}
			});
			gui.getMainPanel().getPoc().spin();
			gui.getMainPanel().getHungry().setEnabled(true);
			gui.getMainPanel().getHungry().setVisible(true);
		}
		else
			if (e.getSource() == gui.getMainPanel().getPoc().getRetry())
			{
				gui.dispose();
				gui = new MainFrame();
				addListeners();
				gui.setVisible(true);
			}
			else
			{
				try
				{
					Desktop.getDesktop().browse(new URL(gui.getMainPanel().getPoc().getDescriptions()
							.get(gui.getMainPanel().getPoc().getPanels().get(5).getId())[0]).toURI());
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
	}

	private void addListeners()
	{
		gui.getMainPanel().getHungry().addActionListener(this);
		gui.getMainPanel().getPoc().getRetry().addActionListener(this);
		gui.getMainPanel().getPoc().getMenu().addActionListener(this);
	}

	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			new Controller();
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
	}
}