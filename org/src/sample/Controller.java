package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public MenuItem exitItem;
    public Menu aboutItem;
    public Button createButton;
    public  static int index;
    public static Duty editingDuty;

    public ListView toDoListView = new ListView<>();
    public static ObservableList<Duty> toDoListItems = FXCollections.observableArrayList();

    public ListView inProgressListView = new ListView<>();
    public static ObservableList<Duty> inProgressListItems = FXCollections.observableArrayList();

    public ListView doneListView = new ListView<>();
    public static ObservableList<Duty> doneListItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toDoListView.setItems(toDoListItems);
        inProgressListView.setItems(inProgressListItems);
        doneListView.setItems(doneListItems);

        toDoListItems.add(new Duty("Send CV to Sabre", "MEDIUM", "Application via website", 7, 4, 2018));
        toDoListItems.add(new Duty("Send CV to Relativity", "HIGH", "Send an email", 9, 4, 2018));
        toDoListItems.add(new Duty("Send CV to PEGA", "HIGH", "Send an email", 11, 4, 2018));

        toDoListView.setCellFactory(list -> new ColorRectCell());
        inProgressListView.setCellFactory(list -> new ColorRectCell());
        doneListView.setCellFactory(list -> new ColorRectCell());

        toDoListView.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    if (!toDoListView.getItems().isEmpty()) {
                        inProgressListView.getItems().add(toDoListView.getItems().get(toDoListView.getFocusModel().getFocusedIndex()));
                        toDoListView.getItems().remove(toDoListView.getItems().get(toDoListView.getFocusModel().getFocusedIndex()));
                    }
                    break;
            }
        });
        inProgressListView.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    if (!inProgressListView.getItems().isEmpty()) {
                        doneListView.getItems().add(inProgressListView.getItems().get(inProgressListView.getFocusModel().getFocusedIndex()));
                        inProgressListView.getItems().remove(inProgressListView.getItems().get(inProgressListView.getFocusModel().getFocusedIndex()));
                    }
                    break;
                case LEFT:
                    if (!inProgressListView.getItems().isEmpty()) {
                        toDoListView.getItems().add(inProgressListView.getItems().get(inProgressListView.getFocusModel().getFocusedIndex()));
                        inProgressListView.getItems().remove(inProgressListView.getItems().get(inProgressListView.getFocusModel().getFocusedIndex()));
                    }
                    break;
            }
        });
        doneListView.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    if (!doneListView.getItems().isEmpty()) {
                        inProgressListView.getItems().add(doneListView.getItems().get(doneListView.getFocusModel().getFocusedIndex()));
                        doneListView.getItems().remove(doneListView.getItems().get(doneListView.getFocusModel().getFocusedIndex()));
                    }
                    break;
            }
        });
    }

    public void createNewTask() throws IOException {
        Stage stage = new Stage(StageStyle.DECORATED);
        FXMLLoader root = new FXMLLoader(getClass().getResource("dutyForm.fxml"));
        stage.setTitle("New duty");
        Image image = new Image("/icons/2.png");
        stage.getIcons().add(image);
        stage.setScene(new Scene((Pane) root.load()));
        stage.show();
    }

    public void editExistingTask(ListView<Duty>toDoListView) throws IOException {
        if (toDoListView.getSelectionModel().getSelectedIndex() >= 0) {
            index = toDoListView.getSelectionModel().getSelectedIndex();
            editingDuty = toDoListView.getSelectionModel().getSelectedItem();
            Stage stage = new Stage(StageStyle.DECORATED);
            FXMLLoader root = new FXMLLoader(getClass().getResource("editForm.fxml"));
            stage.setTitle("Edit duty");
            Image image = new Image("/icons/2.png");
            stage.getIcons().add(image);
            stage.setScene(new Scene((Pane) root.load()));
            stage.show();
        }
    }
    public void editItemFromToDoList(ActionEvent actionEvent) throws IOException {
        EditFormController.choice= 1;
        editExistingTask(toDoListView);
    }
    public void editItemFromInProgressList(ActionEvent actionEvent) throws IOException {
        EditFormController.choice= 2;
        editExistingTask(inProgressListView);
    }
    public void editItemFromDoneList(ActionEvent actionEvent) throws IOException {
        EditFormController.choice= 3;
        editExistingTask(doneListView);
    }

    public void showInformationsAboutAuthor(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Author");
        window.setHeight(150);
        window.setWidth(350);
        Label label = new Label();
        label.setText(String.format("This application was made by Klaudia Dziewit\n© All rights reserved"));
        label.setFont(new Font("Leelawadee UI Semilight", 15));
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color:#e6f5ff");
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    public void closeProgram(ActionEvent e){
        System.exit(0);
    }

    public void deleteItemFromToDoList(ActionEvent actionEvent) {
        if (toDoListView.getSelectionModel().getSelectedIndex() >= 0) {
            int index = toDoListView.getSelectionModel().getSelectedIndex();
            toDoListView.getItems().remove(index);
        }
    }
    public void deleteItemFromInProgressList(ActionEvent actionEvent) {
        if (inProgressListView.getSelectionModel().getSelectedIndex() >= 0) {
            int index = inProgressListView.getSelectionModel().getSelectedIndex();
            inProgressListView.getItems().remove(index);
        }
    }
    public void deleteItemFromDoneList(ActionEvent actionEvent) {
        if (doneListView.getSelectionModel().getSelectedIndex() >= 0) {
            int index = doneListView.getSelectionModel().getSelectedIndex();
            doneListView.getItems().remove(index);
        }
    }

    static class ColorRectCell extends ListCell<Duty> {
        @Override
        public void updateItem(Duty duty, boolean empty) {
            super.updateItem(duty, empty);
            if (empty) {
                setText(null);
                setTooltip(null);
            }
            else{
                setText(getItem().toString());
                if (getItem().getDutyPriority() == "HIGH")
                    setTextFill(Color.RED);
                else if (getItem().getDutyPriority() == "MEDIUM")
                    setTextFill(Color.BLUE);
                else if (getItem().getDutyPriority() == "LOW")
                    setTextFill(Color.SKYBLUE);
                final Tooltip tooltip = new Tooltip();
                tooltip.setText(getItem().getDutyDescription());
                setTooltip(tooltip);
            }
        }
    }
}
