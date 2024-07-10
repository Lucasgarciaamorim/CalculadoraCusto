package com.borges.calculadoraborges;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CalculatorController {


    @FXML
    private Button btnClean;

    @FXML
    private Button btnConfirm;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtValue;

    @FXML
    private void cleanFields() {
        txtValue.setText("");
        lblResult.setText("");
    }


    @FXML

    private void calculate() {
        try {

            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            format.setGroupingUsed(true);

            double value = format.parse(txtValue.getText()).doubleValue();
            double result1 = value - (value * 0.3052);
            double finalResult = result1 - (result1 * 0.1058);
            lblResult.setText(String.format("%.2f", finalResult));

        } catch (ParseException e) {
            lblResult.setText("Entrada inválida");
        }
    }

    @FXML
    private void mouseCopy(MouseEvent mouseEvent) {
        String text = lblResult.getText();
        if (!text.isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(text);
            clipboard.setContent(content);
        }
    }

    public void initialize() {
        btnClean.setOnAction(event -> cleanFields());
        btnConfirm.setOnAction(event -> calculate());


        txtValue.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    calculate();
                    break;
                default:
                    break;
            }
        });

        lblResult.setOnMouseClicked(this::mouseCopy);
    }


}

