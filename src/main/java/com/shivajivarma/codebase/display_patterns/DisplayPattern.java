package com.shivajivarma.codebase.display_patterns;


import java.util.Scanner;

public class DisplayPattern {

    public static void printZ(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - i - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
    }

    public static void rightAngledTriangleRightOrientated(int size, char printChar) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(printChar);
            }
            System.out.println();
        }
    }

    public static void rightAngledTriangleLeftOrientated(int size, char printChar) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(printChar);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nDisplay Patterns\n");
            System.out.println("1. Print Z");
            System.out.println("2. Print Right Angled Triangle");
            int choice = scan.nextInt();
            char subChoice;
            switch (choice) {
                case 1:
                    System.out.println("Enter size of 'Z' :: ");
                    printZ(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the number of rows in triangle :: ");
                    int size = scan.nextInt();
                    System.out.println("Enter a character to be printed :: ");
                    char printChar = scan.next().charAt(0);
                    System.out.println("a. Right orientation ");
                    System.out.println("b. left orientation ");
                    subChoice = scan.next().charAt(0);
                    switch (subChoice) {
                        case 'a':
                            rightAngledTriangleRightOrientated(size, printChar);
                            break;

                        case 'b':
                            rightAngledTriangleLeftOrientated(size, printChar);
                            break;
                        default:
                            System.out.println("Sub Wrong Entry \n ");
                            break;
                    }
                    break;
                default:
                    System.out.println("Main Wrong Entry \n ");
                    break;
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

        scan.close();
    }
}
