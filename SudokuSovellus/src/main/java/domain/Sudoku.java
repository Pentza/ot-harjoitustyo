/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author pewlahde
 */
public class Sudoku {

    private int[][] grid;
    private int[][] solvedGrid;
    private int numberAmount;

    public Sudoku() {
        grid = new int[9][9];
        solvedGrid = new int[9][9];

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

    public int[][] getGrid() {
        return grid;
    }

    public int[][] getSolvedGrid() {
        return solvedGrid;
    }

    public int getNumeber(int x, int y) {
        return grid[y][x];
    }

    public void setNumber(int x, int y, int value) {
        grid[y][x] = value;
    }

    public void clearGrid() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                grid[y][x] = 0;
            }
        }
    }

    public int countNumbers(int[][] grid) {
        numberAmount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    numberAmount++;
                }
            }
        }
        return numberAmount;
    }

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
}
