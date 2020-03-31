/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import domain.Sudoku;
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
public class SudokuTest {
    
    Sudoku sudoku;
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
        testGrid = new int[9][9];
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void construtorTest() {
        assertArrayEquals(testGrid, sudoku.getGrid());
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
}
