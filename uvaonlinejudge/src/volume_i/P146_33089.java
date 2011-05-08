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
// @JUDGE_ID:  33089  146  Java  "ID Codes"
package volume_i;

class P146_33089 {
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
		(new P146_33089()).begin();
	}	
	
	private void begin() {
		String input = readLn();
		while( !input.equals("#")) {
			String next = next(input);
			if ( next == null ) {
				next = "No Successor";
			}
			System.out.println(next);
			input = readLn();
		}
	}

	private String next(String string) {
		//Primeiro cria o vetor de maximos e o de presencas, que eh igual no inicio
		int max[] = new int[26];
		int presencas[] = new int[26];
		int maxIdx = -1;
		for ( int i = 0; i < string.length(); i++ ) {
			char chr = string.charAt(i);
			int idx = ord(chr);
			max[idx]++;
			presencas[idx]++;
			if ( idx > maxIdx ) {
				maxIdx = idx;
			} 
		}
		
		//Inicializacoes
		StringBuffer result = new StringBuffer( string );
		int currIdx = string.length() - 1;		
		char currChar = string.charAt(currIdx);
		int nextTry = ord(currChar) + 1;	
//		Retira o caractere do indice corrente
		int currCharIdx = ord(currChar);
		presencas[currCharIdx]--;
		while ( currIdx < string.length() && currIdx >= 0 ) {			
			//Inicia a pesquisa
			while ( nextTry <= maxIdx ) {
				if ( presencas[nextTry] + 1 <= max[nextTry] ) {
					result.setCharAt(currIdx, chr(nextTry));
					presencas[nextTry]++;
					break;
				} else {
					nextTry++;
				}
			}
			
			//Verifica o que fazer na pr�xima iteracao
			if ( nextTry > maxIdx ) {
				//Tem que voltar um caractere
				currIdx--;
				if ( currIdx >= 0 ) {
					currChar = string.charAt(currIdx);
					nextTry = ord(currChar) + 1;
					currChar = string.charAt(currIdx);
					currCharIdx = ord(currChar);
					presencas[currCharIdx]--;
				}
			} else {
				currIdx++;				
				nextTry = 0;
			}
			
		}
		
		if ( currIdx < 0 ) {
			return null;
	 	} else {
	 		return result.toString();
	 	}
	}
	
	private char chr(int idx) {
		return (char)(idx + (int)'a');
	}

	private int ord(char chr) {
		return (int)chr - (int)'a';
	}
}
