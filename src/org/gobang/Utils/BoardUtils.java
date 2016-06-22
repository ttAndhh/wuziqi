package org.gobang.Utils;

import org.gobang.bean.*;

public class BoardUtils
{
	public static int continuousNum(int type,int x,int y)   
	{
		int maxNum = 0;
		int num ;
	
		num = 1;
		for(int i = y+1; i<15; i++)
		{
			if(Board.board[x][i] == type) num++;
			else break;
		}
		for(int i = y-1; i>=0; i--)
		{
			if(Board.board[x][i] == type) num++;
			else break;
		}
		if(num >maxNum)
		maxNum = num;
		
		num = 1;
		for(int i = x+1; i<15; i++)
		{
			if(Board.board[i][y] == type) num++;
			else break;
		}
		for(int i = x-1; i>=0; i--)
		{
			if(Board.board[i][y] == type) num++;
			else break;
		}
		if(num >maxNum)
			maxNum = num;
	
		num = 1;
		for(int i = x+1,j = y+1; i<15&&j<15; i++,j++)
		{
			if(Board.board[i][j] == type) num++;
			else break;
		}
		for(int i = x-1,j = y-1; i>=0&&j>=0; i--,j--)
		{
			if(Board.board[i][j] == type) num++;
			else break;
		}
		if(num >maxNum)
			maxNum = num;
			
		num = 1;
		for(int i = x+1,j = y-1; i<15&&j>=0; i++,j--)
		{
			if(Board.board[i][j] == type) num++;
			else break;
		}
		for(int i = x-1,j = y+1; i>=0&&j<15; i--,j++)
		{
			if(Board.board[i][j] == type) num++;
			else break;
		}
		if(num >maxNum)
			maxNum = num;
		
		return maxNum;
	}
	
	public static int pointValue(int type,int x,int y)  
	{
		int[] assumeValue = {0,10,100,1000,10000,100000,1,10,100,1000,100000};
		int value = 0;
		int block;
		int num;
	
		block = 2;
		num = 1;
		for(int i = y+1; i<15; i++)
		{
			if(Board.board[x][i] == type) num++;
			else if(Board.board[x][i] == 0)
			{
				block--;
				break;
			}
			else break;
		}
		for(int i = y-1; i>=0; i--)
		{
			if(Board.board[x][i] == type) num++;
			else if(Board.board[x][i] == 0)
			{
				block--;
				break;
			}
			else break;
		}
		if(block == 0)
		value += assumeValue[num];
		if(block == 1)
		value += assumeValue[5+num];
		if(block == 2 && num ==5)
		value += assumeValue[num];
	
		block = 2;
		num = 1;
		for(int i = x+1; i<15; i++)
		{
			if(Board.board[i][y] == type) num++;
			else if(Board.board[i][y] == 0)
			{
				block--;
				break;
			}
			else break;
		}
		for(int i = x-1; i>=0; i--)
		{
			if(Board.board[i][y] == type) num++;
			else if(Board.board[i][y] == 0)
			{
				 block--;
				 break;
			}
			else break;
		}
		if(block == 0)
		value += assumeValue[num];
		if(block == 1)
		value += assumeValue[5+num];
		if(block == 2 && num ==5)
		value += assumeValue[num];
	
		block = 2;
		num = 1;
		for(int i = x+1,j = y+1; i<15&&j<15; i++,j++)
		{
			if(Board.board[i][j] == type) num++;
			else if(Board.board[i][j] == 0)
			{
				block--;
				break;
			}
			else break;
		}
		for(int i = x-1,j = y-1; i>=0&&j>=0; i--,j--)
		{
			if(Board.board[i][j] == type) num++;
			else if(Board.board[i][j] == 0)
			{
				 block--;
				 break;
			}
			else break;
		}
		if(block == 0)
		value += assumeValue[num];
		if(block == 1)
		value += assumeValue[5+num];
		if(block == 2 && num ==5)
		value += assumeValue[num];

		block = 2;
		num = 1;
		for(int i = x+1,j = y-1; i<15&&j>=0; i++,j--)
		{
			if(Board.board[i][j] == type) num++;
			else if(Board.board[i][j] == 0)
			{
				 block--;
				 break;
			}
			else break;
		}
		for(int i = x-1,j = y+1; i>=0&&j<15; i--,j++)
		{
			if(Board.board[i][j] == type) num++;
			else if(Board.board[i][j] == 0)
			{
				 block--;
				 break;
			}
			else break;
		}
		if(block == 0)
		value += assumeValue[num];
		if(block == 1)
		value += assumeValue[5+num];
		if(block == 2 && num ==5)
		value += assumeValue[num];
		
		return value;
	}
}
