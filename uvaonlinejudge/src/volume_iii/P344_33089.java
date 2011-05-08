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
// @JUDGE_ID:  33089  344  Java  "Roman Digititis"
package volume_iii;

class P344_33089 {
	//	Rotina de Leitura
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
		(new P344_33089()).begin();
	}

	private void begin() {
		int[] i = new int[101];
		int[] v = new int[101];
		int[] x = new int[101];
		int[] l = new int[101];
		int[] c = new int[101];
		for ( int n = 1; n <= 100; n++ ) {
			i[n] = i[n-1];
			v[n] = v[n-1];
			x[n] = x[n-1];
			l[n] = l[n-1];
			c[n] = c[n-1];
			String roman = romanize(n);
			for ( int chr = 0; chr < roman.length(); chr++ ) {
				switch (roman.charAt(chr)) {
				case 'i': i[n]++; break;
				case 'v': v[n]++; break;
				case 'x': x[n]++; break;
				case 'l': l[n]++; break;
				case 'c': c[n]++; break;
				}
			}
		}
		
		int e = Integer.parseInt(readLn());
		while ( e != 0 ) {
			System.out.println(e+": "+i[e]+" i, "+v[e]+" v, "+x[e]+" x, "+l[e]+" l, "+c[e]+" c");
			e = Integer.parseInt(readLn());
		}
	}
	
	private String romanize( int n ) {
		switch (n) {
		case 0: return "";
		case 1: return "i";
		case 2: return "ii";
		case 3: return "iii";
		case 4: return "iv";
		case 5: return "v";
		case 6: return "vi";
		case 7: return "vii";
		case 8: return "viii";
		case 9: return "ix";
		case 10: return "x";
		case 20: return "xx";
		case 30: return "xxx";
		case 40: return "xl";
		case 50: return "l";
		case 60: return "lx";
		case 70: return "lxx";
		case 80: return "lxxx";
		case 90: return "xc";
		case 100: return "x";
		default: return romanize(n/10*10) + romanize(n%10);
		}
	}
}
