module com.tttgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tttgame to javafx.fxml;
    exports com.tttgame;
}