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
package volume_civ;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * UVa Online Judge Problem #10420 - List of Conquests
 * 
 * @author Fernando Cardoso (fernandohbc@gmail.com)
 * 
 */
public class P10420_ListOfConquests {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = Integer.parseInt(scn.nextLine().trim());
        TreeMap<String, Country> map = new TreeMap<String, Country>();
        for (int i = 0; i < n; i++) {
            String name = scn.nextLine();
            name = name.substring(0, name.indexOf(' '));

            Country country = map.get(name.toUpperCase());
            if (country == null) {
                country = new Country(name);
                map.put(name.toUpperCase(), country);
            }
            country.count++;
        }

        for (Country country : map.values()) {
            System.out.println(country.name + " " + country.count);
        }
    }
}

class Country {

    String name;
    int count;

    public Country(String name) {
        this.name = name;
    }

}