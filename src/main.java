import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<String> array1;
        String longest = "";
        if (args.length == 1) {
            array1 = new ArrayList<String>(Arrays.asList(args[0].split(",")));
            for(String word1:array1){
                for(int i =0; i<word1.length();i++){
                    if(array1.contains(word1.substring(0,i)) && findWord(word1.substring(i,word1.length()), array1)){
                        if(longest.length()<word1.length()) longest = word1;
                    }
                }
            }
            System.out.println(longest);
        } else {
            System.out.println("ERROR|Wrong number of arguments, only one array is required");
        }
    }
    public static boolean findWord(String word, ArrayList array){
        if(array.contains(word)) return true;
        for(int i = 0; i<word.length(); i++){
            if(array.contains(word.substring(0,i)) && findWord(word.substring(i,word.length()), array)) return true;
        }
        return false;
    }
}