package org.gobang.test;

import org.gobang.AI.AI;
import org.gobang.bean.Board;
import org.junit.Test;

public class AITest
{
	@Test
	public void AItest()
	{
		Board.init();
		
		Board.board[5][3] = 1;
		Board.board[6][3] = 1;
		Board.board[7][3] = 1;
		Board.board[3][4] = 1;
		Board.board[4][4] = 1;
		Board.board[5][4] = 1;
		Board.board[6][4] = 1;
		Board.board[4][5] = 1;
		Board.board[5][5] = 1;
		Board.board[8][5] = 1;
		Board.board[3][6] = 1;
		Board.board[4][6] = 1;
		Board.board[5][6] = 1;
		Board.board[6][6] = 1;
		//Board.board[7][4] = 1;                 //
		Board.board[7][7] = 1;
		Board.board[10][9] = 1;

		
		Board.board[0][0] = 2;
		Board.board[5][2] = 2;
		Board.board[8][2] = 2;
		Board.board[3][3] = 2;
		Board.board[2][4] = 2;
		Board.board[7][4] = 2;
		Board.board[6][5] = 2;
		Board.board[2][6] = 2;
		Board.board[7][6] = 2;
		Board.board[2][7] = 2;
		Board.board[3][7] = 2;
		Board.board[5][7] = 2;
		Board.board[6][7] = 2;
		Board.board[8][7] = 2;
		Board.board[8][8] = 2;
		Board.board[9][8] = 2;
		
		for(int i =0; i<15; i++)
		{
			for(int j = 0; j<15; j++)
			{
				if(Board.board[i][j] == 1) System.out.print("#");
				else if(Board.board[i][j] == 2) System.out.print("@");
				else System.out.print("-");
				System.out.print(" ");
			}
			System.out.println(" ");
			
		}
		
		
		int[] mov = AI.move();
		System.out.println(mov[0]+" "+mov[1]);
	}
}
