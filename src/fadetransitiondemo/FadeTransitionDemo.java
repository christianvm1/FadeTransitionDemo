/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadetransitiondemo;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author chris
 */
public class FadeTransitionDemo extends Application {
    
    Circle circulo = new Circle(140);
    double value;
    
    @Override
    public void start(Stage primaryStage) {
        
        circulo.setFill(RED);
        circulo.setStroke(BLACK);
 
        StackPane root = new StackPane();
        root.getChildren().add(circulo);
        
        Scene scene = new Scene(root, 300, 300);
        
        FadeTransition ft = new FadeTransition(Duration.millis(3000), circulo);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);

        ft.play();
        
        circulo.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ft.pause();
            }
        });
        
        circulo.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ft.play();
            }
        });
        
        primaryStage.setTitle("Fade Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
