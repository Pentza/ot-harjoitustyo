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
}
