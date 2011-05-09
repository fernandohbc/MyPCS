/*******************************************************************************
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. In other words, use it
 * at your own risk.
 * 
 * If you find this a little useful, you can buy the author some beer.
 * If you find this really useful, you can buy a kid a book, and help making
 * the world more literate.
 ******************************************************************************/
package maratona2010;

import java.util.Scanner;

public class ComeAndGo {
    public static void main(String[] args) {
        new ComeAndGo().begin();
    }

    private long[][] graph;
    private int[][] intermediate;
    private int n;
    private static final long INFINITE = 67108864;

    private void begin() {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        while (n != 0) {
            // Lê o grafo
            initGraph(n);

            int m = scn.nextInt();
            for (int i = 1; i <= m; i++) {
                int v = scn.nextInt();
                int w = scn.nextInt();
                int d = scn.nextInt();
                graph[v][w] = 1;
                if (d == 2) {
                    graph[w][v] = 1;
                }
            }

            floydWarshall();

            System.out.println(checkConnectivity());

            n = scn.nextInt();
        }
    }

    private int checkConnectivity() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ( graph[i][j] == INFINITE) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private void floydWarshall() {
        intermediate = new int[n + 1][n + 1];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        intermediate[i][j] = k;
                    }
                }
            }
        }
    }

    private void initGraph(int v) {
        graph = new long[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    graph[i][j] = INFINITE;
                }
            }
        }
    }
}
