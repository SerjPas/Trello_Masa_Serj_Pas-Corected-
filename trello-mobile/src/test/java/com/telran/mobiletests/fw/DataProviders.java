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
    /**
     * для роботы csv файла и подтягивания информации с него
     * creation of dataprovider
     */

    @DataProvider
    public Iterator<Object[]> teams() throws IOException {
        List<Object[]> list = new ArrayList<>();
        /**
         * BufferedReader reader умеет читать строки в отличии от Reader reader
         */

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Teamdata.csv")));
        String line = reader.readLine(); // считываем информацию с файла и передаем в строку line
        while (line != null){ // покак line не равен null
            String[] split = line.split(","); //создали масив строк и передаем в него информацию ввели розделитель по ","

            list.add(new Object[]{new Team().setTeamName(split[0]).setDescription(split[1])});

            line = reader.readLine();// опять читаем есть ли линия
        }// выходим из цыкла
        return list.iterator();
    }

}
