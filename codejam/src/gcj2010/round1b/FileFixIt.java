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
package gcj2010.round1b;

import java.util.HashMap;
import java.util.Scanner;

public class FileFixIt {

    public static void main(String[] args) {
        new FileFixIt().begin();
    }

    private void begin() {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        for (int cs = 1; cs <= t; cs++) {
            long result = 0;
            String[] nmLine = scn.nextLine().split(" ");
            int n = Integer.parseInt(nmLine[0]);

            Directory root = new Directory("");
            for (int ex = 0; ex < n; ex++) {
                String dir = scn.nextLine();
                root.add(dir);
            }

            int m = Integer.parseInt(nmLine[1]);
            for (int nw = 0; nw < m; nw++) {
                String dir = scn.nextLine();
                result += root.add(dir);
            }

            System.out.println("Case #" + cs + ": " + result);
        }
    }
}

class Directory {

    String name = "";
    HashMap<String, Directory> subDir = new HashMap<String, Directory>();

    public Directory(String name) {
        this.name = name;
    }

    public long add(String dir) {
        String path[] = dir.split("/");
        return this.add(path, 1);
    }

    private long add(String[] path, int i) {
        if (i != path.length) {
            int result = 0;
            Directory dir = null;
            if (!this.subDir.containsKey(path[i])) {
                dir = new Directory(path[i]);
                this.subDir.put(path[i], dir);
                result++;
            } else {
                dir = this.subDir.get(path[i]);
            }
            return dir.add(path, i + 1) + result;
        }
        return 0;
    }
}
