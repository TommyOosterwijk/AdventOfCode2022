package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7 implements DayInterface {
    AocUtils utils = new AocUtils();

    int instrutionIndex = 0;
    List<String> instructions;
    List<Integer> mapSpaces = new ArrayList<>();
    int finalSizeA = 0;
    int maxSize = 0;

    public Day7() throws FileNotFoundException, URISyntaxException {
        System.out.println("Day7");
        instructions = utils.getStringListFromFile("Day7.txt");

        getAnswerA();
        getAnswerB();
    }

    public int doInstructions() {
        int size = 0;
        String instruction = instructions.get(instrutionIndex);
        while(!instruction.equals("$ cd ..") && instrutionIndex < instructions.size()) {
            instrutionIndex++;
            if (instruction.contains("$ cd")) {
                int mapSpace = doInstructions();
                mapSpaces.add(mapSpace);
                size += mapSpace;
            } else if(!instruction.contains("$ ls") && !instruction.contains("dir")) {
                size += Integer.parseInt(instruction.substring(0, instruction.indexOf(" ")));
            }

            if(instrutionIndex < instructions.size()) {
                instruction = instructions.get(instrutionIndex);
            }
        }
        instrutionIndex++;

        if(size <= 100000) {
            finalSizeA += size;
        }
        return size;
    }

    @Override
    public void getAnswerA() {
        maxSize = doInstructions();
        System.out.println("A: " + finalSizeA);
    }

    @Override
    public void getAnswerB() {
        int targetDisk = 30000000 - (70000000 - maxSize);
        Collections.sort(mapSpaces);
        for(int i = 0; i < mapSpaces.size(); i++) {
            if(mapSpaces.get(i) > targetDisk) {
                System.out.println("B: " + mapSpaces.get(i));
                break;
            }
        }
    }

}
