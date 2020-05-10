package domainTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import domain.Sudoku;
import domain.SudokuSolver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pewlahde
 */
public class SudokuTest {

    Sudoku sudoku;
    SudokuSolver solver;
    int[][] testGrid;
    int[][] solvable;
    int[][] solved;
    int[][] hardGrid;

    public SudokuTest() {
        int[][] hard = {
            {0, 1, 8, 7, 2, 5, 6, 9, 4},
            {4, 7, 9, 6, 8, 1, 2, 5, 3},
            {2, 6, 5, 3, 4, 9, 8, 7, 1},
            {7, 5, 6, 8, 3, 2, 1, 4, 9},
            {9, 8, 2, 5, 1, 4, 3, 6, 7},
            {1, 4, 3, 9, 6, 7, 5, 8, 2},
            {5, 3, 7, 1, 9, 8, 4, 2, 6},
            {6, 9, 4, 2, 5, 3, 7, 1, 8},
            {8, 2, 1, 4, 7, 6, 9, 3, 5}
        };
        hardGrid = hard;

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sudoku = new Sudoku();
        solver = new SudokuSolver();
        testGrid = new int[9][9];
        int[][] solvableGrid = {
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
        int[][] solvedGrid = {
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
        solvable = solvableGrid;
        solved = solvedGrid;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void construtorTest() {
        assertArrayEquals(testGrid, sudoku.getGrid());
    }

    @Test
    public void getGridTest() {
        assertArrayEquals(testGrid, sudoku.getGrid());
    }

    @Test
    public void setGridTest() {
        sudoku.setGrid(testGrid);
        assertArrayEquals(testGrid, sudoku.getGrid());
    }

    @Test
    public void getSolvedGridTest() {
        assertArrayEquals(testGrid, sudoku.getSolvedGrid());
    }

    @Test
    public void setNumberWorks() {
        sudoku.setNumber(1, 2, 3);
        assertEquals(3, sudoku.getGrid()[2][1]);
    }

    @Test
    public void getNumberWorks() {
        sudoku.setNumber(1, 2, 3);
        assertEquals(3, sudoku.getNumeber(1, 2));
    }

    @Test
    public void clearGridTest() {
        sudoku.setNumber(1, 2, 3);
        sudoku.clearGrid();
        Assert.assertArrayEquals(testGrid, sudoku.getGrid());
    }

    @Test
    public void gridIsNotFullTest() {
        assertEquals(false, sudoku.isGridFull(sudoku.getGrid()));
    }

    @Test
    public void gridIsFullTest() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku.setNumber(i, j, 1);
            }
        }
        assertEquals(true, sudoku.isGridFull(sudoku.getGrid()));
    }

    
    @Test
    public void isSolutionCorrectFalse() {
        sudoku.setGrid(hardGrid);
        sudoku.setNumber(0, 0, 1);
        assertEquals(false, sudoku.isSolutionCorrect(sudoku.getGrid()));
    }

     
    @Test
    public void stringToGridTest() {
        sudoku.stringToGrid("500900060000000000100406080000070006000000090010002004604000239072005000930000007");
        Assert.assertArrayEquals(sudoku.getGrid(), solvable);
    }

    @Test
    public void setGridFromDatabaseTest() {
        sudoku.setGridFromDatabase("hard");
        Assert.assertArrayEquals(hardGrid, sudoku.getGrid());
    }
}
