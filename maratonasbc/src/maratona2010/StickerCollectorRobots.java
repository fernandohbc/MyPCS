/*******************************************************************************
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
 ******************************************************************************/
package maratona2010;

import java.util.Scanner;

public class StickerCollectorRobots {
    public static void main(String[] args) {
        new StickerCollectorRobots().run();
    }

    private char grid[][];
    private int lr = -1;
    private int lin;
    private int cr = -1;
    private int col;
    private char or = ' ';
    private int stickers;

    private void run() {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        while (!line.trim().equals("0 0 0")) {
            String input[] = line.trim().split(" ");
            stickers = 0;
            lr = -1;
            cr = -1;
            lin = Integer.parseInt(input[0]);
            col = Integer.parseInt(input[1]);
            grid = new char[lin][];
            for (int l = 0; l < lin; l++) {
                grid[l] = scn.nextLine().toCharArray();
                if (lr == -1) {
                    for (int c = 0; c < col; c++) {
                        if (grid[l][c] == 'N' || grid[l][c] == 'S'
                                || grid[l][c] == 'L' || grid[l][c] == 'O') {
                            lr = l;
                            cr = c;
                            or = grid[l][c];
                        }
                    }
                }
            }

            // Começa a simulação...
            String commands = scn.nextLine();
            for (char comm : commands.toCharArray()) {
                apply(comm);
            }

            System.out.println(stickers);

            line = scn.nextLine();
        }
    }

    private void apply(char comm) {
        switch (comm) {
        case 'F':
            moveForward();
            break;

        case 'E':
            turnLeft();
            break;

        case 'D':
            turnRight();
            break;

        default:
            break;
        }
    }

    private void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void turnLeft() {
        switch (or) {
        case 'N':
            or = 'O';
            break;

        case 'O':
            or = 'S';
            break;

        case 'S':
            or = 'L';
            break;

        case 'L':
            or = 'N';

        default:
            break;
        }
    }

    private void moveForward() {
        switch (or) {
        case 'N':
            if (lr > 0 && grid[lr - 1][cr] != '#') {
                lr--;
            }
            break;

        case 'S':
            if (lr < lin - 1 && grid[lr + 1][cr] != '#') {
                lr++;
            }
            break;

        case 'O':
            if (cr > 0 && grid[lr][cr - 1] != '#') {
                cr--;
            }
            break;

        case 'L':
            if (cr < col - 1 && grid[lr][cr + 1] != '#') {
                cr++;
            }
            break;

        default:
            break;
        }

        if (grid[lr][cr] == '*') {
            stickers++;
            grid[lr][cr] = '.';
        }
    }
}
