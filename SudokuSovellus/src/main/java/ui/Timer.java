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
    
    public Timer() {
        timeline = new Timeline(new KeyFrame(Duration.ZERO, 
                eh -> incrementTime()),
                new KeyFrame(Duration.seconds(1)));
        seconds = 0;
        minutes = 0;
        text = new Text(minutes + ":" + seconds);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void incrementTime() {
        if (seconds < 60) {
            seconds++;
        } else {
            seconds = 0;
            minutes++;
        }
        
        text.setText(minutes + ":" + seconds);
    }
    
    public void start() {
        timeline.play();
    }
    
    public Text getTimer() {
        return text;
    }
    
    
}
