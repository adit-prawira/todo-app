package com.adityaprawira.todoapp;

import com.adityaprawira.todoapp.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<TodoItem> todoItems = new ArrayList<>();

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize(){
        TodoItem item1 = new TodoItem("EEET1368 Report",
                "PID Controller report",
                LocalDate.of(2021, Month.APRIL, 18));
        TodoItem item2 = new TodoItem("OENG1118",
                "Sustainable Engineering design test",
                LocalDate.of(2021, Month.APRIL, 30));
        TodoItem item3 = new TodoItem("Design Proposal",
                "Mechatronics system design",
                LocalDate.of(2021, Month.JUNE, 16));
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);

        // Change details when selecting different item,
        // and will select the very first todo item when the application started
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());

                    deadlineLabel.setText(item.getDeadline().toString());
                }
            }
        });
        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}
