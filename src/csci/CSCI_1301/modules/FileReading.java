package csci.CSCI_1301.modules;

import java.io.*;

/**
 * Created by jposton on 2/29/16.
 */
public class FileReading {

    public static void main(String[] args){
        printFile("test.txt");
    }

    public static void printFile(String filePath){
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader fileReader = new BufferedReader(file);

            String line;

            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.err.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e){
            System.err.println("Error reading file");
            e.printStackTrace();
        }
    }
}
