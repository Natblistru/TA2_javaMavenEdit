package edu.step.ui;

import edu.step.db.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// TODO: de schimbat validarea datelor (de colorat campurile obligatorii in rosu)
public class EditDialogController {

    public TextField nameTextField;

    public TextField surnameTextField;

    public TextField emailTextField;

    public DatePicker birthdateDatePicker;

    private Employee result;

    private Employee editedEmployee;

    public void setEmployee(Employee employee) {
        editedEmployee = employee;
        if (editedEmployee != null) {
            nameTextField.setText(editedEmployee.getName());
            surnameTextField.setText(editedEmployee.getSurname());
            emailTextField.setText(editedEmployee.getEmail());
        }
    }

    public Employee getResult() {
        return editedEmployee;
    }

    public void onSave(ActionEvent event) {
        if(editedEmployee != null && (!nameTextField.getText().isEmpty() || !surnameTextField.getText().isEmpty())) {
            editedEmployee.setName(nameTextField.getText());
            editedEmployee.setSurname(surnameTextField.getText());
            editedEmployee.setEmail(emailTextField.getText());
        }
        Node button = (Node)event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

}
