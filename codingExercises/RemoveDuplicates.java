package dataStructuresAndAlgorithms.codingExercises;

import java.util.*;

public class RemoveDuplicates {
    //remove duplicate characters in a string
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println(removeDuplicates(text));
    }

    public static String removeDuplicates(String text){
        Set<Character> set = new LinkedHashSet<>(); //stores only unique elements
        for(int i = 0; i < text.length() ; i++) {
            set.add(text.charAt(i));
        }

        System.out.println(set);
        return set.toString().substring(1, 3 * set.size() - 1).replaceAll(", ","");
        //removes square brackets, and comma character
    }
}
