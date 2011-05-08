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
//Problem 116 - Unidirectional TSP
package volume_i;

import java.util.Scanner;

public class P116_3747 {
	public static void main(String[] args) {
		new P116_3747().begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextInt()) {
			Cilinder c = Cilinder.readCilinder(scn);
			Cilinder eager = c.getEagerCounterPart();
			//System.out.println(eager);
			System.out.println(eager.getMinimumPath());
			System.out.println(eager.getMinimumWeight());
		}
	}
}

class Cilinder {
	private int colNumber;
	private int rowNumber;
	private int[][] array;

	public Cilinder(Cilinder cilinder) {
		this.colNumber = cilinder.getColNumber();
		this.rowNumber = cilinder.getRowNumber();
		this.array = cilinder.getArray().clone();
	}

	public String getMinimumPath() {
		StringBuilder sb = new StringBuilder();
		//Primeira linha
		int minL = 0;
		int minV = array[0][0];
		for (int l = 1; l < this.rowNumber; l++ ) {
			if (array[l][0] < minV) {
				minV= array[l][0];
				minL = l;
			}
		}
		sb.append(minL+1);
		sb.append(" ");
		
		for ( int c = 1; c < this.colNumber; c++ ) {
			minV = Integer.MAX_VALUE;
			int nextMinL = 0;
			for ( int i = minL - 1; i <= minL + 1; i++ ) {
				int l = i;
				if ( l < 0) {
					l = this.rowNumber - 1;
				}
				if ( l == this.rowNumber ) {
					l = 0;
				}
				
				if ( this.array[l][c] < minV ) {
					minV = this.array[l][c];
					nextMinL = l;
				} else if ( this.array[l][c] == minV && l < nextMinL ) {
					nextMinL = l;
				}
			}
			sb.append(nextMinL+1);
			sb.append(" ");
			minL = nextMinL;
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public int getMinimumWeight() {
		int min = array[0][0];
		for (int l = 1; l < this.rowNumber; l++ ) {
			if (array[l][0] < min) {
				min = array[l][0]; 
			}
		}
		return min;
	}

	public Cilinder() {
	}

	public static Cilinder readCilinder(Scanner scn) {
		Cilinder res = new Cilinder();
		int m = scn.nextInt();
		int n = scn.nextInt();
		res.setRowNumber(m);
		res.setColNumber(n);
		res.initArary();
		for (int l = 0; l < res.getRowNumber(); l++) {
			for (int c = 0; c < res.getColNumber(); c++) {
				int w = scn.nextInt();
				res.setWeight(l, c, w);
			}
		}
		return res;
	}

	public Cilinder getEagerCounterPart() {
		Cilinder eager = new Cilinder(this);
		for (int c = this.colNumber - 2; c >= 0; c--) {
			for (int l = 0; l < this.rowNumber; l++) {
				int min = Math
						.min(Math.min(eager.getWeight((l - 1) >= 0 ? (l - 1)
								: this.rowNumber - 1, c + 1), eager.getWeight(l,
								c + 1)), eager.getWeight(
								(l + 1) < this.rowNumber ? (l + 1) : 0, c + 1));
				eager.setWeight(l, c, min+this.getWeight(l, c));
			}
		}
		return eager;
	}

	private int getWeight(int l, int c) {
		return this.array[l][c];
	}

	private void setWeight(int l, int c, int w) {
		this.array[l][c] = w;

	}

	private int getColNumber() {
		return this.colNumber;
	}

	private void setColNumber(int n) {
		this.colNumber = n;
	}

	private int getRowNumber() {
		return this.rowNumber;
	}

	private void setRowNumber(int m) {
		this.rowNumber = m;
	}

	private void initArary() {
		this.array = new int[this.rowNumber][];
		for (int l = 0; l < this.rowNumber; l++) {
			this.array[l] = new int[this.colNumber];
		}
	}

	private int[][] getArray() {
		return this.array;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int l = 0; l < this.getRowNumber(); l++) {
			for (int c = 0; c < this.getColNumber(); c++) {
				sb.append(this.array[l][c]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
