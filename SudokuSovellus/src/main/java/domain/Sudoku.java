/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.SudokuSolver;
import dao.LevelDao;
import dao.ScoreDao;
import dao.SqlDao;

/**
 *
 * @author pewlahde
 */
public class Sudoku {

    /**
     * Sudoku 9 by 9 grid
     */
    private int[][] grid;
    /**
     * Solved version of initial grid //doesn't work yet
     */
    private int[][] solvedGrid;
    /**
     * SudokuSolver object
     */
    private SudokuSolver solver;
    /**
     * LevelDao Object
     */
    private LevelDao leveldao;

    /**
     * Sudoku object
     */
    public Sudoku() {
        grid = new int[9][9];
        solvedGrid = new int[9][9];

        ScoreDao scoredao = new SqlDao();
        leveldao = new SqlDao();
        
        /*grid[0][0] = 5;
        grid[0][5] = 1;
        grid[0][8] = 2;
        grid[1][6] = 7;
        grid[1][7] = 4;
        grid[2][1] = 9;
        grid[2][7] = 1;
        grid[3][0] = 9;
        grid[3][1] = 5;
        grid[3][5] = 4;
        grid[3][7] = 6;
        grid[4][1] = 6;
        grid[4][2] = 7;
        grid[4][5] = 3;
        grid[5][0] = 2;
        grid[5][3] = 6;
        grid[5][4] = 8;
        grid[6][3] = 8;
        grid[6][7] = 3;
        grid[6][8] = 9;
        grid[7][1] = 3;
        grid[7][2] = 6;
        grid[7][5] = 7;
        grid[8][4] = 1;
        grid[8][5] = 5;*/
    }

    /**
     * Returns Sudoku grid
     * @return grid
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Returns solved sudoku grid, doesn't work yet
     * @return solved sudoku grid
     */
    public int[][] getSolvedGrid() {
        return solvedGrid;
    }

    /**
     * Returns number in grid
     * @param x x-axis
     * @param y y-axis
     * @return 
     */
    public int getNumeber(int x, int y) {
        return grid[y][x];
    }

    /**
     * Sets value to grid
     * @param x x-axis
     * @param y y-axis
     * @param value value to be set
     */
    public void setNumber(int x, int y, int value) {
        grid[y][x] = value;
    }

    /**
     * Clears every value in grid to zero
     */
    public void clearGrid() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                grid[y][x] = 0;
                solvedGrid[y][x] = 0;
            }
        }
    }


    /**
     * Checks if grid has value in every position
     * @param grid Grid to be checked
     * @return returns true if grid is full, otherwise false
     */
    public boolean isGridFull(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if grid is full and solution is correct, doesn't work correct in some cases
     * @param grid grid to be checked
     * @return returns if solution is correct
     */
    public boolean isSolutionCorrect(int[][] grid) {
        if (!isGridFull(grid)) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != solvedGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Sets every number in grid to value in parameter string
     * @param string String of 81 numbers to be set as grid
     */
    public void stringToGrid(String string) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                setNumber(j, i, Character.getNumericValue(string.charAt(i * 9 + j)));
            }
        }
    } 
    
    /**
     * Gets string by parameter difficulty from database
     * @param difficulty difficulty of Sudoku
     */
    public void setGridFromDatabase(String difficulty) {
        String level = leveldao.getRandomLevel(difficulty);
        clearGrid();
        stringToGrid(level);
    }
}
