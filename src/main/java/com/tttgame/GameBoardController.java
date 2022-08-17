package com.tttgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class GameBoardController {
    @FXML
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    @FXML
    private Text winnerText,turnText,oWinText,xWinText;
    private Boolean checkbuttons = false;
    private final GameEngine gameEngine = new GameEngine(this);
    private final GameAi gameAi = new GameAi(this,gameEngine);
    private Boolean easy,hard,ai;

    private static int oWin,xWin;

    private int playerTurn = 0;
   public  ArrayList<Button> buttons ;

    @FXML
    public void initialize(){
        for(int i = 0; i < gameEngine.number; i++){
           for (int j = 0; j < gameEngine.number; j++) {
               gameEngine.setBoard(j,i," ");
           }
        }

        xWinText.setText("X Won: "+xWin+" times");

        oWinText.setText("O Won: "+oWin+" times");
        buttons = new ArrayList<>(Arrays.asList(b00,b01,b02,b10,b11,b12,b20,b21,b22));
        buttons.forEach(button -> {
            setupButton();

            button.setFocusTraversable(false);
        });


    }

    public void setPlayerSymbol(Button button) {
       if (getAi()==true){
           button.setText("X");
       }else if (getAi() == false){
           if (playerTurn % 2 == 0) {
               button.setText("X");
           turnText.setText("Turn Player ' O '");

               playerTurn = 1;
           } else {
               button.setText("O");
               turnText.setText("Turn Player ' X '");
               playerTurn = 0;

           }
       }





    }







    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);

        winnerText.setText(" ");
        turnText.setText(" ");
        gameEngine.setMoveCount(0);
        gameEngine.win = false;
        checkbuttons = false;
    }

    private void resetButton(Button button){
        button.setDisable(false);
        button.setText(" ");
        for(int i = 0; i < gameEngine.number; i++){
            for (int j = 0; j < gameEngine.number; j++) {
               gameEngine.setBoard(j,i," ");

            }
        }

    }
    private void setupButton() {
        b00.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(b00.isDisabled()==false){

                    setPlayerSymbol(b00);
                    b00.setDisable(true);

                    if (b00.getText() == "X"){
                        gameEngine.Move(0,0, GameEngine.State.X);
                        chooseAi();

                    }else {
                        gameEngine.Move(0, 0, GameEngine.State.O);
                    }

                    System.out.println(gameEngine.getBoard(0,0));
                }}
        });
        b01.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b01.isDisabled()==false){
                    setPlayerSymbol(b01);
                    b01.setDisable(true);

                    if (b01.getText() == "X"){
                        gameEngine.Move(0,1, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(0, 1, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(0,1));
                }}
        });
        b02.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b02.isDisabled()==false){
                    setPlayerSymbol(b02);
                    b02.setDisable(true);

                    if (b02.getText() == "X"){
                        gameEngine.Move(0,2, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(0, 2, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(0,2));
                }}
        });
        b10.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b10.isDisabled()==false) {
                    setPlayerSymbol(b10);
                    b10.setDisable(true);

                    if (b10.getText() == "X"){
                        gameEngine.Move(1,0, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(1,0, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(1, 0));
                } }
        });
        b11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b11.isDisabled()==false){
                    setPlayerSymbol(b11);
                    b11.setDisable(true);

                    if (b11.getText() == "X"){
                        gameEngine.Move(1,1, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(1, 1, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(1,1));
                }}
        });
        b12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b12.isDisabled()==false){
                    setPlayerSymbol(b12);
                    b12.setDisable(true);

                    if (b12.getText() == "X"){
                        gameEngine.Move(1,2, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(1, 2, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(1,2));
                }}

        });
        b20.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b20.isDisabled()==false) {
                    setPlayerSymbol(b20);
                    b20.setDisable(true);
                    if (b20.getText() == "X"){
                        gameEngine.Move(2,0, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(2, 0, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(2, 0));
                }
            }
        });
        b21.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b21.isDisabled() == false) {
                    setPlayerSymbol(b21);
                    b21.setDisable(true);
                    if (b21.getText() == "X"){
                        gameEngine.Move(2,1, GameEngine.State.X);
                        chooseAi();
                    }else{
                        gameEngine.Move(2,1, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(2,1));
                }
            }
        });
        b22.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b22.isDisabled()==false){
                    setPlayerSymbol(b22);
                    b22.setDisable(true);
                    if (b22.getText() == "X"){
                        gameEngine.Move(2,2, GameEngine.State.X);
                        chooseAi();
                    }else {
                        gameEngine.Move(2, 2, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(2,2));
                }}
        });


    }
    private void disableAllButton(Button button){
        button.setDisable(true);
        checkbuttons = true;


    }
    public void checkWhoWin(int x){
        System.out.println("Otrzymana Wartosc: "+x);
        if (x==1){
            System.out.println("XXXX");
            winnerText.setText("X WON");
            buttons.forEach(this::disableAllButton);
            xWin+=1;
            xWinText.setText("X Won: "+xWin+" times");
            oWinText.setText("O Won: "+oWin+" times");

        } else if (x==2) {
            winnerText.setText("O WON");
            buttons.forEach(this::disableAllButton);
            oWin+=1;
            xWinText.setText("X Won: "+xWin+" times");
            oWinText.setText("O Won: "+oWin+" times");

        } else if (x==0) {
            winnerText.setText("DRAW");
            buttons.forEach(this::disableAllButton);
        }

    }
    public void setButton(int x , int y) {
        if (x == 0 && y == 0) {
            b00.setText("O");
            b00.setDisable(true);
        }
        if (x == 0 && y == 1) {
            b01.setText("O");
            b01.setDisable(true);
        }
        if (x == 0 && y == 2) {
            b02.setText("O");
            b02.setDisable(true);
        }
        if (x == 1 && y == 0) {
            b10.setText("O");
            b10.setDisable(true);
        }
        if (x == 1 && y == 1) {
            b11.setText("O");
            b11.setDisable(true);

        }
        if (x == 1 && y == 2) {
            b12.setText("O");
            b12.setDisable(true);

        }
        if (x == 2 && y == 0) {
            b20.setText("O");
            b20.setDisable(true);

        }
        if (x == 2 && y == 1) {
            b21.setText("O");
            b21.setDisable(true);

        }
        if (x == 2 && y == 2) {
            b22.setText("O");
            b22.setDisable(true);

        }
    }

    private void chooseAi(){
      if (getAi()==true && getEasy()==true){
          if (!checkbuttons){
          gameAi.aiEasyMove();}
      }else if (getAi()==true&& getHard() == true){
          if (!checkbuttons){
          gameAi.aiHardMove();}
      }

    }

    public Boolean getEasy() {
        return easy;
    }

    public void setEasy(Boolean easy) {
        this.easy = easy;
    }

    public Boolean getHard() {
        return hard;
    }

    public void setHard(Boolean hard) {
        this.hard = hard;
    }

    public Boolean getAi() {
        return ai;
    }

    public void setAi(Boolean ai) {
        this.ai = ai;
    }

    @FXML
    private  void onMenu (ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     xWin=0;
     oWin=0;



    }
    @FXML
private void onExit(){
    Platform.exit();
}

 }






