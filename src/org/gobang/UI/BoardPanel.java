package org.gobang.UI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.gobang.bean.Board;

public class BoardPanel extends JPanel
{
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		int x1,y1,x2,y2;
		x1 = 30;
		x2 = 450;
		y1 = 30;
		y2 = y1;
		for(; y1<=450; y1+=30)
		{
			y2 = y1;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 30;
		x2 = x1;
		y1 = 30;
		y2 = 450;
		for(; x1<=450; x1+=30)
		{
			x2 = x1;
			g.drawLine(x1, y1, x2, y2);
		}
		
	
		g.fillOval(115, 115, 10, 10);
		g.fillOval(355, 115, 10, 10);
		g.fillOval(115, 355, 10, 10);
		g.fillOval(355, 355, 10, 10);
		g.fillOval(235, 235, 10, 10);
		
		
		int x,y;
		for(int i = 0; i<15; i++)
			for(int j = 0; j<15; j++)
			{
				if(Board.board[i][j] != 0)
				{
					if(Board.color[Board.board[i][j]].equals("Black")) g.setColor(Color.BLACK);
					else g.setColor(Color.WHITE);
					
					x = (i+1)*30 - 10;
					y = (j+1)*30 - 10;
					g.fillOval(x, y, 20, 20);
				}
			}
	}
	
	
	public void paintBoard()
	{
		repaint();
	}
}
