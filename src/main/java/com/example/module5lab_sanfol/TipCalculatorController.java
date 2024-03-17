package com.example.module5lab_sanfol;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class TipCalculatorController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    private BigDecimal billAmount = BigDecimal.ZERO;
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    private StringProperty tipAmount = new SimpleStringProperty();
    private StringProperty totalAmount = new SimpleStringProperty();

    @FXML
    private TextField amountTextField;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    public void initialize() {
        // Bind the TextField to the billAmount property
        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                billAmount = new BigDecimal(newValue);
            } catch (NumberFormatException e) {
                // Ignore non-numeric input
            }
            calculateTip();
        });

        // Bind the Slider to the tipPercentage property
        tipPercentageSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
            tipPercentageLabel.setText(NumberFormat.getPercentInstance().format(tipPercentage));
            calculateTip();
        });

        // Bind the tipTextField to the tipAmount property
        tipTextField.textProperty().bind(tipAmount);

        // Bind the totalTextField to the totalAmount property
        totalTextField.textProperty().bind(totalAmount);
    }

    private void calculateTip() {
        BigDecimal tip = billAmount.multiply(tipPercentage);
        BigDecimal total = billAmount.add(tip);

        tipAmount.set(currency.format(tip));
        totalAmount.set(currency.format(total));
    }
}


