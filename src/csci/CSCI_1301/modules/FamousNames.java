package csci.CSCI_1301.modules;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jposton on 3/21/16.
 */
public class FamousNames {
    static String filepath = "res/FamousNames.txt";

    public static void main(String[] args){
        try {
            ArrayList<Person> famousPeople = new ArrayList<Person>();

            FileReader file = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(file);

            String line;

            do {
                line = reader.readLine();
                System.out.println(line);
                if(line != null)
                    famousPeople.add(new Person(line));
            } while(line!= null && !line.equals(""));

            Person[] arrFamousPeople = famousPeople.toArray(new Person[famousPeople.size()]);
            System.out.println(Arrays.toString(arrFamousPeople));

        } catch(FileNotFoundException e){
            System.err.println("File not found");
            e.printStackTrace();
        }
        catch(IOException e) {
            System.err.println("Error reading file");
            e.printStackTrace();
        }
    }
}

class Person{
    String name;
    String birthdate;
    String comment;

    public Person(String rawData){
        this.name = rawData.substring(0, rawData.indexOf('(')-1);
        this.birthdate = rawData.substring(rawData.indexOf('('), rawData.indexOf(')')+1);
        this.comment = rawData.substring(rawData.indexOf(')')+2);
    }

    public String toString(){
        return String.format("%s %s %s", name, birthdate, comment);
    }
}

