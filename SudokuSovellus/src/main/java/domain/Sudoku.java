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
