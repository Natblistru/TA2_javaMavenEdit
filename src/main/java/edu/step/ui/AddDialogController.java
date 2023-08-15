package edu.step.ui;

import edu.step.db.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// TODO: de schimbat validarea datelor (de colorat campurile obligatorii in rosu)
public class AddDialogController {

    public TextField nameTextField;

    public TextField surnameTextField;

    public TextField emailTextField;

    public DatePicker birthdateDatePicker;

    private Employee result;

    public Employee getResult() {
        return result;
    }

    public void onSave(ActionEvent event) {
        if(!nameTextField.getText().isEmpty() || !surnameTextField.getText().isEmpty()) {
            // TODO: de adaugat birthdate aici
            result = new Employee(nameTextField.getText(), surnameTextField.getText(), emailTextField.getText());
        }
        Node button = (Node)event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

}
