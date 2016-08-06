
public class Main {
    public static void main(String[] args) {
        System.out.println("Hey");
        for(String word: Util.clusters.keySet()) {
            System.out.println(word + " " + Util.clusters.get(word));
        }
    }


}
