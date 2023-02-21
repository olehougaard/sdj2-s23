package com.example.session5;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloViewController {
    private final HelloViewModel viewModel;

    @FXML
    public Label count;
    @FXML
    public TextField todo;
    @FXML
    public ListView<String> todos;

    public HelloViewController() {
        this.viewModel = new HelloViewModel();
    }

    @FXML
    protected void onAddButtonClick() {
        viewModel.addTodo();
    }

    public void initialize() {
        viewModel.bindTodoCount(count.textProperty());
        viewModel.bindTodo(todo.textProperty());
        viewModel.bindTodos(todos.itemsProperty());
    }

    private void setCount(int c) {
        count.setText(String.valueOf(c));
    }
}
