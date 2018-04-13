package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Controller.toDoListItems;

public class FormController implements Initializable {
    public ComboBox<String> dutyPriority;
    public Button dutyAddButton;
    public TextArea dutyTitle;
    public DatePicker dutyExpDate;
    public TextArea dutyDescription;
    ObservableList<String> priorityItems = FXCollections.observableArrayList
            ("LOW", "MEDIUM", "HIGH");

    @FXML
    public void initComboBox(){
        dutyPriority.setItems(priorityItems);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
    }

    public void addTask(){
        if(dutyTitle.getText().isEmpty() || dutyPriority.getSelectionModel().isEmpty() || dutyExpDate.getValue().equals(null) || dutyDescription.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Warning");
            alert.setContentText("Please fill in every field");
            alert.showAndWait();
        }
        else{
            add();
            Stage stage = (Stage) dutyAddButton.getScene().getWindow();
            stage.close();
        }
    }

    public void add(){
        String name = dutyTitle.getText();
        String priority = dutyPriority.getValue();
        String description = dutyDescription.getText();
        int day = dutyExpDate.getValue().getDayOfMonth();
        int month = dutyExpDate.getValue().getMonthValue();
        int year = dutyExpDate.getValue().getYear();
        toDoListItems.add(new Duty(name, priority, description, day, month, year));
    }
}
