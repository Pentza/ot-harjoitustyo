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
    
}
