package days;

import org.apache.commons.lang3.StringUtils;
import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Day6 implements DayInterface{
    AocUtils utils = new AocUtils();
    String s = "";

    public Day6() throws FileNotFoundException, URISyntaxException {
        System.out.println("Day6!");
        Scanner scanner = utils.getScannerFromFileName("Day6.txt");
        s = scanner.nextLine();

        getAnswerA();
        getAnswerB();
    }

    @Override
    public void getAnswerA() {

        for(int i = 0; i < s.length()-3; i++) {
            String substr = s.substring(i, i+4);
            boolean doubleFound = false;

            for(int x = 0; x < 4; x++) {
                String l = substr.charAt(x) + "";
                if( StringUtils.countMatches(substr, l) > 1) {
                    doubleFound = true;
                    break;
                }
            }
            if(!doubleFound) {
                System.out.println(i + 4);
                i=s.length();
            }
        }
    }

    @Override
    public void getAnswerB() {


        for(int i = 0; i < s.length()-13; i++) {
            String substr = s.substring(i, i+14);
            boolean doubleFound = false;

            for(int x = 0; x < 14; x++) {
                String l = substr.charAt(x) + "";
                if( StringUtils.countMatches(substr, l) > 1) {
                    doubleFound = true;
                    break;
                }
            }
            if(!doubleFound) {
                System.out.println(i + 14);
                i=s.length();
            }
        }
    }
}
