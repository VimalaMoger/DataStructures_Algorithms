package dataStructuresAndAlgorithms.CodingExercises;

import java.util.*;

public class Anagram {
    //race and care are anagram of each other, they have same letters in any order
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        System.out.println(anagramTest(text1.toLowerCase(), text2.toLowerCase()));  //words are case insensitive
    }

    public static boolean anagramTest(String text1, String text2){
        if(text1 == null || text2 == null || text1.length() != text2.length())
            return false;
        //Arrays.sort(text2);
        TreeSet name1 = new TreeSet(); //Treeset sorts elements in natural order
        TreeSet name2 = new TreeSet();

        for(int i =0; i< text2.length(); i++){
            name1.add(text1.charAt(i));
            name2.add(text2.charAt(i));
        }
        return name1.equals(name2);
    }
}
