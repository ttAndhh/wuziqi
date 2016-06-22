package org.gobang.test;

import org.gobang.Utils.BoardUtils;
import org.gobang.bean.Board;
import org.junit.Test;

public class UtiltsTest
{	
	@Test
	public void pointValueTest()
	{
		Board.init();
		Board.board[7][7] = 1;
		Board.board[7][8] = 1;
		Board.board[7][9] = 2;
		System.out.println(BoardUtils.pointValue(2, 7, 9));
	}
}
