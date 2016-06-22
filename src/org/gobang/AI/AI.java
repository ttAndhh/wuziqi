package org.gobang.AI;

import org.gobang.UI.BoardUI;
import org.gobang.Utils.BoardUtils;
import org.gobang.bean.Board;

public class AI
{
	private static int[] location = new int[2];     
	public static int[] move()
	{	
		maxMin(1,2,-90000000,90000000);
		return location;
	}
	
	
	private static int maxMin(int layer, int forcast, int alpha, int beta)
	{
		if(layer == forcast+1) 
		{
			return Board.boardValue();
		}
		else if(layer%2 ==1)                                          
		{
			int value = 0;
			int maxValue = -90000000;
			for(int i = 0; i<15; i++)
				for(int j = 0; j<15; j++)
				{
					if(Board.board[i][j] == 0)
					{
						Board.board[i][j] = 1;
						if(BoardUtils.continuousNum(1, i, j) == 5)
						{
							if(layer == 1)
							{
								location[0] = i;
								location[1] = j;
								Board.board[i][j] = 0;
								return 90000000;
							}
							else 
							{
								Board.board[i][j] = 0;
								return beta;
							}
						}
						value = maxMin(layer+1,forcast,maxValue,beta);
						if(value > beta)
						{
							Board.board[i][j] = 0;
							return beta;
						}
						if( value> maxValue)
						{
							maxValue = value;
							if(layer == 1)
							{
								location[0] = i;
								location[1] = j;
							}		
						}
						Board.board[i][j] = 0;
					}
				}
			return maxValue;
		}
		else                                                          
		{
			int value;
			int minValue = 90000000;
			for(int i = 0; i<15; i++)
				for(int j = 0; j<15; j++)
				{
					if(Board.board[i][j] == 0)
					{
						Board.board[i][j] = 2;
						if(BoardUtils.continuousNum(2, i, j) == 5)
						{
							Board.board[i][j] = 0;
							return alpha;
						}
						value = maxMin(layer+1,forcast,alpha,minValue);
						if(value < alpha)
						{
							Board.board[i][j] = 0;
							return alpha;
						}
						
						if( value < minValue)
						{
							minValue = value;
						}
						Board.board[i][j] = 0;
					}
				}
			return minValue;
		}
	}
	
}
