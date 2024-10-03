package com.example.javafxweek4;
public class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void deleteNode(int key) {
        Node temp = head;
        if (temp != null && temp.data == key) {
            head = temp.next;
            if (head != null) head.prev = null;
            return;
        }
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    // This method now returns a String
    public String traverseList() {
        if (head == null) {
            return "List is empty.";
        }

        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" <-> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();  // Return the traversal as a String
    }
}

