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
    
    public void solve() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (grid[y][x] == 0) {
                    for (int n = 1; n < 10; n++) {
                        if (possible(x, y, n)) {
                            grid[y][x] = n;
                            solve();
                            grid[y][x] = 0;
                        }
                    }
                    return;
                }
            }
        }
        return;
    }
    
    public boolean possible(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (getNumeber(i, y) == n) {
                return false;
            }
            if (getNumeber(x, i) == n) {
                return false;
            }
        }
        int x0 = (x % 3) * 3;
        int y0 = (y % 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getNumeber(x0 + j, y0 + j) == n) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isEmpty(int cell) {
        if (cell == 0) {
            return true;
        }
        return false;
    }
    
    public boolean checkRow(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (i == x) {
                continue;
            }
            if (getNumeber(i, y) == value) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkColumn(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (i == y) {
                continue;
            }
            if (getNumeber(x, i) == value) {
                return false;
            }
        }
        return true;
    }
    
}
