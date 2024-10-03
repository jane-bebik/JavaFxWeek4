package com.example.javafxweek4;
public class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node last;

    public CircularLinkedList() {
        last = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteNode(int key) {
        if (last == null) return;

        Node temp = last, prev = null;
        do {
            if (temp.next.data == key) {
                prev = temp;
                break;
            }
            temp = temp.next;
        } while (temp != last);

        if (prev != null) {
            prev.next = temp.next.next;
            if (last.data == key) last = prev;
        }
    }

    // This method now returns a String
    public String traverseList() {
        if (last == null) {
            return "List is empty.";
        }

        StringBuilder result = new StringBuilder();
        Node current = last.next;
        do {
            result.append(current.data).append(" -> ");
            current = current.next;
        } while (current != last.next);
        result.append("(circular)");
        return result.toString();  // Return the traversal as a String
    }
}
