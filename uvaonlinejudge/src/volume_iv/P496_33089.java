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
// @JUDGE_ID:  33089  496  Java  "Simply Subsets"
package volume_iv;

import java.util.StringTokenizer;
import java.util.Vector;

class P496_33089 {
	//Rotina de Leitura
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
		P496_33089 myWork = new P496_33089(); // create a dinamic instance
        myWork.Begin();
    }
	
	//Metodo principal
	void Begin() {
		String input = null;
		while ((input = readLn()) != null) {
			//Leu o primeiro conjunto: separa os elementos
			StringTokenizer st = new StringTokenizer(input);
			Vector a = new Vector();
			int qtdA = st.countTokens();
			for ( int i = 0; i < qtdA; i++ ) {
				int elemento = Integer.parseInt(st.nextToken());
				a.addElement(new Integer( elemento ));
			}
			
			//Le o segundo conjunto
			input = readLn();
			st = new StringTokenizer(input);
			int qtdB   = st.countTokens();
			int qtdInt = 0;
			for ( int i = 0; i < qtdB; i++ ) {
				int elemento = Integer.parseInt(st.nextToken());
				if ( a.contains(new Integer(elemento))) {
					qtdInt++;
				}
			}
			
			//Verifica a resposta
			if ( qtdA == qtdB && qtdInt == qtdA ) {
				System.out.println("A equals B");
			} else if ( qtdA > qtdB && qtdInt == qtdB ) {
				System.out.println("B is a proper subset of A");
			} else if ( qtdB > qtdA && qtdInt == qtdA ) {
				System.out.println("A is a proper subset of B");
			} else if ( qtdInt == 0 ) {
				System.out.println("A and B are disjoint");
			} else {
				System.out.println("I'm confused!");
			}
		}
	}
}
