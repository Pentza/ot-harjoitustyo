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
    
    public SudokuTest() {
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
    public void countNumbersTest() {
        sudoku.setNumber(1, 2, 3);
        sudoku.setNumber(2, 3, 4);
        sudoku.setNumber(3, 4, 5);
        sudoku.setNumber(4, 5, 6);
        sudoku.setNumber(5, 6, 7);
        assertEquals(5, sudoku.countNumbers(sudoku.getGrid()));
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
}
