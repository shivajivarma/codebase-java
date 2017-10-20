[Spiral Matrix](SpiralMatrix.java)
===============

For given matrix size, print number is __Spiral__ form.


### CODE
```java
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
    
}
```

### Example
```
Enter N*N Matrix order :: 10

1	36	35	34	33	32	31	30	29	28	
2	37	64	63	62	61	60	59	58	27	
3	38	65	84	83	82	81	80	57	26	
4	39	66	85	96	95	94	79	56	25	
5	40	67	86	97	100	93	78	55	24	
6	41	68	87	98	99	92	77	54	23	
7	42	69	88	89	90	91	76	53	22	
8	43	70	71	72	73	74	75	52	21	
9	44	45	46	47	48	49	50	51	20	
10	11	12	13	14	15	16	17	18	19	
```

:+1:
