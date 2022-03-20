package com.itproger.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_res;

    @FXML
    private Button clear_button;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button multiply_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button dot_btn;

    @FXML
    private Button equal_btn;

    String label_text = "";
    float first_num = 0f;
    char operation = '0';

    @FXML
    void addNumber(ActionEvent event) {
        label_text += ((Button) event.getSource()).getText();
        label_res.setText(label_text);
    }

    @FXML
    void initialize() {
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        multiply_btn.setOnAction(event -> {
            mathAction('*');
        });
        equal_btn.setOnAction(event -> {
            if(operation == '+' || operation == '-' || operation == '*' || operation == '/')
                equalBtn();
        });
        dot_btn.setOnAction(event -> {
            if(!label_text.contains(".")) {
                label_text += ".";
                label_res.setText(label_text);
            }
        });
        percent_btn.setOnAction(event -> {
            if(!label_text.equals("")) {
                float num = Float.parseFloat(label_text) * 0.1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        plus_minus_btn.setOnAction(event -> {
            if(!label_text.equals("")) {
                float num = Float.parseFloat(label_text) * -1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });
        clear_button.setOnAction(event -> {
            label_res.setText("0");
            label_text = "";
            operation = '0';
            first_num = 0f;
        });
    }

    private void equalBtn() {
        float result = 0f;
        switch (operation) {
            case '+':
                result = first_num + Float.parseFloat(label_text);
                break;
            case '-':
                result = first_num - Float.parseFloat(label_text);
                break;
            case '*':
                result = first_num * Float.parseFloat(label_text);
                break;
            case '/':
                float second_num = Float.parseFloat(label_text);
                if(second_num == 0)
                    result = 0;
                else
                    result = first_num / second_num;
                break;
        }
        label_res.setText(Float.toString(result));
        label_text = "";
        operation = '0';
        first_num = 0f;
    }

    private void mathAction(char action) {
        if(operation != '+' && operation != '-' && operation != '*' && operation != '/') {
            first_num = Float.parseFloat(label_text);
            label_res.setText(String.valueOf(action));
            label_text = "";
            operation = action;
        }
    }
}

