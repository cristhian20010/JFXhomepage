package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller  implements Initializable{

    @FXML private AnchorPane pane1, pane2, pane3, pane4, opacityPane, drawerPane;
    
    @FXML private ImageView drawerImage;
    
    private boolean menu=false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        opacityPane.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), opacityPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), drawerPane);
        translateTransition.setByX(-600);
        translateTransition.play();
        
        pane1.setStyle("-fx-background-image: url('/sample/1.jpg')");
        pane2.setStyle("-fx-background-image: url('/sample/2.jpg')");
        pane3.setStyle("-fx-background-image: url('/sample/3.jpg')");
        pane4.setStyle("-fx-background-image: url('/sample/4.jpg')");
        
        Animation();
    }
    
    @FXML void drawerImage(MouseEvent e) {
    	if (!menu) {
	    	opacityPane.setVisible(true);
	        
	        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
	        fadeTransition1.setFromValue(0);
	        fadeTransition1.setToValue(0.75);
	        fadeTransition1.play();
	        
	        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerPane);
	        translateTransition1.setByX(+600);
	        translateTransition1.play();
	        
	        menu = true;
    	}
    	else {
    		opacityPane.setVisible(false);
	        
	        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
	        fadeTransition1.setFromValue(0);
	        fadeTransition1.setToValue(0.75);
	        fadeTransition1.play();
	        
	        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerPane);
	        translateTransition1.setByX(-600);
	        translateTransition1.play();
	        
	        menu = false;
    	}
    }
    
    @FXML void opacityPane(MouseEvent event) {
    	FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
        fadeTransition1.setFromValue(0.75);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();
        
        fadeTransition1.setOnFinished(e -> {
        	opacityPane.setVisible(false);
        });
        
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerPane);
        translateTransition1.setByX(-600);
        translateTransition1.play();
        
        menu = false;
    }

    public  void  Animation(){
    	
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        
        fadeTransition.setOnFinished(e -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();
            
            fadeTransition1.setOnFinished(e1 -> {
            	
                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();
                
                fadeTransition2.setOnFinished(e2 -> {
                	
                    FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3), pane2);
                    fadeTransition3.setFromValue(0);
                    fadeTransition3.setToValue(1);
                    fadeTransition3.play();
                    
                    fadeTransition3.setOnFinished(e3 -> {
                        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3), pane3);
                        fadeTransition4.setFromValue(0);
                        fadeTransition4.setToValue(1);
                        fadeTransition4.play();
                        
                        fadeTransition4.setOnFinished(e4 -> {
                            FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(3), pane4);
                            fadeTransition5.setFromValue(0);
                            fadeTransition5.setToValue(1);
                            fadeTransition5.play();
                            
                            fadeTransition5.setOnFinished(e5 -> {
                                Animation();
                            });
                        });
                    });
                });
            });
        });
    }
}
