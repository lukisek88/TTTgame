package com.tttgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

public class GameAI {



    public void aiMove(){


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("GameBoard.fxml"));
        Pane pane= null;
        try {
            pane=loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GameBoardController gC = loader.getController();

        Random rng = new Random();
        int aiType = rng.nextInt(1, 9);

        switch (aiType) {
            case 1:
                if (gC.b00.getText().isEmpty() && gC.b00.isDisabled() == false) {
                    gC.b00.setText("O");
                    gC.b00.setDisable(true);

                    break;
                } else {

                }
            case 2:
                if (gC.b01.getText().isEmpty() && gC.b01.isDisabled() == false) {
                    gC.b01.setText("O");
                    gC.b01.setDisable(true);

                    break;
                } else {

                }

            case 3:
                if (gC.b02.getText().isEmpty() && gC.b02.isDisabled() == false) {
                    gC.b02.setText("O");
                    gC.b02.setDisable(true);

                    break;
                } else {

                }
            case 4:
                if (gC.b10.getText().isEmpty() && gC.b10.isDisabled() == false) {
                    gC.b10.setText("O");
                    gC.b10.setDisable(true);

                    break;
                } else {

                }
            case 5:
                if (gC.b11.getText().isEmpty() && gC.b11.isDisabled() == false) {
                    gC.b11.setText("O");
                    gC.b11.setDisable(true);

                    break;
                } else {

                }

            case 6:
                if (gC.b12.getText().isEmpty() && gC.b12.isDisabled() == false) {
                    gC.b12.setText("O");
                    gC.b12.setDisable(true);

                    break;
                } else {

                }

            case 7:
                if (gC.b20.getText().isEmpty() && gC.b20.isDisabled() == false) {
                    gC.b20.setText("O");
                    gC.b20.setDisable(true);

                    break;
                } else {

                }

            case 8:
                if (gC.b21.getText().isEmpty() && gC.b21.isDisabled() == false) {
                    gC.b21.setText("O");
                    gC.b21.setDisable(true);

                    break;
                } else {

                }

            case 9:
                if (gC.b22.getText().isEmpty() && gC.b22.isDisabled() == false) {
                    gC.b22.setText("O");
                    gC.b22.setDisable(true);

                    break;
                } else {

                }
            default:
                if (gC.b00.getText().isEmpty() && gC.b00.isDisabled() == false) {
                    gC.b00.setText("O");
                    gC.b00.setDisable(true);
                    break;

                } else if (gC.b01.getText().isEmpty() && gC.b01.isDisabled() == false) {
                    gC.b01.setText("O");
                    gC.b01.setDisable(true);
                    break;
                } else if (gC.b02.getText().isEmpty() && gC.b02.isDisabled() == false) {
                    gC.b02.setText("O");
                    gC.b02.setDisable(true);
                    break;

                } else if (gC.b10.getText().isEmpty() && gC.b10.isDisabled() == false) {
                    gC.b10.setText("O");
                    gC.b10.setDisable(true);
                    break;
                } else if (gC.b11.getText().isEmpty() && gC.b11.isDisabled() == false) {
                    gC.b11.setText("O");
                    gC.b11.setDisable(true);
                    break;
                }
        }
    }
}
