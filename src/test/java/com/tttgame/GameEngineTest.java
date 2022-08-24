package com.tttgame;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;


class GameEngineTest {
    private GameEngine engine;

    @BeforeEach
    public void before() {
        GameBoardController gBCmock = mock(GameBoardController.class);
        this.engine = new GameEngine(gBCmock);
        System.out.println("Test Case begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case end");
    }


    @Test
    void testMoveX() {
        //given
        ArrayList<GameEngine.State> listX = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            engine.setBoard(0,i,"X");
            listX.add(engine.getBoard(0, i));
        }
        //when
        ArrayList<GameEngine.State> arrayListX = new ArrayList<>();
        arrayListX.add(GameEngine.State.X);
        arrayListX.add(GameEngine.State.X);
        arrayListX.add(GameEngine.State.X);
      //then
        assertEquals(arrayListX,listX);


    }
    @Test
    void testMoveO(){
        //given
        ArrayList<GameEngine.State> listO = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            engine.setBoard(0,i,"O");
            listO.add(engine.getBoard(0, i));
        }
        //when
        ArrayList<GameEngine.State> arrayListO =new ArrayList<>();
        arrayListO.add(GameEngine.State.O);
        arrayListO.add(GameEngine.State.O);
        arrayListO.add(GameEngine.State.O);

        //then
        assertEquals(arrayListO,listO);
    }

}
