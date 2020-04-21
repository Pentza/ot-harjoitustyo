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
    
    public Sudoku() {
        grid = new int[9][9];
        /*grid[0][0] = 8;
        grid[1][2] = 3;
        grid[1][3] = 6;
        grid[2][1] = 7;
        grid[2][4] = 9;
        grid[2][6] = 2;
        grid[3][1] = 5;
        grid[3][5] = 7;
        grid[4][4] = 4;
        grid[4][5] = 5;
        grid[4][6] = 7;
        grid[5][3] = 1;
        grid[5][7] = 3;
        grid[6][2] = 1;
        grid[6][7] = 6;
        grid[6][8] = 8;
        grid[7][2] = 8;
        grid[7][3] = 5;
        grid[7][7] = 1;
        grid[8][2] = 9;
        grid[8][6] = 4;*/
    }
    
    public int[][] getGrid() {
        return grid;
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
     
    public boolean isEmpty(int cell) {
        if (cell == 0) {
            return true;
        }
        return false;
    }
}
