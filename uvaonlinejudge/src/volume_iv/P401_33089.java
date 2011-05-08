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
//@JUDGE_ID:  33089  401  Java  "Palindromes"
package volume_iv;

class P401_33089 {
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
		(new P401_33089()).begin();
	}
	
	private final int MIRROREDPALINDROME = 0;
	private final int MIRRORED = 1;
	private final int PALINDROME = 2;
	private final int NOTHING = 4;
	private void begin() {
		String input = readLn();
		while ( input != null ) {
			int result = process(input);
			switch (result) {
			case MIRROREDPALINDROME: System.out.println(input + " -- is a mirrored palindrome.\n"); break;
			case PALINDROME: System.out.println(input + " -- is a regular palindrome.\n"); break;
			case MIRRORED: System.out.println(input + " -- is a mirrored string.\n"); break;
			case NOTHING: System.out.println(input + " -- is not a palindrome.\n"); break;
			}
			input = readLn();
		}
	}

	private int process(String input) {
		boolean isMirrored = true;
		boolean isPalindrome = true;
		StringBuffer aux = new StringBuffer(input);
		aux.reverse();
		String reverse = aux.toString();
		int i = 0;
		int tam = input.length();
		while ( (i <= tam / 2) && (isPalindrome || isMirrored)) {
			char iChar = input.charAt(i);
			char rChar = reverse.charAt(i);
			if ( iChar != rChar ) {
				isPalindrome = false;
			}
			if ( iChar != mirror(rChar) ) {
				isMirrored = false;
			}
			i++;
		}
		if ( isPalindrome && isMirrored ) {
			return MIRROREDPALINDROME;
		} else {
			if ( isPalindrome ) {
				return PALINDROME;
			} else if ( isMirrored ) {
				return MIRRORED;
			} else {
				return NOTHING;
			}
		}
	}

	private char mirror(char chr) {
		switch (chr) {
		case 'A': return 'A';
		case 'E': return '3';
		case 'H': return 'H';
		case 'I': return 'I';
		case 'J': return 'L';
		case 'L': return 'J';
		case 'M': return 'M';
		case 'O': return 'O';
		case 'S': return '2';
		case 'T': return 'T';
		case 'U': return 'U';
		case 'V': return 'V';
		case 'W': return 'W';
		case 'X': return 'X';
		case 'Y': return 'Y';
		case 'Z': return '5';
		case '1': return '1';
		case '2': return 'S';
		case '3': return 'E';
		case '5': return 'Z';
		case '8': return '8';
		default: return '.';
		}
	}
}
