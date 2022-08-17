package com.tttgame;

import java.util.Random;

public class GameAi {
    GameBoardController gC;
    GameEngine gE;

    static class Move
    {
        int row, col;
    };

    public GameAi(GameBoardController gC,GameEngine gE){
        this.gC = gC;
        this.gE= gE;




    }
 public void aiEasyMove() {
     Random rng = new Random();
     int ai = rng.nextInt(0, 3);
     System.out.println("AI " + ai);
     int ai2 = rng.nextInt(0, gE.number);


     if (ai == 0) {
         for (int i = 0; i < gE.number; i++) {
             if (gE.getBoard(1, 1) == GameEngine.State.Empty && gE.getBoard(1, 1) != GameEngine.State.X && gE.getBoard(1, 1) != GameEngine.State.O) {
                 gC.setButton(1,1);
                 gE.Move(1,1, GameEngine.State.O);
                 break;
             } else if (gE.getBoard(ai2, i) == GameEngine.State.Empty && gE.getBoard(ai2, i) != GameEngine.State.X && gE.getBoard(ai2, i) != GameEngine.State.O) {
                 gC.setButton(ai2,i);
                 gE.Move(ai2,i, GameEngine.State.O);
                 break;
             } else if (gE.getBoard(i, ai2) == GameEngine.State.Empty && gE.getBoard(i, ai2) != GameEngine.State.X && gE.getBoard(i, ai2) != GameEngine.State.O) {
                 gC.setButton(i,ai2);
                 gE.Move(i,ai2, GameEngine.State.O);
                 break;
             } else if (gE.getBoard(i, i) == GameEngine.State.Empty && gE.getBoard(i, i) != GameEngine.State.X && gE.getBoard(i, i) != GameEngine.State.O) {
                 gC.setButton(i,i);
                 gE.Move(i,i, GameEngine.State.O);
                 break;
             }


         }}

         if (ai == 1){
             for (int i = 0; i < gE.number; i++) {
                 if (gE.getBoard(1, 1) == GameEngine.State.Empty && gE.getBoard(1, 1) != GameEngine.State.X && gE.getBoard(1, 1) != GameEngine.State.O) {
                     gC.setButton(1,1);
                     gE.Move(1,1, GameEngine.State.O);
                     break;
                 } else if (gE.getBoard(i, ai) == GameEngine.State.Empty && gE.getBoard(i, ai2) != GameEngine.State.X && gE.getBoard(i, ai2) != GameEngine.State.O) {
                     gC.setButton(i,ai2);
                     gE.Move(i,ai2, GameEngine.State.O);
                     break;
                 } else if (gE.getBoard(ai2, i) == GameEngine.State.Empty && gE.getBoard(ai2, i) != GameEngine.State.X && gE.getBoard(ai2, i) != GameEngine.State.O) {
                     gC.setButton(ai2,i);
                     gE.Move(ai2,i, GameEngine.State.O);
                     break;
                 } else if (gE.getBoard(i, i) == GameEngine.State.Empty && gE.getBoard(i, i) != GameEngine.State.X && gE.getBoard(i, i) != GameEngine.State.O) {
                     gC.setButton(i,i);
                     gE.Move(i,i, GameEngine.State.O);
                     break;
                 }

         }}


         if (ai==2){
             for (int i = 0; i < gE.number; i++) {
                 if (gE.getBoard(1, 1) == GameEngine.State.Empty && gE.getBoard(1, 1) != GameEngine.State.X && gE.getBoard(1, 1) != GameEngine.State.O) {
                     gC.setButton(1,1);
                     gE.Move(1,1, GameEngine.State.O);
                     break;
                 } else if(gE.getBoard(i, i) == GameEngine.State.Empty && gE.getBoard(i, i) != GameEngine.State.X && gE.getBoard(i, i) != GameEngine.State.O) {
                     gC.setButton(i,i);
                     gE.Move(i,i, GameEngine.State.O);
                     break;
                 } else if (gE.getBoard(ai2, i) == GameEngine.State.Empty && gE.getBoard(ai2, i) != GameEngine.State.X && gE.getBoard(ai2, i) != GameEngine.State.O) {
                     gC.setButton(ai2,i);
                     gE.Move(ai2,i, GameEngine.State.O);
                     break;
                 } else if (gE.getBoard(i, ai2) == GameEngine.State.Empty && gE.getBoard(i, ai2) != GameEngine.State.X && gE.getBoard(i, ai2) != GameEngine.State.O) {
                     gC.setButton(i,ai2);
                     gE.Move(i,ai2, GameEngine.State.O);
                     break;

         }}}




 }

 public void aiHardMove(){

value();

    }

static GameEngine.State player = GameEngine.State.X, opponent = GameEngine.State.O;
    static Boolean isMovesLeft(GameEngine.State board[][])
    {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] == GameEngine.State.Empty)
                    return true;
        return false;
    }


    static int evaluate(GameEngine.State b[][])
    {

        for (int row = 0; row < 3; row++)
        {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2])
            {
                if (b[row][0] == player)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }


        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == player)
                    return +10;

                else if (b[0][col] == opponent)
                    return -10;
            }
        }


        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == player)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == player)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }


        return 0;
    }


    static int minimax(GameEngine.State board[][],
                       int depth, Boolean isMax)
    {
        int score = evaluate(board);


        if (score == 10)
            return score;


        if (score == -10)
            return score;


        if (isMovesLeft(board) == false)
            return 0;


        if (isMax)
        {
            int best = -1000;


            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {

                    if (board[i][j]==GameEngine.State.Empty)
                    {

                        board[i][j] = player;


                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));


                        board[i][j] = GameEngine.State.Empty;
                    }
                }
            }
            return best;
        }


        else
        {
            int best = 1000;


            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {

                    if (board[i][j] == GameEngine.State.Empty)
                    {

                        board[i][j] = opponent;


                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        board[i][j] = GameEngine.State.Empty;
                    }
                }
            }
            return best;
        }
    }


    static Move findBestMove(GameEngine.State board[][])
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;


        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {

                if (board[i][j] == GameEngine.State.Empty)
                {

                    board[i][j] = player;


                    int moveVal = minimax(board, 0, false);


                    board[i][j] = GameEngine.State.Empty;


                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }



        return bestMove;
    }


    public  void value()
    {
        GameEngine.State board[][] = {{ gE.getBoard(0,0), gE.getBoard(0,1), gE.getBoard(0,2) },
                { gE.getBoard(1,0),gE.getBoard(1,1), gE.getBoard(1,2) },
                { gE.getBoard(2,0), gE.getBoard(2,1), gE.getBoard(2,2) }};

        Move bestMove = findBestMove(board);

        System.out.printf("The Optimal Move is :\n");
        System.out.printf("ROW: %d COL: %d\n\n",
                bestMove.row, bestMove.col );
        gC.setButton(bestMove.row, bestMove.col);
        gE.Move(bestMove.row, bestMove.col, GameEngine.State.O);

    }



}








