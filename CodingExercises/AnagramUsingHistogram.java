package dataStructuresAndAlgorithms.CodingExercises;

import java.util.Scanner;

public class AnagramUsingHistogram {
    //race and care are anagram of each other, they have same letters in any order
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        System.out.println(areAnagram(text1.trim().toLowerCase(), text2.trim().toLowerCase()));  //words are case-insensitive
    }

    public static boolean areAnagram(String text1, String text2){
        if(text1 == null || text2 == null || text1.length() != text2.length())
            return false;
        final int LETTERS = 26;
        int[] words = new int[LETTERS];
        for(int i = 0; i< text1.length(); i++){
            words[text1.charAt(i) -'a']++;
        }

        for(int i = 0; i< text2.length(); i++){
            var index = words[text2.charAt(i) -'a'];
            if(index == 0)
                return false;
            index--;
        }
        return true;
    }
}
