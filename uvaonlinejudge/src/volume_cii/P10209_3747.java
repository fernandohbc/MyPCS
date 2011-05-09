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
//Problem 10209 - Is This Integration ?
package volume_cii;

import java.util.Scanner;

public class P10209_3747 {
	public static void main(String[] args) {
		new P10209_3747().begin();
	}

	private void begin() {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextDouble()) {
			double a = scn.nextDouble();
			System.out.printf("%.3f %.3f %.3f%n", campo1(a), campo2(a),
					campo3(a));
		}
	}

	private double campo3(double a) {
		if ( a == 0 ) {
			return 0;
		}
		return 4*(a * a - (a * a * (3 * Math.sqrt(3) + 2 * Math.PI)) / 12);
	}

	private double campo2(double a) {
		if ( a == 0 ) {
			return 0;
		}
		return 4 * (a3(a) + a4(a));
	}

	private double a4(double a) {
		return a * a * (3 * Math.sqrt(3) + 2 * Math.PI) / 24 - j(a)
				* Math.sqrt(a * a - j(a) * j(a)) / 2 - a * a
				* Math.asin(j(a) / a) / 2 - (a - j(a))
				* Math.sqrt(a * a - (a - j(a)) * (a - j(a))) / 2 - a * a
				* Math.asin((a - j(a)) / a) / 2 + a * Math.sqrt(3 * a * a / 4)
				/ 4 + a * a * Math.asin(0.5) / 2;
	}

	private double a3(double a) {
		return j(a) * Math.sqrt(a * a - j(a) * j(a)) / 2 + a * a
				* Math.asin(j(a) / a) / 2 - a1(a) - a2(a);
	}

	private double a2(double a) {
		return campo3(a) / 8;
	}

	private double a1(double a) {
		return j(a) * a / 2;
	}

	private double j(double a) {
		return a * (2 - Math.sqrt(3)) / 2;
	}

	private double campo1(double a) {
		if ( a == 0 ) {
			return 0;
		}
		return a * a - campo2(a) - campo3(a);
	}
}
