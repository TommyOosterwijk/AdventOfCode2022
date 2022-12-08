package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 implements DayInterface {
    AocUtils utils = new AocUtils();
    int countera = 0;
    int counterb = 0;

    public Day4() throws FileNotFoundException, URISyntaxException {
        System.out.println("Starting day 4");
        Scanner scanner = utils.getScannerFromFileName("Day4.txt");

        while (scanner.hasNextLine()) {
            int[] zone = Arrays.stream(scanner.nextLine().split("[,-]")).mapToInt(Integer::parseInt).toArray();
            if((zone[0] <= zone[2] && zone[1] >= zone[3]) || (zone[2] <= zone[0] && zone[3] >= zone[1])) {
                countera++;
            }



            if((zone[0] <= zone[2] && zone[1] >= zone[2]) || (zone[0] <= zone[3] && zone[1] >= zone[3]) ||
                    (zone[2] <= zone[0] && zone[3] >= zone[0]) || (zone[2] <= zone[1] && zone[3] >= zone[1]) ) {
                counterb++;
            }



        }

        getAnswerA();
        getAnswerB();

    }

    @Override
    public void getAnswerA() {
        System.out.println(countera);
    }

    @Override
    public void getAnswerB() {
        System.out.println(counterb);

    }
}
