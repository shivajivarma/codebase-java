package com.shivajivarma.codebase.spiral_matrix;

import java.util.Scanner;

public class SpiralMatrix {

    public static int[][] createSpiralMatrix(int N) {
        int current = 1;
        // Start in the corner
        int x = 0, y = 0, dx = 1, dy = 0;
        int spiralMatrix[][] = new int[N][N];

        while (current <= N * N) {
            // Go in a straight line
            spiralMatrix[x][y] = current++;
            int nx = x + dx, ny = y + dy;

            // When you hit the edge...
            if (nx < 0 || nx == N || ny < 0 || ny == N || spiralMatrix[nx][ny] != 0) {
                // ...turn right
                int t = dy;
                dy = dx;
                dx = -t;
            }
            x += dx;
            y += dy;
        }

        return spiralMatrix;
    }

    public static void printMatrix(int[][] spiral, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(spiral[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner scan = new Scanner(System.in);

        char ch;

        do {
            System.out.println("Enter N*N Matrix order :: ");
            int N = scan.nextInt();

            int[][] spiral = createSpiralMatrix(N);

            printMatrix(spiral, N);

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

        scan.close();
    }
}
