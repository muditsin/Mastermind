import java.util.ArrayList;
import java.util.Scanner;

public class Machine {

    private String secretWord;
    private int length;
    private int lastIndex = 0;

    Machine(int length){
        this.length = length;
        String key = Util.sortedWords.get((int) (Math.random() * Util.sortedWords.size() - 1));
        secretWord = Util.clusters.get(key).get(0);
    }

    public String pickRandomInput(){
        if(Util.sortedWords.size()>1) {
            String key = Util.sortedWords.get((int) (Math.random() * Util.sortedWords.size() - 1));
            return Util.clusters.get(key).get(0);
        }
        else {
            return getFromArray();
        }
    }

    public String getFromArray(){
        String guessWord = Util.clusters.get(Util.sortedWords.get(0)).get(lastIndex);
        lastIndex ++;
        return guessWord;
    }

    public Boolean matchAndReduce(String word) {
        Scanner scanner = new Scanner(System.in);
        String matchesString = scanner.nextLine();
        if(!matchesString.equals("YOU WIN")) {
            int matches = Integer.parseInt(matchesString);
            if(matches == length) {
//                for(String word2 : Util.sortedWords) {
//                    if(Util.sort(word) != word2)
//                        Util.sortedWords.remove(word2);
//                }
            }
            else {
                Util.sortedWords.remove(Util.sort(word));
            }
            Util.sortedWords = Util.filterList(Util.sortedWords, word, matches);
            return true;
        }
        return false;
    }
    public String returnMatches(String inputWord) {
        int matches = Util.matches(secretWord,inputWord);
        if(matches == length)
            return "YOU WIN!";
        else
            return String.valueOf(matches);
    }

    public String getSecretWord() {
        return secretWord;
    }

}
