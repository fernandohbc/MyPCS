/*******************************************************************************
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
 ******************************************************************************/
#include <stdio.h>
#include <list>

using namespace std;

struct DNode {
	int node;
	int cost;
};

bool compare(DNode first, DNode second) {
	return first.cost < second.cost;
}

bool contains(list<DNode> mylist, DNode node) {
	list<DNode>::iterator it;
	for (it = mylist.begin(); it != mylist.end(); it++) {
		if (node.node == (*it).node) {
			return true;
		}
	}
	return false;
}

int main(int argc, char * argv[]) {
	int qtdPontos;
	scanf("%d", &qtdPontos);
	int qtdArestas;
	scanf("%d", &qtdArestas);
	int destino;
	scanf("%d", &destino);
	destino--;
	int origem;
	scanf("%d", &origem);
	while (qtdPontos > 0 && qtdArestas > 0) {
		int mat[qtdPontos][qtdPontos];
		for (int i = 0; i < qtdPontos; i++) {
			for (int j = 0; j < qtdPontos; j++) {
				mat[i][j] = -1;
			}
		}
		for (int i = 0; i < qtdArestas; i++) {
			int indiI, indiJ, custo;
			scanf("%d %d %d", &indiI, &indiJ, &custo);
			int min = indiI < indiJ ? indiI : indiJ;
			int max = indiI > indiJ ? indiI : indiJ;

			if (min > destino || (min < destino && min + 1 == max)) {
				mat[min][max] = custo;
			}
			if (max > destino) {
				mat[max][min] = custo;
			}
		}

		if (mat[origem][destino] == -1) {
			DNode node;
			node.node = origem;
			node.cost = 0;

			list<DNode> nodeList;
			list<DNode> removed;
			nodeList.push_back(node);
			int distance = -1;

			do {
				nodeList.sort(compare);
				DNode closer = nodeList.front();
				nodeList.pop_front();
				while (contains(removed, closer)) {
					closer = nodeList.front();
					nodeList.pop_front();
				}

				if (closer.node == destino) {
					distance = closer.cost;
				} else {
					for (int i = 0; i < qtdPontos; i++) {
						if (mat[closer.node][i] != -1) {
							DNode newNode;
							newNode.node = i;
							newNode.cost = closer.cost + mat[closer.node][i];
							nodeList.push_back(newNode);
						}
					}
				}

				removed.push_back(closer);
			} while (distance == -1);

			printf("%d\n", distance);
		} else {
			printf("%d\n", mat[origem][destino]);
		}

		scanf("%d", &qtdPontos);
		scanf("%d", &qtdArestas);
		scanf("%d", &destino);
		destino--;
		scanf("%d", &origem);
	}
}
