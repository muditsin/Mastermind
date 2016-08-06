import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Util {

    public static HashMap<String, ArrayList<String>> clusters = new HashMap<String, ArrayList<String>>();
    public static ArrayList<String> sortedWords = new ArrayList<String>();



    public static ArrayList<String> readFile(String path) throws Exception {
        return (ArrayList<String>) Files.readAllLines(Paths.get(path));
    }

    public static String sort(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static ArrayList<String> filterByLength(ArrayList<String> list, int length) {
        ArrayList<String> newList = new ArrayList<String>();
        for(String word : list) {
            if(word.length() == length)
                newList.add(word);
        }
        return newList;
    }

    public static void generateClusters(ArrayList<String> words) {
        for (String word : words) {
            if (clusters.containsKey(sort(word)))
                clusters.get(sort(word)).add(word);
            else {
                ArrayList<String> cluster = new ArrayList<String>();
                cluster.add(word);
                sortedWords.add(sort(word));
                clusters.put(sort(word), cluster);
            }
        }
    }

    public static ArrayList<String> filterList(ArrayList<String> list, String matchingWord, Integer matches) {
        String regEx = generateRegExPattern(matchingWord, matches);
        ArrayList<String> newList = new ArrayList<String>();
        for(String word : list) {
            if((((word.matches(regEx)) && matches > 0) || (!(word.matches(regEx)) && matches == 0)) && sort(matchingWord) != word)
                newList.add(word);
        }
        return newList;
    }

    public static String generateRegExPattern(String word, int matches) {
        char[] charArray = word.toCharArray();

        String pattern = "^.*";

        if(matches == 0)
            pattern += "[" +word+ "].*";

        else
            for(int i = 0; i < matches; i++){
                pattern += "[" +word+ "].*";
            }
        pattern += "$";
        return pattern;
    }

    public static int matches(String secretWord,String guessWord){
        char[] chars = guessWord.toCharArray();
        int matches=0;
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }
        for (Character character : charSet) {
            if(secretWord.indexOf(character) >= 0){
                matches++;
            }
        }
        return matches;

    }



}
