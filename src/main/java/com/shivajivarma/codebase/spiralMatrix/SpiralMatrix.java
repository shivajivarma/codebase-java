package com.shivajivarma.codebase.spiralMatrix;

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

    public static void printMatrix(int[][] spiral, int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(spiral[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter N*N Matrix order :: ");
        int N = in.nextInt();
        in.close();

        int[][] spiral = createSpiralMatrix(N);

        printMatrix(spiral, N);

    }
}
