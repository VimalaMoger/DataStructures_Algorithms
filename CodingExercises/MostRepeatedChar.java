package dataStructuresAndAlgorithms.CodingExercises;

import java.util.*;

public class MostRepeatedChar {
    //find the most repeated character
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(text);
        System.out.println(mostRepeatedChar(text));
    }

    public static char mostRepeatedChar(String text){
        if(text.isEmpty())
            throw new IllegalArgumentException();
        char[] chars = text.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(); //holds each character, its occurrences in the entire array

        for(char i: chars) {
            if(map.containsKey(i)) //if already exists, increment value by 1
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);  // if not exists, set the value to 1
        }

        char key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        return key;
    }
}