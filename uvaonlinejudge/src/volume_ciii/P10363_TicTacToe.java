/* MyPCS - My Programming Contests Solutions
 *
 * email: fernandohbc@gmail.com
 * Google+: plus.google.com/117689849496467534996
 *  
 * 
 * SPOILER ALERT!
 * These are the solutions for problems from Programming Contests and Online
 * Judges. Seeing an accepted code before getting accepted by oneself is uncool.
 * 
 * Q: So why are the solutions being made available?
 * A: For educational purposes only. Some of the problems can be used in Contests
 * training (even if it is to show how NOT to do :-) ) and also can serve to
 * compare solutions and algorithms. Also, the author thinks it is cool to have
 * his code well versioned.
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

package volume_ciii;

import java.util.Scanner;

/**
 * UVa Online Judge Problem #10363 - Tic Tac Toe
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 */
public class P10363_TicTacToe {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int tc = Integer.parseInt(scn.nextLine().trim());

    for (int t = 0; t < tc; t++) {
      if (t > 0) {
        // Ignores empty line
        scn.nextLine();
      }
      char board[][] = new char[3][];
      for (int i = 0; i < 3; i++) {
        board[i] = scn.nextLine().trim().toUpperCase().toCharArray();
      }
      System.out.println(isValid(board) ? "yes" : "no");
    }
  }

  private static boolean isValid(char[][] board) {
    int xCount = 0;
    int oCount = 0;

    // Counts occurrencies
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char c = board[i][j];
        if (c == 'X') {
          xCount++;
        } else if (c == 'O') {
          oCount++;
        }
      }
    }

    // x - o must be 0 or 1
    int diff = xCount - oCount;
    if (diff < 0 || diff > 1) {
      return false;
    }

    // Wins must be 0 or 1
    boolean xWins = playerWins(board, 'X');
    boolean oWins = playerWins(board, 'O');

    if (xWins && oWins) {
      return false;
    }

    // If X wins, xCount must be one more than oCount
    // If O wins, xCount must be equal to oCount
    if ((xWins && diff == 0) || (oWins && diff == 1)) {
      return false;
    }

    return true;
  }

  private static boolean playerWins(char[][] board, char c) {
    // Lines
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
        return true;
      }
    }

    // Columns
    for (int j = 0; j < 3; j++) {
      if (board[0][j] == c && board[1][j] == c && board[2][j] == c) {
        return true;
      }
    }

    // Diagonals
    if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
      return true;
    }
    if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
      return true;
    }

    return false;
  }
}
