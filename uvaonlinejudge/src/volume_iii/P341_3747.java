/*
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
 */
package volume_iii;

import java.util.Scanner;

//TODO: resolver ! =D

public class P341_3747 {
    public static void main(String[] args) {
        new P341_3747().begin();
    }

    private long[][] graph;
    private int[][] intermediate;
    private int v;
    private static final long INFINITE = 67108864;

    private void begin() {
        Scanner scn = new Scanner(System.in);
        v = scn.nextInt();
        int tc = 1;
        while (v != 0 ) {
            //Lê o grafo
            initGraph(v);

            for ( int i = 1; i <= v; i++ ) {
                int e = scn.nextInt();
                for ( int j = 0; j < e; j++ ) {
                    int w = scn.nextInt();
                    int peso = scn.nextInt();
                    graph[i][w] = peso;
                }
            }

            floydWarshall();

            int from = scn.nextInt();
            int to = scn.nextInt();

            System.out.println("Case " + (tc++) + ": Path = " + getPath(from,to) + "; " + graph[from][to] + " second delay");

            v = scn.nextInt();
        }
    }

    private String getPath(int from, int to) {
        int e = intermediate[from][to];
        if ( e == 0 ) {
            return from + " " + to;
        } else {
            return getPath(from, e) + getPath(e, to).substring(1);
        }
    }

    private void floydWarshall() {
        intermediate = new int[v+1][v+1];
        for ( int k = 1; k <= v; k++ ) {
            for ( int i = 1; i <= v; i++ ) {
                for ( int j = 1; j <= v; j++ ) {
                    if ( graph[i][k]+graph[k][j] < graph[i][j] ) {
                        graph[i][j] = graph[i][k]+graph[k][j];
                        intermediate[i][j] = k;
                    }
                }
            }
        }
    }

    private void initGraph(int v) {
        graph = new long[v+1][v+1];
        for ( int i = 1; i <= v; i++ ) {
            for ( int j = 1; j <= v; j++ ) {
                if ( i != j ) {
                    graph[i][j] = INFINITE;
                }
            }
        }
    }
}
