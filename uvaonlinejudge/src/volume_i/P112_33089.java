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
// @JUDGE_ID:  33089  112  Java  "Tree Summing"
package volume_i;

import java.util.StringTokenizer;

class P112_33089 {
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
		(new P112_33089()).begin();
	}

	private void begin() {
		Integer target = getInteger();
		while ( target != null ) {
			//Monta a arvore			
			StringBuffer arvoreBuf = new StringBuffer();
			arvoreBuf.append(getChar());
			int count = 1;
			while ( count > 0 ) {
				char chr = getChar();
				if ( chr == '(' ) {
					count++;
				} else if ( chr == ')' ) {
					count--;
				}
				arvoreBuf.append(chr);
			}
			String arvore = arvoreBuf.toString();
			Node n = toNode( arvore );
			
			if ( somaFolhas(n,0,target.intValue()) ) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			target = getInteger();
		}
	}
	
	String currTok = "";
	int pos;
	private char getChar() {
		while ( pos == currTok.length() ) {
			if (st == null || !st.hasMoreTokens()) {
				input = readLn();
				st = new StringTokenizer( input );
			}
			if ( st.hasMoreTokens() ) {
				currTok = st.nextToken();
			} else {
				currTok = "";
			}
			pos = 0;
		}
		return currTok.charAt(pos++);
	}

	String input;
	StringTokenizer st;
	private Integer getInteger() {
		if (st == null || !st.hasMoreTokens()) {
			input = readLn();
			if ( input != null ) {
				st = new StringTokenizer( input );
			} else {
				return null;
			}
		}
		String tok = st.nextToken();
		return new Integer(tok);
	}

	private boolean somaFolhas(Node n, int soFar, int target) {
		if ( n == null ) {
			return false;
		}
		if ( n.isFolha() ) {
			return (soFar + n.num == target);
		} else {
			return somaFolhas( n.left, soFar + n.num, target ) || 	somaFolhas( n.right, soFar + n.num, target );
		}
	}

	private Node toNode(String tree) {
		
		if ( tree.equals("()") ) {
			return null;
		}
//		Ignora o primeiro (		
		String crop = tree.substring(1);
		
		//Obtem o numero
		String numStr = crop.substring(0, crop.indexOf('(') );
		int num = Integer.parseInt( numStr );
		Node result = new Node();
		result.num = num;
		
		//Arvore esquerda
		int initLeft = crop.indexOf('(');
		int finalLeft = initLeft + 1;
		int count = 1;
		while ( count > 0 ) {
			if ( crop.charAt(finalLeft) == '(' ) {
				count++;
			} else if ( crop.charAt(finalLeft) == ')' ) {
				count--;
			}
			finalLeft++;
		}
		String left = crop.substring(initLeft, finalLeft);
		String right = crop.substring( finalLeft, crop.length() - 1 );
		result.left = toNode( left );
		result.right = toNode( right );
		return result;
	}
}

class Node {
	int num;
	Node left;
	Node right;
	public boolean isFolha() {
		return left == null && right == null;
	}
}
