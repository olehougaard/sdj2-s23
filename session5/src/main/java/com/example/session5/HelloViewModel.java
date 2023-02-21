package com.example.session5;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloViewModel {
    private SimpleListProperty<String> todos;
    private StringProperty todo;

    public HelloViewModel() {
        // Create a list property based on an ArrayList:
        this.todos = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.todo = new SimpleStringProperty();
    }

    public void addTodo() {
        if (!todo.isEmpty().get()) {
            todos.add(todo.get());
            todo.set("");
        }
    }

    public void bindTodos(ObjectProperty<ObservableList<String>> property) {
        //Unidirectional
        property.bind(todos);
    }

    public void bindTodoCount(StringProperty property) {
        // Advanced: This is how you create a binding based on a computation.
        // The value is a String representation of the size of the todos list.
        // The binding is based on todos, so when todos changes, the value changes.
        property.bind(Bindings.createStringBinding(() -> String.valueOf(todos.size()), todos));
    }

    public void bindTodo(StringProperty property) {
        property.bindBidirectional(todo);
    }
}
