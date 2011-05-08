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
//Problem 10131: Is Bigger Smarter?
package volume_ci;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P10131_3747 {
	public static void main(String[] args) {
		(new P10131_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		List<Elephant> elephantList = new LinkedList<Elephant>();
		int i = 0;
		while (scn.hasNextInt()) {
			Elephant e = new Elephant();
			e.index = ++i;
			e.weight = scn.nextInt();
			e.iq = scn.nextInt();
			elephantList.add(e);
		}

		Collections.sort(elephantList);
		List<Elephant> longestDecreasingIQ = longestDecreasingIQ(elephantList);
		
		System.out.println(longestDecreasingIQ.size());
		for ( Elephant e : longestDecreasingIQ ) {
			System.out.println(e.index);
		}
	}

	private Comparator<Elephant> decreasingIQComparator() {
		return new Comparator<Elephant>() {
			@Override
			public int compare(Elephant o1, Elephant o2) {
				return o2.iq - o1.iq;
			}
		};
	}

	private List<Elephant> longestDecreasingIQ(List<Elephant> elephantList) {
		List<Elephant> decreasingIQ = new LinkedList<Elephant>(elephantList);
		Collections.sort(decreasingIQ, decreasingIQComparator());
		int n = elephantList.size();
		int matrix[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (elephantList.get(i - 1).iq == decreasingIQ
						.get(j - 1).iq) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}
			}
		}

		List<Elephant> finalList = backTrace(matrix, elephantList,
				decreasingIQ, n, n);

		for (int i = 1; i < finalList.size(); ) {
			Elephant prev = finalList.get(i - 1);
			Elephant curr = finalList.get(i);
			if ( curr.iq == prev.iq || curr.weight == prev.weight) {
				finalList.remove(i);
			} else {
				i++;
			}
		}
		return finalList;
	}

	private List<Elephant> backTrace(int[][] matrix,
			List<Elephant> elephantList, List<Elephant> decreasingIQ, int i,
			int j) {
		if (i == 0 || j == 0) {
			return new LinkedList<Elephant>();
		} else if (elephantList.get(i - 1).iq == decreasingIQ.get(j - 1).iq) {
			List<Elephant> interim = backTrace(matrix, elephantList,
					decreasingIQ, i - 1, j - 1);
			interim.add(elephantList.get(i - 1));
			return interim;
		} else if (matrix[i][j - 1] >= matrix[i - 1][j]) {
			return backTrace(matrix, elephantList, decreasingIQ, i, j - 1);
		} else {
			return backTrace(matrix, elephantList, decreasingIQ, i - 1, j);
		}
	}
}

class Elephant implements Comparable<Elephant> {
	int weight, iq, index;

	@Override
	public int compareTo(Elephant o) {
		return this.weight - o.weight;
	}

	public String toString() {
		return this.index + " " + this.weight + " " + this.iq;
	}
}
