package com.tttgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GameEngine {

    public enum State{Empty, X, O};


    private int n = 3;

    private State[][] board = new State[n][n];



    private int moveCount;
    public boolean win = false;

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    void Move(int x, int y, State s){
        if(board[x][y] == State.Empty){
            board[x][y] = s;
        }
        moveCount++;


        //wiersz
        for(int i = 0; i < n; i++){
            if(board[x][i] != s)
                break;
            if(i == n-1){
                System.out.println("Wygrana: "+s+" w Wieszu");
                if (s == State.X){
                    whoWin(1);
                    win=true;
                }else
                    whoWin(2);
                win=true;

            }
        }

        //kolumna
        for(int i = 0; i < n; i++){
            if(board[i][y] != s)
                break;
            if(i == n-1){

                System.out.println("Wygrana: "+s +" w Kolumnie");
                if (s == State.X){
                    whoWin(1);
                    win=true;
                }else
                    whoWin(2);
                win=true;
            }
        }

        // przekatna 1
        if(x == y){
            for(int i = 0; i < n; i++){
                if(board[i][i] != s)
                    break;
                if(i == n-1){
                    System.out.println("Wygrana: "+s+" w Przekatnej 1");
                    if (s == State.X){
                        whoWin(1);
                        win=true;
                    }else
                        whoWin(1);
                    win=true;
                }
            }
        }
        // przekatna 2
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(board[i][(n-1)-i] != s)
                    break;
                if(i == n-1){
                    System.out.println("Wygrana: "+s+" w Przekatnej 2");
                    if (s == State.X){
                        whoWin(1);
                          win=true;

                    }else
                        whoWin(2);
                    win=true;
                }
            }
        }

        if(moveCount == (Math.pow(n, 2) )){
            if (win==false){
            whoWin(0);
            System.out.println("Remis");}

        }
    }

    public void whoWin(int x){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("GameBoard.fxml"));
        Pane pane= null;
        try {
            pane=loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GameBoardController gameBoardController = loader.getController();
        gameBoardController.checkWhoWin(x);

    }



    public State getBoard(int x,int y) {
        return board[x][y];
    }
    public void setBoard(int x , int y,String text){
        if (text == "X"){
            board[x][y] = State.X;
        } else if (text == "O"){
            board[x][y] = State.O;
        }else if (text == " "){
            board[x][y]=State.Empty;
        }
    }
}

