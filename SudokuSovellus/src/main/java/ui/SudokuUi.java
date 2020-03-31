/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Sudoku;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author pewlahde
 */
public class SudokuUi extends Application {
    private Sudoku sudoku;

    @Override
    public void start(Stage stage) throws Exception {
        sudoku = new Sudoku();
        
        BorderPane root = new BorderPane();

        //Menu buttons
        VBox menuButtons = new VBox();
        menuButtons.setAlignment(Pos.CENTER);

        Button play = new Button("Play");
        Button playEasy = new Button("Easy");
        Button playMedium = new Button("Medium");
        Button playHard = new Button("Hard");

        menuButtons.getChildren().add(play);

        play.setOnAction(e -> {
            menuButtons.getChildren().remove(play);
            menuButtons.getChildren().addAll(playEasy, playMedium, playHard);
        });
        playEasy.setOnAction(e -> {
            root.setCenter(drawGrid(sudoku.getGrid()));
        });
        playMedium.setOnAction(e -> {
            root.setCenter(drawGrid(sudoku.getGrid()));
        });
        playHard.setOnAction(e -> {
            root.setCenter(drawGrid(sudoku.getGrid()));
        });

        root.setCenter(menuButtons);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.show();

    }

    public GridPane drawGrid(int[][] grid) {
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        //board.setPadding(new Insets(10,10,10,10));
        Button[][] buttons = new Button[9][9];
        
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Button btn = new Button(String.valueOf(sudoku.getNumeber(column, row)));
                btn.setPrefSize(40, 40);
                buttons[column][row] = btn;
                board.add(btn, column, row);
            }
        }
//        
//        for (int blockRow = 1; blockRow <= 5; blockRow+=2) {
//            for (int blockColumn = 1; blockColumn <= 5; blockColumn+=2) {
//                GridPane innerBlock = new GridPane();
//                innerBlock.setPadding(new Insets(2));
//                innerBlock.setVgap(1);
//                innerBlock.setHgap(1);
//                for (int row = 1; row <= 3; row++) {
//                    for (int column = 1; column <= 3; column++) {
//                        Button btn = new Button(String.valueOf(sudoku.getNumeber(blockColumn+column, blockRow+row)));
//                        btn.setPrefSize(40, 40);
//                        innerBlock.add(btn, column, row);
//                    }
//                }
//                board.add(innerBlock, blockColumn, blockRow);
//            }
//        }
        return board;
    }

    @Override
    public void stop() {
        System.out.println("Shutting down...");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
