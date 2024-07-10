module com.borges.calculadoraborges {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.borges.calculadoraborges to javafx.fxml;
    exports com.borges.calculadoraborges;
}