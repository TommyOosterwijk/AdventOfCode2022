package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 implements DayInterface {

    AocUtils utils = new AocUtils();
    List<Integer> numbers = new ArrayList();



    public Day1() throws FileNotFoundException, URISyntaxException {
        System.out.println("Starting Day1!");
        Scanner scanner = utils.getScannerFromFileName("Day1.txt");
        int tempoValue = 0;
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if(s.equals("")) {
                numbers.add(tempoValue);
                tempoValue = 0;

            } else {
                tempoValue+= Integer.parseInt(s);
            }
        }
        numbers.add(tempoValue);
        Collections.sort(numbers, Collections.reverseOrder());

        getAnswerA();
        getAnswerB();
    }


    public void getAnswerA() {
        System.out.println("A: " + numbers.get(0));
    }

    public void getAnswerB() {
        System.out.println("B: " + numbers.get(0) + numbers.get(1) + numbers.get(2));
    }
}
