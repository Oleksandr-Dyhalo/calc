module com.itproger.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itproger.calculator to javafx.fxml;
    exports com.itproger.calculator;
}