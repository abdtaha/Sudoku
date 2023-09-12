package inl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class SudokoTest {
	Sudoku s;
	String st;
	
	@Before
	void setUp() throws Exception {
	s=	new Sudoku();
		s.setCell(0, 2, 8);
		s.setCell(0, 5, 9);
		s.setCell(0, 7, 6);
		s.setCell(0, 8, 2);
		s.setCell(1, 8, 5);
		s.setCell(2, 0, 1);
		s.setCell(2, 2, 2);
		s.setCell(2, 3, 5);
		s.setCell(3, 3, 2);
		s.setCell(3, 4, 1);
		s.setCell(3, 7, 9);
		s.setCell(4, 1, 5);
		s.setCell(4, 6, 6);
		s.setCell(5, 0, 6);
		s.setCell(5, 7, 2);
		s.setCell(5, 8, 8);
		s.setCell(6, 0, 4);
		s.setCell(6, 1, 1);
		s.setCell(6, 3, 6);
		s.setCell(6, 5, 8);
		s.setCell(7, 0, 8);
		s.setCell(7, 1, 6);
		s.setCell(7, 4, 3);
		s.setCell(7, 6, 1);
		s.setCell(8, 6, 4);
	}

	@After
	void tearDown() throws Exception {
		s = null;
		
	}

	@Test
	public final void testToString() {
		s=new Sudoku();
		s.setCell(0, 2, 8);
		s.setCell(0, 5, 9);
		s.setCell(0, 7, 6);
		s.setCell(0, 8, 2);
		s.setCell(1, 8, 5);
		s.setCell(2, 0, 1);
		s.setCell(2, 2, 2);
		s.setCell(2, 3, 5);
		s.setCell(3, 3, 2);
		s.setCell(3, 4, 1);
		s.setCell(3, 7, 9);
		s.setCell(4, 1, 5);
		s.setCell(4, 6, 6);
		s.setCell(5, 0, 6);
		s.setCell(5, 7, 2);
		s.setCell(5, 8, 8);
		s.setCell(6, 0, 4);
		s.setCell(6, 1, 1);
		s.setCell(6, 3, 6);
		s.setCell(6, 5, 8);
		s.setCell(7, 0, 8);
		s.setCell(7, 1, 6);
		s.setCell(7, 4, 3);
		s.setCell(7, 6, 1);
		s.setCell(8, 6, 4);
		s.solve();
		System.out.println(s.toString());
		
	}
	@Test
	public final void testNonSolvable() {
		s=new Sudoku();
		s.setCell(0, 0, 1);
		s.setCell(0, 1, 2);
		s.setCell(0, 2, 3);
		s.setCell(1, 0, 4);
		s.setCell(1, 1, 5);
		s.setCell(1, 2, 6);
		s.setCell(2, 3, 7);
		assertFalse("Can't solve unsolvable sudoku",s.solve());
	}
	@Test
	public final void testSolveEmptySudoku() {
		Sudoku su = new Sudoku();
		assertTrue("Empty sudoku is always solvable", su.solve());
	}
	@Test
	public void solveSudokuFig1() {
	
		 s = new Sudoku();
		 s.setCell(0, 2, 8);
			s.setCell(0, 5, 9);
			s.setCell(0, 7, 6);
			s.setCell(0, 8, 2);
			s.setCell(1, 8, 5);
			s.setCell(2, 0, 1);
			s.setCell(2, 2, 2);
			s.setCell(2, 3, 5);
			s.setCell(3, 3, 2);
			s.setCell(3, 4, 1);
			s.setCell(3, 7, 9);
			s.setCell(4, 1, 5);
			s.setCell(4, 6, 6);
			s.setCell(5, 0, 6);
			s.setCell(5, 7, 2);
			s.setCell(5, 8, 8);
			s.setCell(6, 0, 4);
			s.setCell(6, 1, 1);
			s.setCell(6, 3, 6);
			s.setCell(6, 5, 8);
			s.setCell(7, 0, 8);
			s.setCell(7, 1, 6);
			s.setCell(7, 4, 3);
			s.setCell(7, 6, 1);
			s.setCell(8, 6, 4);
		s.solve();
		s.toString();
	}
}
