module com.example.draganddrop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.draganddrop to javafx.fxml;
    exports com.example.draganddrop;
}