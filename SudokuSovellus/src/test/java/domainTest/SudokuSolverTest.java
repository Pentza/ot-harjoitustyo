package domainTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import domain.SudokuSolver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pewlahde
 */
public class SudokuSolverTest {

    SudokuSolver solver;
    int[][] board;
    int[][] solvableGrid;
    int[][] solvedGrid;

    public SudokuSolverTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        solver = new SudokuSolver();
        int[][] sudoku = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        board = sudoku;
        int[][] solvable = {
            {5, 0, 0, 9, 0, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 4, 0, 6, 0, 8, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 1, 0, 0, 0, 2, 0, 0, 4},
            {6, 0, 4, 0, 0, 0, 2, 3, 9},
            {0, 7, 2, 0, 0, 5, 0, 0, 0},
            {9, 3, 0, 0, 0, 0, 0, 0, 7}
        };
        int[][] solved = {
            {5, 2, 8, 9, 1, 7, 4, 6, 3},
            {7, 4, 6, 2, 3, 8, 9, 1, 5},
            {1, 9, 3, 4, 5, 6, 7, 8, 2},
            {4, 8, 5, 1, 7, 9, 3, 2, 6},
            {2, 6, 7, 5, 4, 3, 1, 9, 8},
            {3, 1, 9, 8, 6, 2, 5, 7, 4},
            {6, 5, 4, 7, 8, 1, 2, 3, 9},
            {8, 7, 2, 3, 9, 5, 6, 4, 1},
            {9, 3, 1, 6, 2, 4, 8, 5, 7}
        };
        solvableGrid = solvable;
        solvedGrid = solved;

    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkRowTrue() {
        assertEquals(true, solver.checkRow(board, 0, 7));
    }

    @Test
    public void checkRowFalse() {
        assertEquals(false, solver.checkRow(board, 0, 8));
    }

    @Test
    public void checkColumnTrue() {
        assertEquals(true, solver.checkColumn(board, 0, 7));
    }

    @Test
    public void checkColumnFalse() {
        assertEquals(false, solver.checkColumn(board, 0, 8));
    }

    @Test
    public void checkSubsectionTrue() {
        assertEquals(true, solver.checkSubsection(board, 0, 0, 5));
    }

    @Test
    public void checkSubsectionFalse() {
        assertEquals(false, solver.checkSubsection(board, 0, 0, 8));
    }

    @Test
    public void solveTrueTest() {
        assertEquals(true, solver.solve(solvableGrid));
    }

    @Test
    public void solveFalseTest() {
        solvableGrid[0][1] = 8;
        assertEquals(false, solver.solve(solvableGrid));
    }

    @Test
    public void containsZerosTest() {
        assertEquals(true, solver.boardContainsZeros(solvableGrid));
    }

    @Test
    public void doesntContainZerosTest() {
        assertEquals(false, solver.boardContainsZeros(solvedGrid));
    }
}
