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
//@JUDGE_ID:  33089  492  Java  "Pig-Latin"
package volume_iv;

class P492_33089 {
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
		(new P492_33089()).begin();
	}

	private void begin() {
		String input = readLn();
		while (input != null) {
			StringBuffer out = new StringBuffer();
			int c = 0;
			// Se for um espa�o, j� coloca na sa�da
			while (c < input.length()) {
				if (!isLetter(input.charAt(c))) {
					out.append(input.charAt(c));
					c++;
				} else {
					// Obtem a palavra...
					int end = c + 1;
					while (end < input.length() && isLetter(input.charAt(end))) {
						end++;
					}
					StringBuffer sb = new StringBuffer(input.substring(c, end));

					// Transforma em PigLatin e adiciona
					String pig = toPigLatin(sb);
					out.append(pig);
					c = end;
				}
			}
			System.out.println(out);
			input = readLn();
		}
	}

	private String toPigLatin(StringBuffer sb) {
		char c = sb.charAt(0);
		String result = sb.toString();
		if (!isVowel(c)) {
			//sb.delete(0, 1);
			result = sb.toString();
			result = result.substring(1);
			result = result + c;
		}
		result = result + "ay";
		return result;
	}

	private boolean isVowel(char c) {
		return (c == 'a') || (c == 'A') || (c == 'e') || (c == 'E')
				|| (c == 'i') || (c == 'I') || (c == 'o') || (c == 'O')
				|| (c == 'u') || (c == 'U');
	}

	private boolean isLetter(char c) {
		int aux = (int) c;
		return ((aux >= 65 && aux <= 90) || (aux >= 97 && aux <= 122));
	}
}
