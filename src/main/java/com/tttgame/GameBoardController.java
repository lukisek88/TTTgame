package com.tttgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class GameBoardController {
    @FXML
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    @FXML
    private Text winnerText;
    private final GameEngine gameEngine = new GameEngine();
    private int playerTurn = 0;
    private  ArrayList<Button> buttons ;
    @FXML
    public void initialize(){
        for(int i = 0; i < 3; i++){
            gameEngine.setBoard(0,i," ");
            gameEngine.setBoard(1,i," ");
            gameEngine.setBoard(2,i," ");

        }

        buttons = new ArrayList<>(Arrays.asList(b00,b01,b02,b10,b11,b12,b20,b21,b22));
        buttons.forEach(button -> {
            setupButton();
            button.setFocusTraversable(false);
        });


    }

    public void setPlayerSymbol(Button button){
        GameAI gameAI = new GameAI();
        gameAI.aiMove();
        button.setText("X");


        /*if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }*/
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);

        winnerText.setText(" ");
        gameEngine.setMoveCount(0);
        gameEngine.win = false;

    }

    private void resetButton(Button button){
        button.setDisable(false);
        button.setText(" ");
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
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
                    }else {
                        gameEngine.Move(2, 2, GameEngine.State.O);
                    }
                    System.out.println(gameEngine.getBoard(2,2));
                }}
        });


    }
    private void disableAllButton(Button button){
        button.setDisable(true);

    }
    public void checkWhoWin(int x){
        System.out.println("Otrzymana Wartosc: "+x);
        if (x==1){

            winnerText.setText("X WON");
            buttons.forEach(this::disableAllButton);

        } else if (x==2) {
            winnerText.setText("O WON");
            buttons.forEach(this::disableAllButton);

        } else if (x==0) {
            winnerText.setText("DRAW");
            buttons.forEach(this::disableAllButton);
        }

    }

     @FXML
private void onExit(){
    Platform.exit();
}

    }






