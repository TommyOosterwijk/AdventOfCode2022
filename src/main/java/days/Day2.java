package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Day2 implements DayInterface {
    int finalScore = 0;
    int finalScoreB = 0;
    AocUtils utils = new AocUtils();

    public Day2() throws FileNotFoundException, URISyntaxException {
        System.out.println("Starting Day2!");
        Scanner scanner = utils.getScannerFromFileName("Day2.txt");
        while (scanner.hasNextLine()) {
            String[] rps = scanner.nextLine().split(" ");

            finalScore+= playRPS(transform(rps[0]), transform(rps[1]));
            finalScoreB+= playBRPS(transform(rps[0]), rps[1]);
        }

        getAnswerA();
        getAnswerB();

    }

    public int transform(String x) {
        if(x.equals("A") || x.equals("X")) {
            return 1;
        }
        if(x.equals("B") || x.equals("Y")) {
            return 2;
        }
        if(x.equals("C") || x.equals("Z")) {
            return 3;
        }
        return -10;
    }

    public int playBRPS(int p1, String p2) {
        int newP2 = 0;
        if(p2.equals("X")) {
        //lose.
            if(p1 == 1) {
                newP2 = 3;
            } else {
                newP2 = p1-1;
            }

        } else if(p2.equals("Y")) {
            newP2 = p1;
        } else {
        //win
            if(p1 == 3) {
                newP2 = 1;
            } else {
                newP2 = p1+1;
            }
        }
        return playRPS(p1, newP2);
    }

    public int playRPS(int p1, int p2) {
        int roundScore = p2;

        if(p1 == p2) {
            roundScore+=3;
        } else {
           if(p2 == p1+1 || (p2 == 1 && p1 == 3)) {
               roundScore+=6;
           }
        }
        return roundScore;
    }

    public void getAnswerA() {
        System.out.println("A: " + finalScore);
    }

    public void getAnswerB() {
        System.out.println("B: " + finalScoreB);
    }
}
