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
//@JUDGE_ID:  33089  103  Java  "Stacking Boxes"
package volume_i;

import java.util.StringTokenizer;

class P103_33089 {
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
		(new P103_33089()).begin();
	}
	
	
	private void begin() {
		String input = readLn();
		while (input != null ) {
			StringTokenizer st = new StringTokenizer(input);
			int n   = Integer.parseInt(st.nextToken());
			Box boxes[] = new Box[n];
			int dim = Integer.parseInt(st.nextToken());
			for ( int b = 0; b < n; b++ ) {
				input = readLn();
				st = new StringTokenizer(input);
				int boxArray[] = new int[dim];
				for ( int i = 0; i < dim; i++ ) {
					boxArray[i] = Integer.parseInt(st.nextToken());
				}
				boxes[b] = new Box(b+1,boxArray);
			}
			
			//Ordena as caixas com a maior no comeco
			bubblesort(boxes);
			
			int maxNested[] = new int[n];
			int previous[]  = new int[n];
			int localMax = -1;
			int globalMax = -1;
			for ( int i = 0; i < n; i++ ) {
				maxNested[i] = 1;
				previous[i] = -1;
				for ( int j = 0; j < i; j++ ) {
					if ( maxNested[j] + 1 > maxNested[i] && boxes[i].fitsIn(boxes[j]) ) {
						maxNested[i] = maxNested[j] + 1;
						previous[i] = j;
					}
				}
				if (maxNested[i] > globalMax) {
					globalMax = maxNested[i];
					localMax = i;
				}
				
			}
			
			//Imprime a sequencia
			int idx = localMax;
			System.out.println(globalMax);
			for ( int i = 0; i < globalMax; i++ ) {
				System.out.print(boxes[idx].id);
				if ( i != globalMax - 1 ) {
					System.out.print( " ");
				}
				idx = previous[idx];
			}
			System.out.println();
			
			//Inicia 
			input = readLn();
		}
	}

	private void bubblesort(Box[] boxes) {
		int n = boxes.length;
		boolean swapped;
		do {
			swapped = false;
			n = n - 1;
			for (int i = 0; i < n; i++) {
				if (boxes[i].boxArray[0] < boxes[i + 1].boxArray[0]) {
					Box aux = boxes[i];
					boxes[i] = boxes[i + 1];
					boxes[i + 1] = aux;
					swapped = true;
				}
			}
		} while (swapped);
	}		
	
}

class Box {
	int id;
	int dim;
	int boxArray[];

	public Box(int id, int[] boxArray) {
		this.id = id;
		this.dim = boxArray.length;
		this.boxArray = boxArray;
		sort();
	}

	public boolean fitsIn(Box box) {
		for ( int i = 0; i < dim; i++ ) {
			if (this.boxArray[i] >= box.boxArray[i]) {
				return false;
			}
		}
		return true;
	}

	private void sort() {
		//Primeira passada para ver o low e o high boundary
		int low = boxArray[0];
		int high = boxArray[0];
		for ( int i = 1; i < dim; i++ ) {
			if (boxArray[i] < low) {
				low = boxArray[i];
			}
			if (boxArray[i] > high) {
				high = boxArray[i];
			}
		}
		
		//Cria o array de contagem
		int bucket[] = new int[high-low+1];
		
		//Segunga passada para contar
		for ( int i = 0; i < dim; i++ ) {
			int idx = boxArray[i] - low;
			bucket[idx]++;
		}
		
		int idx = 0;
		//Terceira passada para ordenar
		for (int i = high - low; i >= 0 ; i-- ) {
			int qtd = bucket[i]; 
			while (qtd > 0) {
				boxArray[idx] = i + low;
				idx++;
				qtd--;
			}
		}
	}
	
}
