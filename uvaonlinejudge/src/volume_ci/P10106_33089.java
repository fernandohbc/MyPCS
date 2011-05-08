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
// @JUDGE_ID:  33089  10106  Java  "Product"
package volume_ci;

class P10106_33089 {
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
		(new P10106_33089()).begin();
	}
	
	private void begin() {
		String input = readLn();
		while (input != null ) {
			int a[] = toIntArray(input);
			input = readLn();
			int b[] = toIntArray(input);
			int v[] = multiplica(a, b);
			write(v);
			input = readLn();
		}
	}

	private int[] toIntArray(String input) {
		int tam = input.length();
		int result[] = new int[tam];
		int i = tam-1;
		for ( int j = 0; j < tam; j++ ) {			
			result[i] = Character.getNumericValue(input.charAt(j));
			i--;
		}
		return result;
	}

	private void write(int[] v) {		
		int i = v.length - 1;
		while ( i >= 0 && v[i] == 0) {
			i--;			
		}
		if ( i == -1 ) {
			System.out.println("0");
		} else {
			StringBuffer sb = new StringBuffer();
			for ( ; i >= 0; i-- ) {
				sb.append(v[i]);
			}
			System.out.println(sb.toString());
		}
	}

	private int[] multiplica(int a[], int b[]) {
		int result[] = new int[502];
		
		//Passada por b para encontrar o primeiro item n�o nulo
		int maxOffSet = b.length-1;
		while ( maxOffSet >= 0 && b[maxOffSet] == 0 ) {
			maxOffSet--;
		}
				
		int offSet = 0;
		while ( offSet <= maxOffSet ) {
			int carry = 0;
			int pos = offSet;
			for ( int i = 0; i < a.length; i++ ) {
				int partial = a[i] * b[offSet] + result[pos] + carry;
				result[pos] = partial%10;
				carry = partial / 10;
				pos++;
			}
			while ( carry != 0 ) {
				int partial = result[pos] + carry;
				result[pos] = partial%10;
				carry = partial / 10;
				pos++;
			}
			offSet++;
		}
		
		return result;
	}
}
