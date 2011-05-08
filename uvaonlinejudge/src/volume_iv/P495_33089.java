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
//@JUDGE_ID:  33089  495  Java  "Fibonacci Freeze"
package volume_iv;

class P495_33089 {
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
		P495_33089 myWork = new P495_33089(); // create a dinamic instance
		myWork.Begin();
	}	
	
	void Begin() {
		int fibo[][] = new int[5000][];
		fibo[0] = new int[1];
		fibo[0][0] = 1;
		fibo[1] = new int[1];
		fibo[1][0] = 1;
		int lastCalculated = 1;
		String input = null;		
		//Le os robos
		while ((input = readLn()) != null) {
			int idx = Integer.parseInt(input);
			if ( idx == 0 ) {
				System.out.println("The Fibonacci number for 0 is 0");
			} else {				
				System.out.print("The Fibonacci number for " + idx + " is ");
				idx--;
				if ( idx > lastCalculated ) {
					for ( int f = lastCalculated+1; f <= idx; f++ ) {
						fibo[f] = add(fibo[f-1], fibo[f-2]);
					}
					lastCalculated = idx;
				}

				StringBuffer sb = new StringBuffer();
				int i = fibo[idx].length - 1;
				if ( fibo[idx][i] != 0 ) {
					sb.append(fibo[idx][i]);			
				}
				i--;
				for ( ; i >= 0; i-- ) {
					sb.append(fibo[idx][i]);
				}
				System.out.println(sb.toString());
			}			
		}
	}

	private int[] add(int[] bigger, int[] smaller) {
		//Verifica o tamanho e instancia o vetor
		int tamanho = bigger.length;
		if ( bigger[tamanho - 1] != 0 ) {
			tamanho++;
		}
		int[] result = new int[tamanho];
		
		//comeca a soma... indo at� o menor...
		int carry = 0;
		for ( int i = 0; i < smaller.length; i++ ) {
			int soma = bigger[i] + smaller[i] + carry;
			carry = soma / 10;
			result[i] = soma % 10;
		}
		
		//Se o maior for mais longo...
		if ( bigger.length > smaller.length ) {
			for ( int i = smaller.length; i < bigger.length; i++ ) {
				int soma = bigger[i] + carry;
				carry = soma / 10;
				result[i] = soma % 10;
			}
		}
		
		//Se sobrou carry...
		if ( carry != 0 ) {
			result[tamanho-1] = carry;
		}
		
		return result;
	}	
}
