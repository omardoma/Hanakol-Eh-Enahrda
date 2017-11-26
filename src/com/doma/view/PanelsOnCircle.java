package com.doma.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelsOnCircle extends JPanel
{
	private static final int RADIUS = 160;
	private static final int GAP = 50;
	private static final int PREF_W = 2 * RADIUS + 2 * GAP;
	private static final int PREF_H = PREF_W;
	private static final int SLICES = 10;
	private static final int SIDE = 90;
	private int count;
	private int tmp;
	private Timer t;
	private ArrayList<PaintedPanel> panels;
	private ArrayList<String[]> descriptions;
	private Clip roulette;
	private JPanel panel;
	private IconButton retry;
	private IconButton menu;

	public PanelsOnCircle()
	{
		super(new BorderLayout());
		retry = new IconButton("Retry", "res/Button/button.png", 100, 30);
		menu = new IconButton("Menu", "res/Button/button.png", 100, 30);
		menu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		menu.setBounds(0, 230, 250, 50);
		panels = new ArrayList<PaintedPanel>(SLICES + 1);
		descriptions = new ArrayList<String[]>();
		descriptions.add(0, new String[]
		{ "http://menuegypt.com/Mcdonalds", "19991" });
		descriptions.add(1, new String[]
		{ "http://menuegypt.com/Hardees", "19066" });
		descriptions.add(2, new String[]
		{ "http://menuegypt.com/Kfc", "19019" });
		descriptions.add(3, new String[]
		{ "http://menuegypt.com/Pizza-Hut", "19000" });
		descriptions.add(4, new String[]
		{ "http://menuegypt.com/Papa-Johns", "19277" });
		descriptions.add(5, new String[]
		{ "http://menuegypt.com/Arabiata", "16919" });
		descriptions.add(6, new String[]
		{ "http://menuegypt.com/Khairat-El-Sham", "0226170700" });
		descriptions.add(7, new String[]
		{ "http://menuegypt.com/Tom-and-Basal", "16405" });
		descriptions.add(8, new String[]
		{ "http://menuegypt.com/Cook-Door", "16999" });
		descriptions.add(9, new String[]
		{ "http://menuegypt.com/El-Dahan", "16194" });
		try
		{
			roulette = AudioSystem.getClip();
			roulette.open(AudioSystem
					.getAudioInputStream(getClass().getClassLoader().getResource("res/Sounds/roulette.wav")));
		}
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		preparePanel();
	}

	public IconButton getMenu()
	{
		return menu;
	}

	public int getTmp()
	{
		return tmp;
	}

	public ArrayList<String[]> getDescriptions()
	{
		return descriptions;
	}

	public Clip getRoulette()
	{
		return roulette;
	}

	public JPanel getPanel()
	{
		return panel;
	}

	public IconButton getRetry()
	{
		return retry;
	}

	public Timer getT()
	{
		return t;
	}

	public int getCount()
	{
		return count;
	}

	public ArrayList<PaintedPanel> getPanels()
	{
		return panels;
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(PREF_W, PREF_H);
	}

	private void preparePanel()
	{
		setBackground(Color.WHITE);
		panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		PaintedPanel smallPanel1 = new PaintedPanel();
		PaintedPanel smallPanel2 = new PaintedPanel();
		PaintedPanel smallPanel3 = new PaintedPanel();
		PaintedPanel smallPanel4 = new PaintedPanel();
		PaintedPanel smallPanel5 = new PaintedPanel();
		PaintedPanel smallPanel6 = new PaintedPanel();
		PaintedPanel smallPanel7 = new PaintedPanel();
		PaintedPanel smallPanel8 = new PaintedPanel();
		PaintedPanel smallPanel9 = new PaintedPanel();
		PaintedPanel smallPanel10 = new PaintedPanel();
		panels.add(smallPanel1);
		panels.add(smallPanel2);
		panels.add(smallPanel3);
		panels.add(smallPanel4);
		panels.add(smallPanel5);
		panels.add(smallPanel6);
		panels.add(smallPanel7);
		panels.add(smallPanel8);
		panels.add(smallPanel9);
		panels.add(smallPanel10);

		BufferedImage img;
		try
		{
			PaintedPanel pp = new PaintedPanel();
			img = ImageIO.read(getClass().getClassLoader().getResource("res/Images/arrow.png"));
			pp.setImage(img);
			pp.setOpaque(false);
			pp.setBounds(180, 180, img.getWidth(), img.getHeight());
			panel.add(pp);
			pp.setVisible(false);
			panels.add(10, pp);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		for (int i = 0; i < SLICES; i++)
		{
			String s = "";
			switch (i)
			{
			case 0:
				s = "mc.png";
				break;
			case 1:
				s = "hardees.png";
				break;
			case 2:
				s = "kfc.png";
				break;
			case 3:
				s = "ph.png";
				break;
			case 4:
				s = "ppj.png";
				break;
			case 5:
				s = "arabiata.png";
				break;
			case 6:
				s = "khsham.jpg";
				break;
			case 7:
				s = "tb.jpg";
				break;
			case 8:
				s = "cd.png";
				break;
			case 9:
				s = "dahan.jpg";
				break;
			}

			double phi = (i * Math.PI * 2) / SLICES;
			try
			{
				img = ImageIO.read(getClass().getClassLoader().getResource("res/Images/" + s));
				panels.get(i).setImage(img);
				panels.get(i).setOpaque(false);
				panels.get(i).setId(i);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			int x = (int) (RADIUS * Math.sin(phi) + RADIUS - SIDE / 2) + GAP;
			int y = (int) (RADIUS * Math.cos(phi) + RADIUS - SIDE / 2) + GAP;
			panels.get(i).setBounds(x, y, SIDE, SIDE);
			panel.add(panels.get(i));
			panels.add(smallPanel1);
		}
		add(panel, BorderLayout.CENTER);
	}

	private void animateChosen()
	{
		t = new Timer(10, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (count == 0)
				{
					count = 100;
					t.stop();
					clearTheRest();
					return;
				}
				else
					if (count <= 25)
					{
						panels.get(10).setImage(null);
						repaint();
					}
				panels.get(5).setBounds(panels.get(5).getX(), panels.get(5).getY() + 2, panels.get(5).getWidth(),
						panels.get(5).getHeight());
				panels.get(10).setBounds(panels.get(10).getX(), panels.get(10).getY() - 2, panels.get(10).getWidth(),
						panels.get(10).getHeight());
				repaint();
				count--;
			}
		});
		t.start();
	}

	private void clearTheRest()
	{
		tmp = 9;
		t = new Timer(60, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (count == 0 || tmp < 0)
				{
					t.stop();
					showInfo();
					return;
				}
				if (tmp != 5)
				{
					panels.get(tmp).setImage(null);
					repaint();
				}
				panels.get(5).setBounds(panels.get(5).getX() - 2, panels.get(5).getY() - 2,
						panels.get(5).getWidth() + 4, panels.get(5).getHeight() + 4);
				tmp--;
				count--;
			}
		});
		t.start();
	}

	private void showInfo()
	{
		JPanel tmp = new JPanel();
		tmp.setOpaque(false);
		tmp.add(retry);
		add(tmp, BorderLayout.SOUTH);
		JLabel hotline = new JLabel("Hotline: "+descriptions.get(panels.get(5).getId())[1]);
		hotline.setForeground(Color.RED);
		hotline.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		hotline.setBounds(210, 230, 150, 50);
		panel.add(hotline);
		panel.add(menu);
		repaint();
		revalidate();
	}

	public void spin()
	{
		roulette.setFramePosition(0);
		roulette.start();
		count = new Random().nextInt(30) + 100;
		tmp = 15;
		t = new Timer(tmp, new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (count == 0)
				{
					t.stop();
					roulette.stop();
					count = 47;
					animateChosen();
					return;
				}
				else
					if (count <= 10)
						t.setDelay(tmp += 15);

				for (int j = 0; j < SLICES - 1; j++)
				{
					BufferedImage tmp = panels.get(j).getImage();
					int tmpID = panels.get(j).getId();
					panels.get(j).setImage(panels.get(j + 1).getImage());
					panels.get(j).setId(panels.get(j + 1).getId());
					panels.get(j + 1).setImage(tmp);
					panels.get(j + 1).setId(tmpID);
					repaint();
				}
				count--;
			}
		});
		t.start();
	}
}