/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Sudoku;
import domain.SudokuSolver;
import ui.Timer;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author pewlahde
 */
public class SudokuUi extends Application {

    private Sudoku sudoku;
    private SudokuSolver solver;
    private List<KeyCode> validNumbers;
    private Button[][] buttons;
    private Timer timer;
    private Text solved;

    @Override
    public void init() throws Exception {
        sudoku = new Sudoku();
    }

    @Override
    public void start(Stage stage) throws Exception {
        solver = new SudokuSolver();
        timer = new Timer();
        validNumbers = new ArrayList<>();
        validNumbers.add(KeyCode.DIGIT0);
        validNumbers.add(KeyCode.DIGIT1);
        validNumbers.add(KeyCode.DIGIT2);
        validNumbers.add(KeyCode.DIGIT3);
        validNumbers.add(KeyCode.DIGIT4);
        validNumbers.add(KeyCode.DIGIT5);
        validNumbers.add(KeyCode.DIGIT6);
        validNumbers.add(KeyCode.DIGIT7);
        validNumbers.add(KeyCode.DIGIT8);
        validNumbers.add(KeyCode.DIGIT9);

        BorderPane root = new BorderPane();

        //Menu buttons
        VBox menuButtons = new VBox();
        menuButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(20);

        VBox gameButtons = new VBox();
        gameButtons.setAlignment(Pos.CENTER);
        gameButtons.setSpacing(20);
        gameButtons.setPadding(new Insets(30));

        HBox gameTime = new HBox();
        gameTime.setAlignment(Pos.CENTER);
        gameButtons.setSpacing(20);
        gameButtons.setPadding(new Insets(30));

        Button play = new Button("Play");
        Button playEasy = new Button("Easy");
        Button playMedium = new Button("Medium");
        Button playHard = new Button("Hard");
        Button solve = new Button("Solve");
        Button check = new Button("Check");
        Button clear = new Button("Clear");
        Button back = new Button("Back");
        solved = new Text();

        menuButtons.getChildren().add(play);
        gameButtons.getChildren().addAll(solved, solve, check, clear, back);
        gameTime.getChildren().add(timer.getTimer());

        play.setOnAction(e -> {
            menuButtons.getChildren().remove(play);
            menuButtons.getChildren().addAll(playEasy, playMedium, playHard);
        });
        playEasy.setOnAction(e -> {
            timer.start();
            sudoku.setGridFromDatabase("easy");
            root.setCenter(drawGrid(sudoku.getGrid()));
            root.setRight(gameButtons);
            root.setTop(gameTime);
        });
        playMedium.setOnAction(e -> {
            timer.start();
            sudoku.setGridFromDatabase("medium");
            root.setCenter(drawGrid(sudoku.getGrid()));
            root.setRight(gameButtons);
            root.setTop(gameTime);
        });
        playHard.setOnAction(e -> {
            timer.start();
            sudoku.setGridFromDatabase("hard");
            root.setCenter(drawGrid(sudoku.getGrid()));
            root.setRight(gameButtons);
            root.setTop(gameTime);
            
        });
        clear.setOnAction(e -> {
            sudoku.clearGrid();
            this.update();
        });
        check.setOnAction(e -> {
            Alert alert;
            if (sudoku.isGridFull(sudoku.getGrid())) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.show();
            } else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.show();
            }
        });
        solve.setOnAction(e -> {
            if (solver.solve(sudoku.getGrid())) {
                solved.setText("Solved!");
                this.update();
            } else {
                solved.setText("Not solvable");
            }
        });
        back.setOnAction(e -> {
            root.setTop(null);
            root.setRight(null);
            root.setCenter(menuButtons);
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
        buttons = new Button[9][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
//                Rectangle btn = new Rectangle(40, 40);
//                Text txt = new Text(String.valueOf(grid[row][column]));
//                btn.setFill(null);
//                btn.setStroke(Color.BLACK);

                Button btn = createButton(column, row);
                buttons[row][column] = btn;
                board.add(btn, column, row);
            }
        }
        return board;
    }

    public Button createButton(int x, int y) {
        Button btn = new Button();
        btn.setPrefSize(40, 40);
        btn.setFont(Font.font(18));
        if (sudoku.getNumeber(x, y) != 0) {
            btn.setText(String.valueOf(sudoku.getNumeber(x, y)));
            //Disable template numbers
            //btn.setDisable(true);

        }

        btn.setOnKeyPressed(key -> {
            KeyCode keyCode = key.getCode();
            if (!validNumbers.contains(keyCode)) {
                return;
            }
            sudoku.setNumber(x, y, Integer.valueOf(key.getText()));
            if (sudoku.getNumeber(x, y) != 0) {
                btn.setText(String.valueOf(sudoku.getNumeber(x, y)));
            } else {
                btn.setText("");
            }
            if (sudoku.isGridFull(sudoku.getGrid())) {
                System.out.println("Grid is full.");
                if (sudoku.isSolutionCorrect(sudoku.getGrid())) {
                    System.out.println("Done");
                }
            }
        });
        
        return btn;
    }

    public void update() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (sudoku.getNumeber(x, y) != 0) {
                    buttons[y][x].setText(String.valueOf(sudoku.getNumeber(x, y)));
                } else {
                    buttons[y][x].setText("");
                }
            }
        }
    }

    @Override
    public void stop() {
        System.out.println("Shutting down...");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
