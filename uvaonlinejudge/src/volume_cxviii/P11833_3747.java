/*
 * MyPCS - My Programming Contests Solutions
 * 
 * Copyright (C) 2007 - 2011  Fernando Cardoso
 * email: fernandohbc@gmail.com / twitter: fernando_hbc
 * 
 * The source code of this program is free software; you can do whatever you
 * want with it since you always keep the name and contact of the original
 * author. Also, if you redistribute a modified version, make sure you explicit
 * the portions of the code that have been modified
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
// Route Change
package volume_cxviii;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P11833_3747 {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        int qtdPontos = scan.nextInt();
        int qtdArestas = scan.nextInt();
        int destino = scan.nextInt() - 1;
        int origem = scan.nextInt();
        int[][] mat;
        int indiI, indiJ, custo = 0;
        int distance = -1;
        while (qtdPontos > 0 && qtdArestas > 0) {
            mat = new int[qtdPontos][qtdPontos];
            for (int i = 0; i < qtdPontos; i++) {
                for (int j = 0; j < qtdPontos; j++) {
                    mat[i][j] = -1;
                }
            }
            for (int i = 0; i < qtdArestas; i++) {
                indiI = scan.nextInt();
                indiJ = scan.nextInt();
                final int min = Math.min(indiI, indiJ);
                final int max = Math.max(indiI, indiJ);
                custo = scan.nextInt();
                if (min > destino || (min < destino && min + 1 == max)) {
                    mat[min][max] = custo;
                }
                if (max > destino) {
                    mat[max][min] = custo;
                }
            }

            if (mat[origem][destino] == -1) {
                // Em vez de Floyd Warshall, usa Djikstra
                final DNode node = new DNode(origem, 0);
                final List<DNode> nodeList = new LinkedList<DNode>();
                final List<DNode> removed = new LinkedList<DNode>();
                nodeList.add(node);
                distance = -1;
                do {
                    Collections.sort(nodeList);
                    DNode closer = nodeList.remove(0);
                    while (removed.contains(closer)) {
                        closer = nodeList.remove(0);
                    }
                    if (closer.node == destino) {
                        distance = closer.cost;
                    } else {
                        for (int i = 0; i < qtdPontos; i++) {
                            if (mat[closer.node][i] != -1) {
                                nodeList.add(new DNode(i, closer.cost
                                        + mat[closer.node][i]));
                            }
                        }
                    }
                    removed.add(closer);
                } while (distance == -1);
                System.out.println(distance);
            } else {
                System.out.println(mat[origem][destino]);
            }
            qtdPontos = scan.nextInt();
            qtdArestas = scan.nextInt();
            destino = scan.nextInt() - 1;
            origem = scan.nextInt();
        }
    }
}

class DNode implements Comparable<DNode> {
    int node;
    int cost;

    public DNode(final int node, final int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(final DNode otherNode) {
        return this.cost - otherNode.cost;
    }

    @Override
    public String toString() {
        return this.node + ";" + this.cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.node;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final DNode other = (DNode) obj;
        if (this.node != other.node) {
            return false;
        }
        return true;
    }
}
