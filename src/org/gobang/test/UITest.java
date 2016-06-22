package org.gobang.test;

import org.gobang.UI.BoardUI;
import org.gobang.bean.Board;
import org.junit.Test;

public class UITest
{
	@Test
	public void UI()
	{
		Board.init();
		Board.board[7][7] = 1;
		BoardUI f = new BoardUI();
		f.setSize(449, 499);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
}
