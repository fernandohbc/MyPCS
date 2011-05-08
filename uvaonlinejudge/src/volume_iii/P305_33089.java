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
// @JUDGE_ID:  33089  305  Java  "Joseph"
package volume_iii;

class P305_33089 {
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
		(new P305_33089()).begin();
	}	
	
	private void begin() {
		int n = Integer.parseInt(readLn());
		long respostas[] = {  0,2,7,5,30,169,441,1872,7632,1740,93313,459901,1358657,2504881 };
		while ( n != 0 ) {
//			int m = 0;
//			boolean determinado = false;
//			while ( !determinado ) {
//				m++;
//				//System.out.println(m);
//				boolean offZones[] = new boolean[2*n];
//				int hops = 0;
//				//Desliga o primeiro
//				int offCount =0;
//				int i = 0;
//				//Enquanto a zona 12 (13-1) estiver ligada
//				while ( true ) {
//					if ( !offZones[i%(2*n)] ) {
//						hops++;
//					}
//					if ( hops == m ) {
//						offZones[i%(2*n)] = true;
//						if ( i%(2*n) < n ) {
//							break;
//						}
//						offCount++;
//						hops = 0;
//					}
//					i++;
//				}
//				determinado = (offCount == n);
//			}			
			//PRECALC
			System.out.println(respostas[n]);
			//System.out.println("values["+n+"] = " + m);
			n = Integer.parseInt(readLn());
		}
	}
}
