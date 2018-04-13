package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Controller.*;

public class EditFormController implements Initializable{
    public static int choice;
    public ComboBox editDutyPriority;
    public Button acceptEditedDuty;
    public DatePicker editDutyDate;
    public TextField editDutyName;
    public TextArea editDutyDescription;
    ObservableList<String> priorityItems = FXCollections.observableArrayList
            ("LOW", "MEDIUM", "HIGH");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
        this.editDutyName.setText(Controller.editingDuty.getDutyName());
        this.editDutyDescription.setText(Controller.editingDuty.getDutyDescription());
        this.editDutyPriority.setValue(Controller.editingDuty.getDutyPriority());
        this.editDutyDate.setValue(LocalDate.ofEpochDay(Controller.editingDuty.getDay()+Controller.editingDuty.getMonth()+Controller.editingDuty.getYear()));
    }

    public void initComboBox(){
        editDutyPriority.setItems(priorityItems);
    }

    public void acceptEditedTask(){
        if(editDutyName.getText().isEmpty() || editDutyPriority.getSelectionModel().isEmpty() || editDutyDate.getValue().equals(null) || editDutyDescription.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("All fields must be completed!");
            alert.showAndWait();
        }
        else if (choice ==1){
            toDoListItems.remove(index);
            toDoListItems.add(index,edit());
            Stage stage = (Stage) acceptEditedDuty.getScene().getWindow();
            stage.close();
        }
        else if (choice ==2){
            inProgressListItems.remove(index);
            inProgressListItems.add(index,edit());
            Stage stage = (Stage) acceptEditedDuty.getScene().getWindow();
            stage.close();
        }
        else if (choice ==3){
            doneListItems.remove(index);
            doneListItems.add(index,edit());
            Stage stage = (Stage) acceptEditedDuty.getScene().getWindow();
            stage.close();
        }
    }

    public Duty edit(){
        String name = editDutyName.getText();
        String priority = (String) editDutyPriority.getValue();
        String description = editDutyDescription.getText();
        int day = editDutyDate.getValue().getDayOfMonth();
        int month = editDutyDate.getValue().getMonthValue();
        int year = editDutyDate.getValue().getYear();
        return new Duty(name, priority, description, day, month, year);
    }
}
