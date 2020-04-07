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
public class SudokuSolver {

    public boolean isValid(int[][] board, int row, int column, int value) {
        return (checkRow(board, row, value) && checkColumn(board, column, value) && checkSubsection(board, row, column, value));
    }

    public boolean checkRow(int[][] board, int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int[][] board, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSubsection(int[][] board, int row, int column, int value) {
        for (int i = row - row % 3; i < row - row % 3 + 3; i++) {
            for (int j = column - column % 3; j < column - column % 3 + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean solve(int[][] board) {
        boolean filled = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    filled = false;
                    for (int n = 1; n <= 9; n++) {
                        if (isValid(board, i, j, n)) {
                            board[i][j] = n;
                            solve(board);
                            if (sudokuContainsZeros(board)) {
                                board[i][j] = 0;
                            }
                        }
                        
                    }
                    break;
                }
            }
            if (!filled) {
                break;
            }
        }
        return !sudokuContainsZeros(board);
    }
    
     public boolean sudokuContainsZeros(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
