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
// @JUDGE_ID:  33089  543  Java  "Goldbach's Conjecture"
package volume_v;

class P543_33089 {

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
		(new P543_33089()).begin();
	}
			
	private void begin() {
		long n = Long.parseLong(readLn());
		//for( n = 6; n <= 1000000; n = n + 2 ) {
		while (n != 0) {
			//System.out.println(isPrime(n));
			long maxLimit = n / 2;
			boolean isCorrect = false;
			for ( long a = 3; a <= maxLimit; a = a + 2 ) {				
				if ( isPrime(a) ) {
					long b = n - a;
					if ( isPrime(b) ) {
						System.out.println(n + " = " + a + " + " + b );
						isCorrect = true;
						break;
					}
				}
			}
			if ( !isCorrect ) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			n = Long.parseLong(readLn());
		}
	}

	private boolean isPrime(long a) {
		long maxDiv = Math.round(Math.sqrt(a));
		for ( long div = 2; div <= maxDiv; div = div + 1 ) {
			if ( a%div == 0 ) {
				return false;
			}
		}
		return true;
	}
}
