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
// @JUDGE_ID:  33089  438  Java  "The Circumference of the Circle"
package volume_iv;

import java.util.StringTokenizer;

class P438_33089 {
	//	Rotina de Leitura
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
		(new P438_33089()).begin();
	}

	private void begin() {
		double PI = 3.141592653589793;
		String input = readLn();
		while ( input != null ) {
			StringTokenizer st = new StringTokenizer(input);
			double x1 = new Double(st.nextToken()).doubleValue();
			double y1 = new Double(st.nextToken()).doubleValue();
			double x2 = new Double(st.nextToken()).doubleValue();
			double y2 = new Double(st.nextToken()).doubleValue();
			double x3 = new Double(st.nextToken()).doubleValue();
			double y3 = new Double(st.nextToken()).doubleValue();
			//Calcula as medidas dos lados
			double a = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
			double b = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
			double c = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
			//Aplica a formula de heron
			double p = (a+b+c)/2;
			double r = (a*b*c)/(4*Math.sqrt(p*(p-a)*(p-b)*(p-c)));
			double circunferencia = 2*PI*r;
			//Formata e imprime
			System.out.println(format(circunferencia));
			input = readLn();
		}
	}

	private String format(double circunferencia) {
		circunferencia = Math.round(circunferencia*100) / 100.0;
		String result = String.valueOf(circunferencia);
		while ( result.indexOf('.') > result.length() - 3) {
			result = result + '0';
		}
		return result;
	}	
}
