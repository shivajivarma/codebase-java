package com.shivajivarma.codebase.search.linear_search;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {

    public static int search(ArrayList<Integer> arr, int num) {
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i) == num){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nEnter size of the array ::\n");
            int size = scan.nextInt();

            ArrayList<Integer> arr = new ArrayList<Integer>();
            System.out.println("Enter elements of the array ::\n");
            for (int i = 0; i < size; i++) {
                arr.add(scan.nextInt());
            }

            System.out.println("Enter the number to be searched ::\n");
            int num = scan.nextInt();

            System.out.println("Array :: " + arr.toString());

            int position = search(arr, num);
            if (position != -1) {
                System.out.println(num + " is present at location " + (position + 1) + ".\n");
            } else {
                System.out.println(num + " is not present in array.\n");
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

        scan.close();
    }
}
