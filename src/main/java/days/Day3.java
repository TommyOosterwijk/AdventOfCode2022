package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 implements DayInterface {

    AocUtils utils = new AocUtils();
    int result = 0;
    ArrayList<String> lines = new ArrayList<>();

    public Day3() throws FileNotFoundException, URISyntaxException {

        System.out.println("Starting Day3!");

        Scanner scanner = utils.getScannerFromFileName("Day3.txt");
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            lines.add(s);
            String[] parts = {s.substring(0, s.length()/2),s.substring(s.length()/2)};
            boolean found = false;
            for(int i = 0; i < parts[0].length(); i++) {
                Character ch = parts[0].charAt(i);
                if(!found) {
                    for (int i2 = 0; i2 < parts[1].length(); i2++) {
                        Character ch2 = parts[1].charAt(i2);

                        if (ch.equals(ch2)) {
                            int r = ch2;

                            if(r >= 97 && r <= 122) {
                                r -= 96;
                            } else {
                                r-= 38;
                            }
                            result += r;
                            found = true;
                            break;
                        }
                    }
                }
            }



        }
        getAnswerA();
        getAnswerB();
    }

    public void getAnswerA() {
        System.out.println(result);

    }

    public void getAnswerB() {
        int resultB = 0;
        for(int i = 0; i < lines.size(); i+=3) {
            String one = lines.get(i);
            String two = lines.get(i+1);
            String three = lines.get(i+2);
            boolean found = false;

            for(int x = 0; x < one.length(); x++) {
                if(!found) {
                    char target = one.charAt(x);

                    for (int y = 0; y < two.length(); y++) {
                        char twoValue = two.charAt(y);
                        if(!found) {
                            if (target == twoValue) {
                                for (int z = 0; z < three.length(); z++) {
                                    char threeValue = three.charAt(z);
                                    if (target == threeValue) {
                                        int r = target;

                                        if(r >= 97 && r <= 122) {
                                            r -= 96;
                                        } else {
                                            r-= 38;
                                        }
                                        resultB += r;
                                        found = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(resultB);

    }


}
