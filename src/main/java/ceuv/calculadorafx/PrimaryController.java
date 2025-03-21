package ceuv.calculadorafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtPantalla;
    
    private double num1 = 0;
    private String operacion = "";
    private boolean operacionSeleccionada = false;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn0;
    @FXML
    private Button btn4;
    @FXML
    private Button btn1;
    @FXML
    private Button btn5;
    @FXML
    private Button btn2;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btn6;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnMultiplica;
    @FXML
    private Button btnResta;
    @FXML
    private Button btn3;
    @FXML
    private Button btnIgual;
    @FXML
    private Button btnSuma;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    
    @FXML
    private void handleNumber(ActionEvent event) {
        Button btn = (Button) event.getSource();

        
        if (operacionSeleccionada) {
            txtPantalla.clear();
            operacionSeleccionada = false;
        }

        
        if (txtPantalla.getText().length() < 10) {
            txtPantalla.setText(txtPantalla.getText() + btn.getText());
        }
    }

    
    @FXML
    private void handleOperation(ActionEvent event) {
        if (txtPantalla.getText().isEmpty()) {
            return; 
        }

        try {
            num1 = Double.parseDouble(txtPantalla.getText());
            Button btn = (Button) event.getSource();
            operacion = btn.getText();
            operacionSeleccionada = true;
        } catch (NumberFormatException e) {
            txtPantalla.setText("Error");
        }
    }

    
    @FXML
    private void handleEquals(ActionEvent event) {
        if (txtPantalla.getText().isEmpty() || operacion.isEmpty()) {
            return; 
        }

        try {
            double num2 = Double.parseDouble(txtPantalla.getText());
            double resultado = 0;

            switch (operacion) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        txtPantalla.setText("Error: ÷0"); 
                        return; 
                    }
                    resultado = num1 / num2;
                    break;
            }

            
            if (resultado == (int) resultado) {
                txtPantalla.setText(String.valueOf((int) resultado));
            } else {
                txtPantalla.setText(String.valueOf(resultado));
            }

            operacion = ""; 
        } catch (NumberFormatException e) {
            txtPantalla.setText("Error");
        }
    }

   
    @FXML
    private void handleClear(ActionEvent event) {
        txtPantalla.clear();
        num1 = 0;
        operacion = "";
        operacionSeleccionada = false;
    }
}

