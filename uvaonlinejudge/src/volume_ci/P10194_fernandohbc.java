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
package volume_ci;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 10194 - Football (aka Soccer)
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com / Twitter: fernando_hbc)
 * 
 */
public class P10194_fernandohbc {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner cin = new Scanner(System.in, "ISO-8859-1");
        PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out,
                "ISO-8859-1"));

        int nOfTournment = Integer.parseInt(cin.nextLine());
        for (int t = 0; t < nOfTournment; t++) {
            if (t != 0) {
                cout.write("\n");
            }
            // Reads the tournment name
            String tournmentName = cin.nextLine();

            // How many teams?
            int nOfTeams = Integer.parseInt(cin.nextLine());
            Team[] teams = new Team[nOfTeams];
            for (int team = 0; team < nOfTeams; team++) {
                // Reads the name of the team
                teams[team] = new Team(cin.nextLine());
            }

            // How many games?
            int nOfGames = Integer.parseInt(cin.nextLine());
            for (int game = 0; game < nOfGames; game++) {
                // Reads the game
                parseGame(cin.nextLine(), teams);
            }

            // Sorts
            Arrays.sort(teams);

            // Prints
            cout.write(tournmentName + "\n");
            cout.flush();
            for (int team = 0; team < nOfTeams; team++) {
                Team tm = teams[team];
                System.out.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n",
                        team + 1, tm.getName(), tm.getPoints(),
                        tm.getGamesPlayed(), tm.getWins(), (tm.getGamesPlayed()
                                - tm.getWins() - tm.getLosses()),
                        tm.getLosses(),
                        (tm.getGoalsScored() - tm.getGoalsAgainst()),
                        tm.getGoalsScored(), tm.getGoalsAgainst());
            }
        }

        cout.flush();
    }

    private static void parseGame(String line, Team[] teams) {
        // First team
        String tok = line.substring(0, line.indexOf("#"));
        String rest = line.substring(line.indexOf("#") + 1);
        Team firstTeam = locateTeam(teams, tok);

        // First team score
        tok = rest.substring(0, rest.indexOf("@"));
        rest = rest.substring(rest.indexOf("@") + 1);
        int firstTeamScore = Integer.parseInt(tok);

        // Second team score
        tok = rest.substring(0, rest.indexOf("#"));
        rest = rest.substring(rest.indexOf("#") + 1);
        int secondTeamSocre = Integer.parseInt(tok);

        // Second team
        Team secondTeam = locateTeam(teams, rest);

        Team winner = null;
        Team loser = null;
        if (firstTeamScore > secondTeamSocre) {
            winner = firstTeam;
            loser = secondTeam;
        } else if (secondTeamSocre > firstTeamScore) {
            winner = secondTeam;
            loser = firstTeam;
        }

        // Has a winner?
        if (winner != null) {
            winner.addPoints(3);
            winner.addWin();

            loser.addLoss();
        } else {
            firstTeam.addPoints(1);
            secondTeam.addPoints(1);
        }

        // Update scores
        firstTeam.addGoalsScored(firstTeamScore);
        firstTeam.addGoalsAgainst(secondTeamSocre);
        secondTeam.addGoalsAgainst(firstTeamScore);
        secondTeam.addGoalsScored(secondTeamSocre);

        // Games played
        firstTeam.addGamePlayed();
        secondTeam.addGamePlayed();
    }

    private static Team locateTeam(Team[] teams, String tok) {
        for (Team team : teams) {
            if (team.getName().equals(tok)) {
                return team;
            }
        }
        return null;
    }
}

class Team implements Comparable<Team> {

    private int points = 0;
    private int wins = 0;
    private int goalsScored = 0;
    private int goalsAgainst = 0;
    private int losses = 0;
    private int gamesPlayed = 0;
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public int getGoalsAgainst() {
        return this.goalsAgainst;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getWins() {
        return this.wins;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getPoints() {
        return this.points;
    }

    public void addGamePlayed() {
        this.gamesPlayed++;
    }

    public void addGoalsAgainst(int goals) {
        this.goalsAgainst += goals;
    }

    public void addGoalsScored(int goals) {
        this.goalsScored += goals;
    }

    public void addLoss() {
        this.losses++;
    }

    public void addWin() {
        this.wins++;
    }

    public void addPoints(int i) {
        this.points += i;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Team other) {
        int diff = other.points - this.points;
        if (diff != 0) {
            return diff;
        }

        diff = other.wins - this.wins;
        if (diff != 0) {
            return diff;
        }

        int aGd = this.goalsScored - this.goalsAgainst;
        int bGd = other.goalsScored - other.goalsAgainst;
        diff = bGd - aGd;
        if (diff != 0) {
            return diff;
        }

        diff = other.goalsScored - this.goalsScored;
        if (diff != 0) {
            return diff;
        }

        diff = this.gamesPlayed - other.gamesPlayed;
        if (diff != 0) {
            return diff;
        }

        return this.name.toUpperCase().compareTo(other.name.toUpperCase());
    }
}
