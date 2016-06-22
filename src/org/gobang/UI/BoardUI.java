package org.gobang.UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.gobang.AI.AI;
import org.gobang.bean.Board;
public class BoardUI extends JFrame
{
	private JPanel jpanel1 = new JPanel();
	private JPanel jpanel2 = new JPanel();
	private JPanel jpanel3 = new JPanel();
	private JPanel jpanel4 = new JPanel();
	private BoardPanel jpanelBoard = new BoardPanel();	
	private JButton jb1 = new JButton("重新开始");
	private JButton jb2 = new JButton("电脑先手");
	private JButton jb3 = new JButton("玩家先手");
	
	public BoardUI()
	{
		jpanel1.add(jb1);
		jpanel1.add(jb2);
		jpanel1.add(jb3);
		jpanel1.setSize(520, 100);
		jpanel2.setSize(50, 420);
		jpanel3.setSize(50, 420);
		jpanel4.setSize(520, 100);
		jpanelBoard.setSize(420, 420);
		jpanelBoard.setBorder(new LineBorder(Color.BLACK,2));
		
		jpanelBoard.setBackground(new Color(215,161,101));
		
	
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Board.init();
				jpanelBoard.paintBoard();
			}
		});
		
		
		jb2.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Board.init();
				Board.color[1] = "Black";
				Board.color[2] = "White";
				Board.board[7][7] = 1;			
				Board.AIFirstSet = true;
				jpanelBoard.paintBoard();            
			}
		});
		
	
		jb3.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Board.init();
				Board.color[1] = "White";
				Board.color[2] = "Black";
				jpanelBoard.paintBoard();
			}
		});
		
		
		jpanelBoard.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				x+=10;
				y+=10;
				x/=30;
				y/=30;
				if(x>=1 && x<=15 && y>=1 &&y<=15 && Board.board[x-1][y-1] == 0)
				{
					
					Board.board[x-1][y-1] = 2;
					jpanelBoard.paintBoard();
					if(Board.checkBoard(2, x-1, y-1)) 
					{
						JOptionPane.showMessageDialog(null, "You Win");
						Board.init();
						jpanelBoard.paintBoard();
					}
					
				
					if(!Board.AIFirstSet)
					{
						x--;
						y--;
						Board.AIFirstSet = true;
						int[] location = new int[2];
						int maxValue = -90000000;
						int value;
						if(x+1<15)
						{
							value = Board.boardValue();
							if(value >maxValue)
							{
								maxValue = value;
								location[0] = x+1;
								location[1] = y;
							}
						}
						if(x-1>=0)
						{
							value = Board.boardValue();
							if(value >maxValue)
							{
								maxValue = value;
								location[0] = x-1;
								location[1] = y;
							}
						}
						if(y+1<15)
						{
							value = Board.boardValue();
							if(value >maxValue)
							{
								maxValue = value;
								location[0] = x;
								location[1] = y+1;
							}
						}
						if(y-1>=0)
						{
							value = Board.boardValue();
							if(value >maxValue)
							{
								maxValue = value;
								location[0] = x;
								location[1] = y-1;
							}
						}
						Board.board[location[0]][location[1]] = 1;
						jpanelBoard.paintBoard();
					}
					else
					{
						int[] location = new int[2];
						location = AI.move();
						Board.board[location[0]][location[1]] = 1;
						jpanelBoard.paintBoard();
						if(Board.checkBoard(1, location[0], location[1])) 
						{
							JOptionPane.showMessageDialog(null, "You Lose");
							Board.init();
							jpanelBoard.paintBoard();
						}
					}
				}
			}
		});
		
		add(jpanel1,BorderLayout.NORTH);
		add(jpanel2,BorderLayout.EAST);
		add(jpanel3,BorderLayout.WEST);
		add(jpanel4,BorderLayout.SOUTH);
		add(jpanelBoard,BorderLayout.CENTER);	
	}
	
	public static void main(String[] args)
	{
		Board.init();
		BoardUI f = new BoardUI();
		f.setSize(510, 560);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
}
