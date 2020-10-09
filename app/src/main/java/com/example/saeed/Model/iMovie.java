package com.example.saeed.Model;

import java.util.ArrayList;

public interface iMovie {
    public String SearchByGeners (String Gener);
    public String SearchByTitle (String Title);
   public String SearchBYYear(int year);
   public  String[] getGeners();
}
