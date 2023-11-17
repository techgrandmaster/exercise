package com.exercise.dll;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertBeginning(10);
        list.display();
        list.insertEnd(20);
        list.display();
        list.insertEnd(30);
        list.display();
        list.insertBeginning(25);
        list.display();
        list.insertBefore(35, 30);
        list.display();
        System.out.println("Doubly Linked List:");
        list.removeData(20);
        list.display();
        System.out.println("Doubly Linked List:");
        list.removeData(25);
        list.display();
        System.out.println("Doubly Linked List:");
        list.display();
    }
}

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head = null;

    public DoublyLinkedList() {
    }

    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (this.head != null) {
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current;
            for (current = this.head; current.next != null; current = current.next) {
            }

            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void insertBefore(int data, int before) {
        Node newNode = new Node(data);
        Node current;
        for (current = this.head; current.next != null && current.data != before; current = current.next) {
        }

        if (current.data == before) {
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        } else {
            System.out.println("Data not found");
        }
    }

    public void removeData(int data) {
        Node current;
        for (current = this.head; current.next != null && current.data != data; current = current.next) {
        }

        if (current.data == data && current == this.head) {
            this.head = current.next;
        } else if (current.data == data) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        } else {
            System.out.println("Data not found");
        }
    }

    public void display() {
        for (Node current = this.head; current != null; current = current.next) {
            System.out.print(current.data + " <-> ");
        }
        System.out.println("null");
    }
}
