package com.tttgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
private    Stage stage;
private    Scene scene;
private   Parent root;



    @FXML
    CheckBox chAI,chEasy,chHard;


  @Override
    public void initialize(URL location, ResourceBundle resources) {
        chEasy.setDisable(true);
        chHard.setDisable(true);

    }
    public void justPlay(ActionEvent event) throws IOException {
        /*    Parent root = FXMLLoader.load(getClass().getResource("GameBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
        root = loader.load();
        GameBoardController gameBoardController = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        gameBoardController.setAi(chAI.isSelected());
        gameBoardController.setEasy(chEasy.isSelected());
        gameBoardController.setHard(chHard.isSelected());


    }
    public void justPlayAi(){
        if(chAI.isSelected()==true){
            chEasy.setDisable(false);
            chHard.setDisable(false);
            chEasy.setSelected(true);
        }
        if(chAI.isSelected()==false){
            chEasy.setDisable(true);
            chHard.setDisable(true);
            chEasy.setSelected(false);
            chHard.setSelected(false);
        }
    }

        public void disableChHard(){
        if(chEasy.isSelected()==true) {
            chHard.setSelected(false);
        }else {
            chHard.setSelected(true);
        }

        }


        public void disableChEasy(){
        if(chHard.isSelected()==true){
        chEasy.setSelected(false);
    }else {
            chEasy.setSelected(true);
        }
          }
    public void onExit(){
        Platform.exit();


    }
}
