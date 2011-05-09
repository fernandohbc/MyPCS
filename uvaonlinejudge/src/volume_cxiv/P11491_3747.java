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
//11491 - Erasing and Winning
package volume_cxiv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class P11491_3747 {

	public static void main(String[] args) {
		try {
			(new P11491_3747()).begin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void begin() throws IOException {
		//Scanner scn = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//String ln = scn.nextLine();
		String ln = in.readLine();
		StringTokenizer st = new StringTokenizer( ln );
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		while ( d != 0 || n != 0 ) {
			//String num = scn.nextLine();
			String num = in.readLine();
			Lista head = null;
			Lista tail = null;
			for ( int p = 0; p < d; p++ ) {
				Lista elm = new Lista( num.charAt(p) );
				if ( head == null ) {
					head = elm;
				}
				if ( tail != null ) {
					tail.setNext( elm );
				}
				tail = elm;
			}
			Lista elm = head;
			int del = 0;
			while ( del < n && elm != null && elm.getNext() != null ) {
				if ( elm.getChar() < elm.getNext().getChar() ) {
					if ( elm.getPrev() != null ) {
						elm.getPrev().setNext(elm.getNext());
						elm = elm.getNext().getPrev();
					} else {
						head = elm.getNext();
						elm = elm.getNext();
						elm.setPrev(null);
					}
					del++;
				} else {
					elm = elm.getNext();
				}
			}
			elm = head;
			for ( int o = 0; o < (d-n); o++ ) {
				sb.append(elm.getChar());
				elm = elm.getNext();
			}
			sb.append("\n");
			ln = in.readLine();
			st = new StringTokenizer( ln );
			d = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
		}
		System.out.print(sb);
	}
}

class Lista {
	public Lista(char c) {
		next = null;
		element = c;
		prev = null;
	}
	
	public void setPrev(Lista prev) {
		this.prev = prev;		
	}

	public Lista getPrev() {
		return prev;
	}

	public Lista getNext() {
		return next;
	}

	public char getChar() {
		return element;
	}

	public void setNext(Lista elm) {
		next = elm;
		elm.prev = this;
	}
	
	private Lista prev;
	private char element;
	private Lista next;
}
