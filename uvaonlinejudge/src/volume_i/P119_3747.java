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
//119 - Greedy Gift Givers
package volume_i;

import java.util.Scanner;
import java.util.StringTokenizer;

class P119_3747 {

	public static void main(String[] args) {
		(new P119_3747()).begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		boolean first = true;
		while (scn.hasNextLine()) {
			if ( !first ) {
				System.out.println();
			} else {
				first = false;
			}
			int qt = Integer.parseInt(scn.nextLine());
			//System.out.println(qt);
			String namesLine = scn.nextLine();
			//System.out.println(namesLine);
			String[] names = new String[qt];
			int[] nw = new int[qt];
			StringTokenizer st = new StringTokenizer(namesLine);
			for (int n = 0; n < qt; n++) {
				names[n] = st.nextToken();
			}

			for (int n = 0; n < qt; n++) {
				String line = scn.nextLine();
				st = new StringTokenizer(line);
				String lineName = st.nextToken();
				int lineIdx = getIdx(lineName, names);
				int totalGive = Integer.parseInt(st.nextToken());
				int totalReceivers = Integer.parseInt(st.nextToken());
				if (totalReceivers != 0) {
					int giftPerPerson = totalGive / totalReceivers;
					nw[lineIdx] -= giftPerPerson * totalReceivers;
					for (int g = 0; g < totalReceivers; g++) {
						String recName = st.nextToken();
						int recIdx = getIdx(recName, names);
						nw[recIdx] += giftPerPerson;
					}
				}
			}

			for (int n = 0; n < qt; n++) {
				System.out.println(names[n] + " " + nw[n]);
			}
		}
	}

	private int getIdx(String lineName, String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(lineName)) {
				return i;
			}
		}
		return 0;
	}
}
