package csci.CSCI_1301.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jposton on 4/1/16.
 */
public class Lab09_PerimeterSum {

    public static void main(String[] args){
        String aFileName = "res/labs/CSCI_1301_Spring2016_Lab09_Data.txt";
        int nLines = 150;
        String [] arLines = read_FigureData(nLines, aFileName);
        printPerimeters(arLines);
    }

    public static String[] read_FigureData( int nLines, String aFileName) {
        String[] lines = new String[nLines];
        try {

            // Open the file and create a buffered reader
            FileReader fileReader = new FileReader(aFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the file by line into the array
            for(int i = 0; i < nLines; i++)
                lines[i] = bufferedReader.readLine();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return lines;
    }

    // You will need to determine what type of figure you have in each line.
    // Then you will calculate and print the perimeter according to the following formulas:
    // if type => circle then use first number as radius. Perimeter = 2*PI*R
    // if type => rectangle then use first two numbers as A, B. Perimeter = 2A + 2B
    // if type => triangle then use the three numbers as A, B, C. Perimeter = A + B + C

    public static void printPerimeters ( String [] lines)
    {
        double perSum =0.0;
        for (int i = 0; i < lines.length; i++ )
        {
            double perimeter = 0.0;
            String[] lineParams = lines[i].split(", ");

            switch (lineParams[0]){
                case "circle":
                    int radius = Integer.parseInt(lineParams[1]);
                    perimeter = 2 * Math.PI * radius;
                    break;

                case "rectangle":
                    int width = Integer.parseInt(lineParams[1]);
                    int height = Integer.parseInt(lineParams[2]);
                    perimeter = (2 * width) + (2 * height);
                    break;

                case "triangle":
                    int side1Length = Integer.parseInt(lineParams[1]);
                    int side2Length = Integer.parseInt(lineParams[2]);
                    int side3Length = Integer.parseInt(lineParams[3]);
                    perimeter = side1Length + side2Length + side3Length;
                    break;
            }

            System.out.println(lines[i] + " -> Perimeter = " + perimeter);
            perSum += perimeter;
        }
        System.out.println("Perimeter sum = "  + perSum);

    }
}
