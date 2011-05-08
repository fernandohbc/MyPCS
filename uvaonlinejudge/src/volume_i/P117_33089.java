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
//@JUDGE_ID:  33089  117  Java  " The Postal Worker Rings Once"
package volume_i;


class P117_33089 {
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
		P117_33089 myWork = new P117_33089(); // create a dinamic instance
		myWork.Begin();
	}	

	void Begin() {
		int graph[][] = new int[26][];
		for ( int o = 0; o < 26; o++ ) {
			graph[o] = new int[26];
		}
		String input;
		while ((input = readLn()) != null) {
			inicializaGrafo( graph );
			int soma = 0;
			do {
				//Obtem o tamanho, a origem e o destino...
				int tamanho = input.length();
				int origem  = input.charAt(0) - (int)'a';
				int destino = input.charAt(tamanho - 1) - (int)'a';
				//System.out.println(tamanho + "\t" + origem +  "\t" + destino);
				
				//Vai povoando o grafo
				graph[origem][destino] = tamanho;
				graph[destino][origem] = tamanho;
				
				//Vai somando os tamanhos
				soma += tamanho;
				input = readLn();
			} while (!input.equals( "deadend" ));
			
//			Procura pela quantidade de v�rtices com grau impar...
			int origem = -1;
			int destino = -1;
			for ( int o = 0; o < 26 && destino == -1; o++ ) {
				int grau = 0;
				for ( int d = 0; d < 26; d++ ) {
					if ( graph[o][d] != -1 ) {
						grau++; 
					}
				}
				if ( grau%2 == 1 ) {
					if ( origem == -1 ) {
						origem = o;
					} else {
						destino = o;
					}
				}
			}
			
//			Se precisar, calcula a menor dist�ncia...
			if ( destino != -1 ) {
				soma += menorDistancia( graph, origem, destino );
			}
			
			//Imprime a soma
			System.out.println(soma);
			soma = 0;
		}		
	}



	private void inicializaGrafo(int[][] graph) {
		for ( int o = 0; o < 26 ; o++ ) {
			for ( int d = 0; d < 26; d++ ) {
				graph[o][d] = -1;				
			}			
		}
	}



	private int menorDistancia(int[][] graph, int origem, int destino) {
		//Inicializa o array das dist�ncias...
		int distancias[] = new int[26];
		boolean visitados[] = new boolean[26];
		for ( int d = 0; d < 26; d++ ) {
			distancias[d] = Integer.MAX_VALUE;
			visitados[d] = false;
		}
		distancias[origem] = 0;
		
		int o = extractMinimum(distancias, visitados);
		while ( o != -1 ) {			
			for ( int d = 0; d < 26; d++ ) {
				if ( graph[o][d] != -1 ) {
					//Se n�o tiver sido visitado, coloca na fila
					if ( !visitados[d] ) {
						//Ajusta a distancia...
						if ( distancias[d] > distancias[o] + graph[o][d]) {
							distancias[d] = distancias[o] + graph[o][d];
						}
					
						
					}
				}
			}
//			Coloca nos visitados
			visitados[o] = true;
			o = extractMinimum(distancias, visitados);
		}
		
		return distancias[destino];
	}



	private int extractMinimum(int[] distancias, boolean[] visitados) {
		int candidate = -1;
		int closest = Integer.MAX_VALUE;
		for ( int d = 0; d < 26; d++ ) {
			if ( !visitados[d] && distancias[d] < closest ) {
				candidate = d;
				closest = distancias[d];
			}
		}
		return candidate;
	}
}
