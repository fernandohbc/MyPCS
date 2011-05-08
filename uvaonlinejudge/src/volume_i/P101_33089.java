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
// @JUDGE_ID:  33089  101  Java  "The Blocks Problem"
package volume_i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

class P101_33089 {
//	Rotina de Leitura
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String readLn() {
        try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
	
	public static void main(String[] args) {
		(new P101_33089()).begin();
	}
	
	private Vector<Integer>[] stacks;
	private int location[];
	private int n;
	
	@SuppressWarnings("unchecked")
	private void begin() {
//		System.out.println(Long.MAX_VALUE);
		n = Integer.parseInt(readLn());
		
		//Inicializa os blocos
		stacks = new Vector[n];
		location = new int[n];
		for ( int i = 0; i < n; i++ ) {
			stacks[i] = new Vector<Integer>();
			stacks[i].addElement(new Integer(i));
			location[i] = i;
		}
		String input = readLn();
//		writeStacks();
		while (!input.equals("quit")) {
			StringTokenizer st = new StringTokenizer( input );
			
			//Le a primeira o comando
			String firstCommand = st.nextToken();
			int firstBlock = Integer.parseInt(st.nextToken());
			int firstStack = location[ firstBlock ];
			String secondCommand = st.nextToken();
			int secondBlock = Integer.parseInt(st.nextToken());
			int secondStack = location[ secondBlock ];
			
			//So processa se as pilhas forem diferentes
			if ( firstStack != secondStack ) {
				//Processa a primeira parte do comando
				if ( firstCommand.equals("move") ) {
					clearTop( firstStack, firstBlock );
				}
				
//				Processa a segunda parte do comando
				if ( secondCommand.equals("onto") ) {
					clearTop( secondStack, secondBlock );
				}
				
				//Faz o empilhamento...
				moveStack( firstStack, firstBlock, secondStack );
				
//				writeStacks();
			}
			input = readLn();
		}
		
		writeStacks();
		
	}

	private void writeStacks() {
		StringBuffer sb = new StringBuffer();
		for ( int i = 0; i < n; i++ ) {
			sb.append(i + ":");
			for ( int b = 0; b < stacks[i].size(); b++ ) {
				int block = ((Integer)(stacks[i].elementAt(b))).intValue();
				sb.append(" " + block);
			}
			if ( i < n - 1 ) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private void moveStack(int firstStack, int firstBlock, int secondStack) {
		//Verifica a posi��o do bloco na pilha
		int pos = stacks[firstStack].indexOf(new Integer(firstBlock));
		while( pos < stacks[firstStack].size() ) {
			int block = ((Integer)(stacks[firstStack].elementAt(pos))).intValue();
			//Remove o elemento
			stacks[firstStack].removeElementAt(pos);
			//Coloca na outra pilha
			stacks[secondStack].addElement(new Integer(block));
			//Muda o location do bloco
			location[block] = secondStack;
		}
	}

	private void clearTop(int stack, int block) {
		//Enquanto o bloco procurado nao estiver no topo
		int topo = ((Integer)(stacks[stack].elementAt(stacks[stack].size()-1))).intValue();
		while ( topo != block ) {
			//Retira e volta a posicao original
			stacks[stack].removeElementAt(stacks[stack].size()-1);
			stacks[topo].addElement(new Integer(topo));
			location[topo] = topo;
			
			topo = ((Integer)(stacks[stack].elementAt(stacks[stack].size()-1))).intValue();
		}
	}
}
