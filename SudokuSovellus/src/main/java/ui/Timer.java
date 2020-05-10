/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author pewlahde
 */
public class Timer {

    private Timeline timeline;
    private Text text;
    private int seconds;
    private int minutes;

    /**
     * Timer object
     */
    public Timer() {
        timeline = new Timeline(new KeyFrame(Duration.ZERO,
            eh -> incrementTime()),
            new KeyFrame(Duration.seconds(1)));
        seconds = 0;
        minutes = 0;
        text = new Text(minutes + ":" + seconds);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Increments timer value every second
     */
    private void incrementTime() {
        if (seconds < 59) {
            seconds++;
        } else {
            seconds = 0;
            minutes++;
        }

        text.setText(minutes + ":" + seconds);
    }

    /**
     * Resets the timer to zero and starts it
     */
    public void start() {
        reset();
        timeline.play();
    }

    /**
     * Resets timer
     */
    public void reset() {
        seconds = 0;
        minutes = 0;
    }

    /**
     * Returns timer value
     *
     * @return Timer value
     */
    public Text getTimer() {
        return text;
    }

}
