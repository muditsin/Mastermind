import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Util {

    public static HashMap<String, ArrayList<String>> clusters = new HashMap<String, ArrayList<String>>();
    public static ArrayList<String> sortedWords = new ArrayList<String>();

    static {
        try {
            generateClusters(filterByLength(readFile("C:\\Users\\musinha\\IdeaProjects\\Mastermind\\sowpods.txt"), 5));
        } catch (Exception e) {
        }
    }

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

    public static ArrayList<String> filterList(ArrayList<String> list, String regEx, Integer matches) {
        ArrayList<String> newList = new ArrayList<String>();
        for(String word : list) {
            if(((word.matches(regEx)) && matches > 0) || (!(word.matches(regEx)) && matches == 0))
                newList.add(word);
        }
        return newList;
    }



}
