package org.gobang.bean;

import org.gobang.Utils.BoardUtils;

public class Board
{
	public static int[][] board = new int[15][15]; 
	public static boolean AIFirstSet ;
	public static String[] color = new String[3]; 
	public static void init()
	{
		for(int i = 0; i<15; i++)
			for(int j = 0; j<15; j++)
			{
				board[i][j] = 0;
			}
		AIFirstSet = false;
		color[2] = "Black";
		color[1] = "White";
	}
	
	public static boolean checkBoard(int type ,int x, int y) 
	{
		if(BoardUtils.continuousNum(type, x, y)==5)
		return true;
		else 
		return false;
	}
	
	public static int boardValue() 
	{
		int AIValue = 0;
		int playerValue = 0;
		for(int i = 0; i<15; i++)
			for(int j = 0; j<15; j++)
			{
				if(board[i][j] == 1) AIValue += BoardUtils.pointValue(1, i, j);
				if(board[i][j] == 2) playerValue += BoardUtils.pointValue(2, i, j);
			}
		return (AIValue - playerValue);
	}
	
}
