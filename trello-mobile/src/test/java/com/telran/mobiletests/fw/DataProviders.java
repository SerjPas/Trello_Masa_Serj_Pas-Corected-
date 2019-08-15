package com.telran.mobiletests.fw;



import com.telran.mobiletests.model.Team;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> teams() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader (new FileReader(
                new File("C:\\Users\\Passe\\OneDrive\\Documents\\GitHub\\Trello_Masa_Serj_Pas(Corected)\\trello-web\\src\\test\\resources\\teamdata.csv")));
        String line = reader.readLine();
        while (line!= null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Team()
                    .setTeamName(split[0])
                    .setDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
