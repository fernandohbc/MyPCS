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
// @JUDGE_ID:  33089  499  Java  "What's The Frequency, Kenneth?"
package volume_iv;

class P499_33089 {
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
        return (buffer.toString()).trim();
    }
	
	//Entrada do programa
	public static void main(String args[]) // entry point from OS
    {
		P499_33089 myWork = new P499_33089(); // create a dinamic instance
        myWork.Begin();
    }
	
	//Metodo principal
	void Begin() {
		String input = null;
		int spectrum[] = new int[52];		
		while ((input = readLn()) != null) {
			inicializa( spectrum );
			int maxFreq = 0;
			for ( int i = 0; i < input.length(); i++ ) {
				int pos = idx(input.charAt(i));
				if ( pos < 0 || pos >= 52 ) {
					continue;
				}
				spectrum[pos]++;
				if ( spectrum[pos] > maxFreq ) {
					maxFreq = spectrum[pos];
				}
			}
			
			//Vai imprimindo os que tiverem a maior frequencia... NUM STRINGBUFFER !!
			StringBuffer sb = new StringBuffer();
			for ( int s = 0; s < spectrum.length; s++ ) {
				if ( spectrum[s] == maxFreq ) {
					sb.append(chr(s));
				}
			}
			sb.append(" " + maxFreq);
			System.out.println(sb);
		}
	}

	private char chr(int s) {
		if ( s <= 25 ) {
			return (char)(s + 65);
		} else {
			return (char)(s + 71);
		}
	}

	private int idx(char c) {
		if ( Character.isUpperCase(c) ) {
			return (int)c - 65;
		} else {
			return (int)c - 71;
		}
	}

	private void inicializa(int[] spectrum) {
		for (int i = 0; i < spectrum.length; i++ ) {
			spectrum[i] = 0;
		}		
	}
}
