package org.example.GsonParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Root.Root;
import org.example.Tickets.Ticket;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GsonParser {
    public Root parser(String s) {

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        Root root = new Root();
        try {
            Type type = new TypeToken<ArrayList<Ticket>>(){}.getType();
            BufferedReader buffered = new BufferedReader(new FileReader(s));



            ArrayList<Ticket> tickets= gson.fromJson(buffered, type);
             root.setTickets(tickets);

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return root;

    }
}