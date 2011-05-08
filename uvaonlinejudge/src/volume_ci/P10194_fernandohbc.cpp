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
#include <iostream>
#include <algorithm>

#define TEAMNAME 31
#define MAXLINE 70

/*
 * TODO: This is a WA code as of 03 March 2011
 * Must be corrected to be accepted.
 */

using namespace std;

struct Team {
  int points;
  int wins;
  int goalsScored;
  int goalsAgainst;
  int losses;
  int gamesPlayed;
  char name[TEAMNAME];
};

Team * locateTeam( Team * teams, char * teamName) {
  int i = 0;
  while (strcmp(teams[i].name, teamName) != 0 ) {
    i++;
  }
  return teams + i;
}

void parseGame(char * encodedGame, Team teams[]) {
  // First team
  char * tok = strtok(encodedGame, "#");
  Team * firstTeam = locateTeam(teams, tok);

  // First team score
  tok = strtok(NULL, "@");
  int firstTeamScore = atoi(tok);

  // Second team score
  tok = strtok(NULL, "#");
  int secondTeamSocre = atoi(tok);

  //Second team
  tok = strtok(NULL, "#");
  Team * secondTeam = locateTeam(teams, tok);

  Team * winner = NULL;
  Team * loser = NUL:
  if ( firstTeamScore > secondTeamSocre ) {
    winner = firstTeam;
    loser = secondTeam;
  } else if ( secondTeamSocre > firstTeamScore ){
    winner = secondTeam;
    loser = firstTeam;
  }

  // Has a winner?
  if (winner) {
    winner->points += 3;
    winner->wins += 1;

    loser->losses += 1;
  } else {
    firstTeam->points += 1;
    secondTeam->points += 1;
  }


  // Update scores
  firstTeam->goalsScored += firstTeamScore;
  firstTeam->goalsAgainst += secondTeamSocre;
  secondTeam->goalsAgainst += firstTeamScore;
  secondTeam->goalsScored += secondTeamSocre;

  // Games played
  firstTeam->gamesPlayed++;
  secondTeam->gamesPlayed++;
}

void initializeTeam(Team& team, char * teamName) {
  strcpy(team.name, teamName);
  team.points = 0;
  team.wins = 0;
  team.goalsScored = 0;
  team.goalsAgainst = 0;
  team.losses = 0;
  team.gamesPlayed = 0;
}

bool compareTeams(Team a, Team b) {
  if ( a.points > b.points ) {
    return true;
  } else if ( a.points < b.points ) {
    return false;
  }

  if ( a.wins > b.wins ) {
    return true;
  } else if ( a.wins < b.wins ) {
    return false;
  }

  int aGd = a.goalsScored - a.goalsAgainst;
  int bGd = b.goalsScored - b.goalsAgainst;
  if ( aGd > bGd ) {
    return true;
  } else if ( aGd < bGd ) {
    return false;
  }

  if ( a.goalsScored > b.goalsScored ) {
    return true;
  } else if ( a.goalsScored < b.goalsScored ){
    return false;
  }

  if ( a.gamesPlayed < b.gamesPlayed ) {
    return true;
  } else if ( a.gamesPlayed > b.gamesPlayed ) {
    return false;
  }

  return strcasecmp(a.name, b.name) < 0;
}

int main() {
  char line[MAXLINE];

  cin.getline(line, MAXLINE);
  int nOfTournment = atoi(line);
  for (int t = 0; t < nOfTournment; t++) {
    if ( t != 0 ) {
      cout << endl;
    }
    // Reads the tournment name
    cin.getline(line, MAXLINE);
    int lengthTournmentName = strlen(line);
    char tournamentName[lengthTournmentName + 1];
    strcpy(tournamentName, line);

    // How many teams?
    cin.getline(line, MAXLINE);
    int nOfTeams = atoi(line);
    Team teams[nOfTeams];
    for ( int team = 0; team < nOfTeams; team++) {
      // Reads the name of the team
      cin.getline(line, MAXLINE);
      initializeTeam(teams[team], line);
    }

    // How many games?
    cin.getline(line, MAXLINE);
    int nOfGames = atoi(line);
    for ( int game = 0; game < nOfGames; game++ ) {
      // Reads the game
      cin.getline(line, MAXLINE);
      parseGame(line, teams);
    }

    // Sorts
    sort(teams, teams + nOfTeams, compareTeams);

    // Prints
    cout << tournamentName << endl;
    for ( int team = 0; team < nOfTeams; team ++ ) {
      Team tm = teams[team];
      printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n", team+1, tm.name,
          tm.points, tm.gamesPlayed, tm.wins,
          (tm.gamesPlayed-tm.wins-tm.losses), tm.losses,
          (tm.goalsScored - tm.goalsAgainst), tm.goalsScored,
          tm.goalsAgainst);
    }
  }
  return 0;
}
