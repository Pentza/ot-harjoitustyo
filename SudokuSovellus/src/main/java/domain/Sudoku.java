/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.LevelDao;
import dao.SqlDao;

/**
 *
 * @author pewlahde
 */
public class Sudoku {

    /**
     * playable Sudoku 9 by 9 grid
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
        leveldao = new SqlDao();
    }

    /**
     * Returns Sudoku grid
     *
     * @return grid
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Sets grid to be parameter grid
     *
     * @param newGrid grid to be set
     */
    public void setGrid(int[][] newGrid) {
        clearGrid();
        grid = newGrid;
    }

    /**
     * Returns solved Sudoku grid, doesn't work yet
     *
     * @return solved Sudoku grid
     */
    public int[][] getSolvedGrid() {
        return solvedGrid;
    }

    /**
     * Returns number in grid
     *
     * @param x x-axis
     * @param y y-axis
     * @return
     */
    public int getNumeber(int x, int y) {
        return grid[y][x];
    }

    /**
     * Sets value to grid
     *
     * @param x x-axis
     * @param y y-axis
     * @param value value to be set
     */
    public void setNumber(int x, int y, int value) {
        grid[y][x] = value;
    }

    /**
     * Clears every value in grid and solved grid to zero
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
     *
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
     * Checks if grid is full and solution is correct, doesn't work because
     * solved grid is always the same
     *
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
     *
     * @param string String of 81 numbers to be set as grid
     */
    public void stringToGrid(String string) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                setNumber(j, i, Character.getNumericValue(string.charAt(i * 9 + j)));
            }
        }
        solvedGrid = grid;
    }

    /**
     * Gets string by parameter difficulty from database
     *
     * @param difficulty difficulty of Sudoku
     */
    public void setGridFromDatabase(String difficulty) {
        String level = leveldao.getRandomLevel(difficulty);
        clearGrid();
        stringToGrid(level);

    }

}
