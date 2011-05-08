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
//11360 - Have Fun with Matrices
package volume_cxiii;

import java.util.Scanner;
import java.util.StringTokenizer;

class P11360_3747 {

	public static void main(String[] args) {
		(new P11360_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		int qTc = Integer.parseInt(scn.nextLine());
		for ( int tc = 1; tc <= qTc; tc++ ) {
			int dim = Integer.parseInt(scn.nextLine());
			char matrix[][] = new char[dim][];
			for ( int l = 0; l < dim; l++ ) {
				matrix[l] = new char[dim];
				String line = scn.nextLine();
				//System.out.println(line);
				for ( int c = 0; c < dim; c++ ) {
					matrix[l][c] = line.charAt(c);
				}
			}
			int qComm = Integer.parseInt(scn.nextLine());
			for ( int comm = 0; comm < qComm; comm++ ) {
				String command = scn.nextLine();
				if ( command.startsWith("transpose") ) {
					transpose( matrix );
				} else if ( command.startsWith("inc") ) {
					add(matrix, 1);
				} else if ( command.startsWith("dec") ) {
					add( matrix, -1);
				} else {
					StringTokenizer st = new StringTokenizer( command );
					st.nextToken();
					int a  = Integer.parseInt(st.nextToken());
					int b  = Integer.parseInt(st.nextToken());
					if ( command.startsWith("row") ) {
						row( matrix, a, b );
					} else {
						col( matrix, a, b );
					}
				}
					
			}
			System.out.println("Case #" + tc);
			printMatrix(matrix);
			System.out.println();
		}
	}

	private void printMatrix(char[][] matrix) {
		int dim = matrix.length;
		for ( int l = 0; l < dim; l++ ) {
			String s = new String(matrix[l]);
			System.out.println(s);
		}		
	}

	private void add(char[][] matrix, int i) {
		int dim = matrix.length;
		for ( int l = 0; l < dim; l++ ) {
			for ( int c = 0; c < dim; c++ ) {
				int elm = (int)matrix[l][c] - '0';
				//System.out.println(elm);
				elm += i;
				elm %= 10;
				if ( elm == -1 ) {
					elm = 9;
				}
				//System.out.println(elm);
				matrix[l][c] = (char)(elm + '0');
			}
		}
	}

	private void col(char[][] matrix, int a, int b) {
		int dim = matrix.length;
		for ( int l = 0; l < dim; l++ ) {
			char aux = matrix[l][a-1];
			matrix[l][a-1] = matrix[l][b-1];
			matrix[l][b-1] = aux;
		}
	}

	private void row(char[][] matrix, int a, int b) {
		int dim = matrix.length;
		for ( int c = 0; c < dim; c++ ) {
			char aux = matrix[a-1][c];
			matrix[a-1][c] = matrix[b-1][c];
			matrix[b-1][c] = aux;
		}		
	}

	private void transpose(char[][] matrix) {
		int dim = matrix.length;
		for ( int l = 0; l < dim; l++ ) {
			for ( int c = l+1; c < dim; c++ ) {
				char aux = matrix[l][c];
				matrix[l][c] = matrix[c][l];
				matrix[c][l] = aux;
			}
		}	
	}
}
