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
//@JUDGE_ID:  33089  118  Java  "Mutant Flatworld Explorers"
package volume_i;

import java.util.StringTokenizer;
import java.util.Vector;

class P118_33089 {
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
	
	public static void main(String args[]) // entry point from OS
	{
		P118_33089 myWork = new P118_33089(); // create a dinamic instance
		myWork.Begin();
	}	
	
	void Begin() {
		String input = null;
		//Le o tamanho do grid
		input = readLn();
		StringTokenizer st = new StringTokenizer(input);
		int xMax = Integer.parseInt(st.nextToken());
		int yMax = Integer.parseInt(st.nextToken());
		Vector<String> scent = new Vector<String>();
		
		//Le os robos
		while ((input = readLn()) != null) {
			//Le a posicao e a orientacao
			st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char orientation = st.nextToken().charAt(0);
			
			//Vai lendo e processando as instrucoes
			boolean isLost = false;
			input = readLn();
			for ( int i = 0; i < input.length() && !isLost; i++ ) {
				//Obtem a instrucao
				char inst = input.charAt(i);
				int newx = x;
				int newy = y;
				switch (inst) {
				case 'L':
					switch (orientation) {
					case 'N': 
						orientation = 'W';
						break;
					case 'W': 
						orientation = 'S';
						break;
					case 'S': 
						orientation = 'E';
						break;
					case 'E': 
						orientation = 'N';
						break;
					}
					break;
				case 'R':
					switch (orientation) {
					case 'N': 
						orientation = 'E';
						break;
					case 'E': 
						orientation = 'S';
						break;
					case 'S': 
						orientation = 'W';
						break;
					case 'W': 
						orientation = 'N';
						break;
					}
					break;
				case 'F':
					switch (orientation) {
					case 'N': 
						newy = y + 1;
						break;
					case 'E': 
						newx = x + 1;
						break;
					case 'S': 
						newy = y - 1;
						break;
					case 'W': 
						newx = x - 1;
						break;
					}
					break;	
				}
				if ( newx < 0 || newx > xMax || newy < 0 || newy > yMax ) {
					String s = "";
					s = s + x;
					s = s + "-";
					s = s + y;
					if ( !scent.contains(s) ) {
						isLost = true;
						scent.addElement(s);
					}
				} else {
					x = newx;
					y = newy;
				}
			}
			String resultado = "";
			resultado = resultado + x + " " + y + " " + orientation;
			if ( isLost ) {
				resultado = resultado + " LOST";
			}
			System.out.println(resultado);
		}
	}	
}
