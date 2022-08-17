package com.tttgame;
public class GameEngine {

    public enum State{Empty, X, O};


    public int number = 3;

    public State[][] board = new State[number][number];

    GameBoardController gameBoardController;


    public GameEngine(GameBoardController gameBoardController){
    this.gameBoardController =gameBoardController;


}
public GameEngine(){

}
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
        for(int i = 0; i < number; i++){
            if(board[x][i] != s)
                break;
            if(i == number-1){
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
        for(int i = 0; i < number; i++){
            if(board[i][y] != s)
                break;
            if(i == number-1){

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
            for(int i = 0; i < number; i++){
                if(board[i][i] != s)
                    break;
                if(i == number-1){
                    System.out.println("Wygrana: "+s+" w Przekatnej 1");
                    if (s == State.X){
                        whoWin(1);
                        win=true;
                    }else
                        whoWin(2);
                    win=true;
                }
            }
        }
        // przekatna 2
        if(x + y == number - 1){
            for(int i = 0; i < number; i++){
                if(board[i][(number-1)-i] != s)
                    break;
                if(i == number-1){
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

        if(moveCount == (Math.pow(number, 2) )){
            if (win==false){
            whoWin(0);
            System.out.println("Remis");}

        }
    }

    public void whoWin(int x){
        gameBoardController.checkWhoWin(x);

    }



    public State getBoard(int x,int y) {
        return board[x][y];
    }
    public void setBoard(int x , int y,String text){
        if (text.equals("X")){
            board[x][y] = State.X;
        } else if (text.equals("O")){
            board[x][y] = State.O;
        }else if (text.equals(" ")){
            board[x][y]=State.Empty;
        }
    }



}

