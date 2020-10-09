package com.example.saeed.Model;

import java.util.ArrayList;

public class MovieData implements iMovie {
    ArrayList<Movie> Movies = new ArrayList<Movie>();
    private int year;

    MovieData() {

        Movies.add(new Movie("Tenet","Action",2019));
        Movies.add(new Movie("Home Alone","Comedy",1995));
        Movies.add(new Movie("Life as we know it","Drama",2012));
        Movies.add(new Movie("The war with grandpa","Comdey",2017));
        Movies.add(new Movie("The new Mutants","Horror",2010));
        Movies.add(new Movie("Ava","Action",2015));
        Movies.add(new Movie("The Broken Hearts Gallery","Romance",2019));
    }
    @Override
    public String SearchBYYear(int Year) {

        String results = "";
        for (int i =0;i<Movies.size();i++) {
            if (Movies.get(i).releaseYear==Year) {
                results+=Movies.get(i).Title+"\n";
            }
        }
        return results;
    }
    @Override
    public String SearchByGeners (String Gener) {
        String results = "";
        for (int i =0;i<Movies.size();i++) {
            if (Movies.get(i).Geners.equals(Gener)) {
                results+=Movies.get(i).Title+"\n";
            }
        }
        return results;
    }
    @Override
    public String SearchByTitle(String Title) {
        String results = "";
        for (int i =0;i<Movies.size();i++) {
            if (Movies.get(i).Title.contains(Title)) {
                results+=Movies.get(i).Title+"\n";
            }
        }
        return results;
    }

    @Override
    public String[] getGeners() {
        return new String[] {"Comedy","Romance","Horror","Action","Drama"};
    }
}
