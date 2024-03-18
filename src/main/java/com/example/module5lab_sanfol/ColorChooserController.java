package com.example.module5lab_sanfol;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    private SimpleIntegerProperty redValue = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty greenValue = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty blueValue = new SimpleIntegerProperty(0);
    private SimpleDoubleProperty alphaValue = new SimpleDoubleProperty(1.0);

    public void initialize() {
        // Bind TextField values to corresponding Slider values
        redValue.bindBidirectional(redSlider.valueProperty());
        greenValue.bindBidirectional(greenSlider.valueProperty());
        blueValue.bindBidirectional(blueSlider.valueProperty());
        alphaValue.bindBidirectional(alphaSlider.valueProperty());

        // Bind Slider values to corresponding TextField values
        bindTextFieldToSlider(redTextField, redValue);
        bindTextFieldToSlider(greenTextField, greenValue);
        bindTextFieldToSlider(blueTextField, blueValue);
        bindTextFieldToSlider(alphaTextField, alphaValue);

        // Listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            red = newVal.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        greenSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            green = newVal.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        blueSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            blue = newVal.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        alphaSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            alpha = newVal.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
    }

    private void bindTextFieldToSlider(TextField textField, SimpleIntegerProperty property) {
        textField.textProperty().bindBidirectional(property, java.text.NumberFormat.getIntegerInstance());
    }

    private void bindTextFieldToSlider(TextField textField, SimpleDoubleProperty property) {
        textField.textProperty().bindBidirectional(property, java.text.NumberFormat.getNumberInstance());
    }
}



