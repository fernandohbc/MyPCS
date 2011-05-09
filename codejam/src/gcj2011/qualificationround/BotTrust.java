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
package gcj2011.qualificationround;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Solution to Google Code Jam 2011 Qualification Round's Problem "Bot Trust"
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 */
public class BotTrust {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.valueOf(scn.nextLine());

        for (int tc = 1; tc <= t; tc++) {
            String line = scn.nextLine();
            StringTokenizer st = new StringTokenizer(line);

            LinkedList<Move> moveList = new LinkedList<Move>();

            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                // Reading movements specification
                char botChar = st.nextToken().charAt(0);
                int pos = Integer.parseInt(st.nextToken());
                Bot bot = Bot.getByChar(botChar);
                Move move = new Move(bot, pos);

                moveList.add(move);
                bot.moveList.add(move);
            }

            // Starts the simulation
            int elapsedTime = 0;
            for (int i = 0; i < n; i++) {
                // Get the moves
                Move nextMove = moveList.getFirst();

                int moveDelta = nextMove.pos - nextMove.bot.pos;
                int bDelta = Bot.b.moveList.isEmpty() ? 0 : Bot.b.moveList
                        .getFirst().pos - Bot.b.pos;
                int oDelta = Bot.o.moveList.isEmpty() ? 0 : Bot.o.moveList
                        .getFirst().pos - Bot.o.pos;

                int moveDistance = Math.abs(moveDelta);
                int bDistance = Math.abs(bDelta);
                int oDistance = Math.abs(oDelta);

                // Time goes by as bots move
                elapsedTime += moveDistance;

                // Bots move as far as they can
                Bot.b.pos += (moveDistance >= bDistance) ? bDelta
                        : moveDistance * signal(bDelta);
                Bot.o.pos += (moveDistance >= oDistance) ? oDelta
                        : moveDistance * signal(oDelta);

                // As one bot presses, the other can carry on moving
                elapsedTime++;
                Bot otherBot = (nextMove.bot == Bot.b) ? Bot.o : Bot.b;
                if (!otherBot.moveList.isEmpty()
                        && otherBot.pos != otherBot.moveList.getFirst().pos) {
                    otherBot.pos += signal(otherBot.moveList.getFirst().pos
                            - otherBot.pos);
                }

                // The move just taken is poped from the lists
                moveList.removeFirst();
                nextMove.bot.moveList.removeFirst();
            }

            System.out.println("Case #" + tc + ": " + elapsedTime);
            Bot.b.refresh();
            Bot.o.refresh();
        }
    }

    private static int signal(int bDelta) {
        return (bDelta < 0) ? -1 : 1;
    }
}

class Bot {
    char xar;
    public static Bot b = new Bot('B');
    public static Bot o = new Bot('O');

    public int pos = 1;
    public LinkedList<Move> moveList = new LinkedList<Move>();

    private Bot(char c) {
        this.xar = c;
    }

    public void refresh() {
        this.pos = 1;
        this.moveList = new LinkedList<Move>();
    }

    public static Bot getByChar(char botChar) {
        if (botChar == 'B') {
            return b;
        } else {
            return o;
        }
    }

    @Override
    public String toString() {
        return "" + this.xar;
    }
}

class Move {
    public Bot bot;
    public int pos;

    public Move(Bot bot, int pos) {
        this.bot = bot;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.bot.toString() + this.pos;
    }
}
