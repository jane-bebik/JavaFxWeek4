package com.example.javafxweek4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    private SinglyLinkedList singlyList = new SinglyLinkedList();
    private DoublyLinkedList doublyList = new DoublyLinkedList();
    private CircularLinkedList circularList = new CircularLinkedList();

    @FXML
    private TextField inputField;

    @FXML
    private TextArea displayArea;

    @FXML
    private void addNode() {
        String input = inputField.getText();

        if (input == null || input.trim().isEmpty()) {
            displayArea.setText("Please enter a valid number.");
            return;
        }

        try {
            int value = Integer.parseInt(input);
            singlyList.addNode(value);
            doublyList.addNode(value);
            circularList.addNode(value);
            displayArea.setText("Node added: " + value);
        } catch (NumberFormatException e) {
            displayArea.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    private void deleteNode() {
        String input = inputField.getText();

        if (input == null || input.trim().isEmpty()) {
            displayArea.setText("Please enter a valid number.");
            return;
        }

        try {
            int value = Integer.parseInt(input);
            singlyList.deleteNode(value);
            doublyList.deleteNode(value);
            circularList.deleteNode(value);
            displayArea.setText("Node deleted: " + value);
        } catch (NumberFormatException e) {
            displayArea.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    private void traverseSingly() {
        // Capture the result of traversing the singly linked list
        String result = singlyList.traverseList();
        // Set the result in the displayArea (JavaFX window)
        displayArea.setText("Singly Linked List: " + result);
        // Optional: Print to console as well
        System.out.println("Singly Linked List: " + result);
    }

    @FXML
    private void traverseDoubly() {
        // Capture the result of traversing the doubly linked list
        String result = doublyList.traverseList();
        // Set the result in the displayArea (JavaFX window)
        displayArea.setText("Doubly Linked List: " + result);
        // Optional: Print to console as well
        System.out.println("Doubly Linked List: " + result);
    }

    @FXML
    private void traverseCircular() {
        // Capture the result of traversing the circular linked list
        String result = circularList.traverseList();
        // Set the result in the displayArea (JavaFX window)
        displayArea.setText("Circular Linked List: " + result);
        // Optional: Print to console as well
        System.out.println("Circular Linked List: " + result);
    }
}
