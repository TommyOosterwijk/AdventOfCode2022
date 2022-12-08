package days;

import utils.AocUtils;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 implements DayInterface {
    AocUtils utils = new AocUtils();

    List<List<String>> crates = new ArrayList<>();
    List<List<String>> cratesB = new ArrayList<>();



    public Day5() throws FileNotFoundException, URISyntaxException {

        for(int i = 0 ; i < 40; i++) {
            crates.add(new ArrayList<>());
            cratesB.add(new ArrayList<>());
        }
        System.out.println("Starting day5");
        Scanner scanner = utils.getScannerFromFileName("Day5.txt");
        boolean init = true;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if(s.length() == 0) {
                init = false;
            } else {

                if(init && s.indexOf("[") != -1) {
                    int stack = 0;

                    //GAME ON
                    while(s.indexOf("[") != -1) {
                        int index = s.indexOf("[");
                        stack +=  (index / 4) + 1;
                        String l = s.charAt(index+1) + "";
                        List<String> temp = crates.get(stack - 1);
                        List<String> tempB = cratesB.get(stack - 1);
                        temp.add(0, l);
                        tempB.add(0, l);

                        s = s.substring(index+2);
                    }
                } else {

                    if(s.startsWith("move")) {
                        String[] ins = s.split(" ");
                        int stackAmount = Integer.parseInt(ins[1]);
                        List<String> stackFrom = crates.get(Integer.parseInt(ins[3])-1);
                        List<String> stackTo = crates.get(Integer.parseInt(ins[5])-1);
                        List<String> stackFromB = cratesB.get(Integer.parseInt(ins[3])-1);
                        List<String> stackToB = cratesB.get(Integer.parseInt(ins[5])-1);

                        for(int i = 0; i < stackAmount; i++) {
                            stackTo.add(stackFrom.get(stackFrom.size() - 1));
                            stackFrom.remove(stackFrom.size() - 1);

                            stackToB.add(stackFromB.get(stackFromB.size() - stackAmount + i));
                            stackFromB.remove(stackFromB.size() - stackAmount + i);
                        }
                    }
                }
            }
        }

        getAnswerA();
        getAnswerB();
    }
    @Override
    public void getAnswerA() {
        System.out.println("A: ");
        for(int i = 0; i < crates.size(); i++) {
            List<String> temp = crates.get(i);
            if(temp != null && temp.size() != 0) {
                System.out.print(temp.get(temp.size() - 1));
            }
        }
        System.out.println();
    }

    @Override
    public void getAnswerB() {
        System.out.println("B: ");
        for(int i = 0; i < cratesB.size(); i++) {
            List<String> temp = cratesB.get(i);
            if(temp != null && temp.size() != 0) {
                System.out.print(temp.get(temp.size() - 1));
            }
        }
        System.out.println();
    }


}
