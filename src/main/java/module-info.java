module com.example.module5lab_sanfol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.module5lab_sanfol to javafx.fxml;
    exports com.example.module5lab_sanfol;
}