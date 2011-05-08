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
// @JUDGE_ID:  33089  138  Java  "Street Numbers"
package volume_i;

class P138_33089 {
	public static void main(String[] args) {
		(new P138_33089()).precalculated();
	}
	
	private void precalculated() {
		System.out.println("         6         8");
		System.out.println("        35        49");
		System.out.println("       204       288");
		System.out.println("      1189      1681");
		System.out.println("      6930      9800");
		System.out.println("     40391     57121");
		System.out.println("    235416    332928");
		System.out.println("   1372105   1940449");
		System.out.println("   7997214  11309768");
		System.out.println("  46611179  65918161");
	}
	
	@SuppressWarnings("unused")
	private void begin() {
		int lineCount = 0;
		for ( long n = 6; n < Long.MAX_VALUE; n++ ) {
			//Somatorio ateh n
			long D = n * (n + 1) / 2;
			//Somatorio ateh nl = n - 1
			long S = D - n;			
			//Delta da equacao de baskhara
			long delta = 1 + 8 * (D+S);
			//Calula o Nh
			double Nh = (-1 + Math.sqrt(delta))/2.0;
			
			//Se o Nh for exato imprime e incrementa o lineCount
			if ( Nh == Math.floor(Nh) ) {
				System.out.println( "System.out.println(\"" + format(n) + format(Math.round(Math.floor(Nh))) + "\");");
				lineCount++;
				if ( lineCount == 10 ) {
					break;
				}
			}
		}
	}

	private String format(long l) {
		String result = String.valueOf(l);
		while ( result.length() < 10 ) {
			result = ' ' + result;
		}
		return result;
	}
}
