module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires jdom2;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}