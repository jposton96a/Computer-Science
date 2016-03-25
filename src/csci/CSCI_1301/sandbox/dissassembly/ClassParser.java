package csci.CSCI_1301.sandbox.dissassembly;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jposton on 2/16/16.
 */
public class ClassParser {

    static String classPath = "res/Q4Q1.class";

    public static void main(String[] args){
        File javaClass = new File(classPath);

        byte[] assembledBytes = null;

        try {
            assembledBytes = Files.readAllBytes(Paths.get(classPath));
        } catch (IOException e){
            System.err.println("File could not be read.");
            System.exit(1);
        }

        decodeBytes(assembledBytes);
    }

    public static void decodeBytes(byte[] fileBytes){
        ByteCodeInfo opcodeInfo = new ByteCodeInfo("res/bytecode-map.txt");
        int program_counter = 0;

        while(program_counter < fileBytes.length){
            byte opcode = fileBytes[program_counter];
            System.out.printf("%s : %10s : %d\n",
                    String.format("%02X ", opcode),
                    opcodeInfo.getOpcodeName(opcode),
                    opcodeInfo.getOpcodeArgCount(opcode));
            program_counter++;
        }
    }
}
