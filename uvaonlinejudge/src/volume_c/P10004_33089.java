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
// @JUDGE_ID:  33089  10004  Java  "Bicoloring"
package volume_c;

import java.util.StringTokenizer;
import java.util.Vector;

class P10004_33089 {
	// Rotina de Leitura
	static String readLn() {
		String newLine = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		int car = -1;
		try {
			car = System.in.read();
			while ((car > 0) && (car != newLine.charAt(0))) {
				buffer.append((char) car);
				car = System.in.read();
			}
			if (car == newLine.charAt(0))
				System.in.skip(newLine.length() - 1);
		} catch (java.io.IOException e) {
			return (null);
		}
		if ((car < 0) && (buffer.length() == 0))
			return (null);
		return (buffer.toString().trim());
	}

	public static void main(String[] args) {
		(new P10004_33089()).begin();
	}

	private void begin() {
		int qtdVertices = Integer.parseInt(readLn());
		while ( qtdVertices != 0 ) {
			Graph g = new Graph( qtdVertices );
			int qtdArestas = Integer.parseInt(readLn());
			for ( int a = 0; a < qtdArestas; a++ ) {
				String input = readLn();
				StringTokenizer st = new StringTokenizer(input);
				int o = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				g.addAresta(o, d);
			}
			if ( g.isBipartite() ) {
				System.out.println("BICOLORABLE.");
			} else {
				System.out.println("NOT BICOLORABLE.");
			}
			qtdVertices = Integer.parseInt(readLn());
		}
	}
}

class Graph {
	boolean graph[][];
	public Graph(int qtdVertices) {
		graph = new boolean[qtdVertices][];
		for ( int i = 0; i < qtdVertices; i++ ) {
			graph[i] = new boolean[qtdVertices];
		}
	}
	public boolean isBipartite() {
		int qtdVertices = graph.length;
		int side[] = new int[qtdVertices];
		Vector fila = new Vector();
		Vector visitados = new Vector();
		fila.addElement(new Integer(0));
		side[0] = 1;
		while ( fila.size() > 0 ) {
			Integer aux = (Integer)fila.elementAt(0);
			int v = aux.intValue();
			fila.removeElementAt(0);
			int theSide = side[v];
			for ( int d = 0; d < qtdVertices; d++ ) {
				if ( graph[v][d] ) {
					if ( side[d] == 0 || side[d] == 3 - theSide) {
						side[d] = 3 - theSide;
					} else {
						return false;
					}
					if ( !visitados.contains(new Integer(d)) ) { 
						fila.addElement(new Integer(d));
					}
				}
			}
			visitados.addElement(new Integer(v));
		}
		return true;
	}
	public void addAresta(int o, int d) {
		graph[o][d] = true;
		graph[d][o] = true;
	}
	
}
