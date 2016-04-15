package csci.CSCI_1301.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import java.util.StringTokenizer;

public class CSCI_1301_Spring2016_Lab10_JacobPoston {

    public static void main(String[] args) {
        int nLines = 150;
        Figure[] arFigures;

        String lab10_FileName = "res/labs/CSCI_1301_Spring2016_Lab09_Data.txt";

        arFigures = read_Lab10_FigureData(nLines, lab10_FileName);
        printFigureData(arFigures);
    }


    public static Figure[] read_Lab10_FigureData(int nLines, String aFileName) {
        String[] arLines = new String[nLines];
        Figure[] arFigures = new Figure[nLines];
        String line;
        int i = 0;

        try {
            FileReader inputFile = new FileReader(aFileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                arLines[i] = line;
                arFigures[i] = new Figure();
                String[] lineParams = line.split(", ");

                switch (lineParams[0]){
                    case "circle":
                        arFigures[i] = new Circle();
                        break;
                    case "rectangle":
                        arFigures[i] = new Rectangle();
                        break;
                    case "triangle":
                        arFigures[i] = new Triangle();
                        break;
                }
                arFigures[i].setP1(Integer.parseInt(lineParams[1]));
                arFigures[i].setP2(Integer.parseInt(lineParams[2]));
                arFigures[i].setP3(Integer.parseInt(lineParams[3]));

                i++;
            }
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:"
                    + e.getMessage());
            e.printStackTrace();
        }

        return arFigures;
    }


    // use this method to produce the output requested in the lab.
    public static void printFigureData(Figure[] arFigures) {
        for (Figure aFigure : arFigures) {
            System.out.println(aFigure);
        }
    }

}
