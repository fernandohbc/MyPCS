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
// @JUDGE_ID:  33089  541  Java  "Error Correction"
package volume_v;

import java.util.StringTokenizer;

class P541_33089 {
private static final int INDERTERMINED = -1;
private static final int IMPOSSIBLE = -2;

//	Rotina de Leitura
	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString().trim());
    }
	
	public static void main(String[] args) {
		(new P541_33089()).begin();
	}
			
	private void begin() {
		int n = Integer.parseInt(readLn());
		while (n != 0) {
			int lineSums[] = new int[n];
			int colSums[] = new int[n];
			
			for ( int l = 0; l < n; l++ ) {
				String input = readLn();
				StringTokenizer st = new StringTokenizer(input);
				for ( int c = 0; c < n; c++ ) {
					int elem = Integer.parseInt(st.nextToken());
					lineSums[l] = lineSums[l] + elem;
					colSums[c]  = colSums[c] + elem;
				}
			}
			
			int lineSit = determine(lineSums);
			int colSit = determine(colSums);
			
			if (lineSit == INDERTERMINED && colSit == INDERTERMINED) {
				System.out.println("OK");
			} else if ( lineSit == IMPOSSIBLE || colSit == IMPOSSIBLE  ) {
				System.out.println("Corrupt");
			} else {
				System.out.println("Change bit ("+ (lineSit + 1) + ","+ (colSit + 1) + ")");
			}
			
			n = Integer.parseInt(readLn());
		}
	}

	private int determine(int[] sums) {
		int sit = INDERTERMINED;
		int i = 0;
		while ( sit != IMPOSSIBLE && i < sums.length ) {
			if ( sums[i]%2 == 1 ) {
				if ( sit == INDERTERMINED ) {
					sit = i;
				} else {
					sit = IMPOSSIBLE;
				}
			}
			i++;
		}
		return sit;
	}
}
