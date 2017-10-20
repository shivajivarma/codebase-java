package com.shivajivarma.codebase.data_structures.single_linked_list;

import java.util.Scanner;

class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /*  Constructor  */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /*  Function to check if list is empty  */
    public boolean isEmpty() {
        return head == null;
    }

    /*  Function to get size of list  */
    public int getSize() {
        return size;
    }

    /*  Function to insert an element at beginning  */
    public void insertAtStart(int val) {
        Node node = new Node(val, null);
        size++;
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.setLink(head);
            head = node;
        }
    }

    /*  Function to insert an element at tail  */
    public void insertAtEnd(int val) {
        Node node = new Node(val, null);
        size++;
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setLink(node);
            tail = node;
        }
    }

    /*  Function to insert an element at position  */
    public void insertAtPos(int val, int pos) {
        Node nptr = new Node(val, null);
        Node ptr = head;
        pos = pos - 1;
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                Node tmp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }

    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node s = head;
            Node t = head;
            while (s != tail) {
                t = s;
                s = s.getLink();
            }
            tail = t;
            tail.setLink(null);
            size--;
            return;
        }
        Node ptr = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    /*  Function to display elements  */
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getLink() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.print(head.getData() + "->");
        ptr = head.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class SinglyLinkedList */
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos <= 1 || pos > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.deleteAtPos(p);
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.getSize() + " \n");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

        scan.close();
    }
}
