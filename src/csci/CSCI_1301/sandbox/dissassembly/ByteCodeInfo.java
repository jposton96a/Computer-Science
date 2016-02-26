package csci.CSCI_1301.sandbox.dissassembly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jposton on 2/16/16.
 */
public class ByteCodeInfo{

    String[] bytecodeNames;
    byte[] bytecodes;
    byte[] argCount;
    byte[] argSize;

    public ByteCodeInfo(String bytecode_map){
        try {
            List<String> lines = Files.readAllLines(Paths.get(bytecode_map));

            bytecodeNames = new String[lines.size()];
            bytecodes = new byte[lines.size()];
            argCount = new byte[lines.size()];
            argSize = new byte[lines.size()];

            for(int i = 0; i < lines.size(); i++){
                String[] splitData = lines.get(i).split(" ");
                bytecodeNames[i] = splitData[0];
                bytecodes[i] = (byte)Integer.parseInt(splitData[1],16); ;
                argCount[i] = splitData.length > 2 ? Byte.parseByte(splitData[2].replace("+", "")) : 0;

                System.out.printf("%10s %s %s\n",
                        splitData[0],
                        splitData[1],
                        splitData.length > 2 ? splitData[2] : "0");
            }
        }catch (IOException e){
            System.err.println("Could not open bytecode map data");
        }
    }

    public String getOpcodeName(byte opcode) {
        if(bytecodeIndex(opcode) != -1)
            return bytecodeNames[bytecodeIndex(opcode)];
        else
            System.err.println("ERROR BYTECODE NOT FOUND: " + opcode);
        return "";
    }

    public int getOpcodeArgCount(byte opcode) {
        if(bytecodeIndex(opcode) != -1)
            return argCount[bytecodeIndex(opcode)];
        else
            System.err.println("ERROR BYTECODE NOT FOUND: " + opcode);
        return 0;
    }

    public int getOpcodeArgSize(byte opcode) {
        if(bytecodeIndex(opcode) != -1)
            return argSize[bytecodeIndex(opcode)];
        else
            System.err.println("ERROR BYTECODE NOT FOUND: " + opcode);
        return 0;
    }

    private int bytecodeIndex(int toFind){
        for (int i = 0; i < bytecodes.length; i++){
            if(bytecodes[i] == toFind)
                return i;
        }
        return -1;
    }
}
