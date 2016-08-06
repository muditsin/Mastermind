import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 3;
        Scanner scanner = new Scanner(System.in);
        try {
            Util.generateClusters(Util.filterByLength(Util.readFile("C:\\Users\\musinha\\IdeaProjects\\Mastermind\\sowpods.txt"), length));
        } catch (Exception e) {
        }
        Boolean flag = true;
        Machine machine = new Machine(length);
        do {
            System.out.println("Enter guess: ");
            String guessedWord = scanner.next();
            System.out.println(machine.returnMatches(guessedWord));
            String machineGuess = machine.pickRandomInput();
            System.out.println("My guess: " + machineGuess );
            flag = machine.matchAndReduce(machineGuess);
            System.out.println(Util.sortedWords.size() + " " + Util.sortedWords + " " + machine.getSecretWord());
        } while(flag);

        System.out.println(Util.filterList(Util.sortedWords,"BITCH", 0));
    }
}