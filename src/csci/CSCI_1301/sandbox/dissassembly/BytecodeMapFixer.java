package csci.CSCI_1301.sandbox.dissassembly;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jposton on 2/16/16.
 */
public class BytecodeMapFixer {
    public static void main(String[] args){
        try {
            List<String> lines = Files.readAllLines(Paths.get("res/bytecode-map.txt"));

            for(String s : lines){
                String[] splitData = s.split("\\|");
                System.out.printf("%s %s %s\n",
                        splitData[0],
                        splitData[1],
                        splitData[3].indexOf(":") == -1 ? splitData[3] : splitData[3].substring(0, splitData[3].indexOf(":")));
            }
        }catch (IOException e){}
    }
}
