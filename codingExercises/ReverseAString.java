package dataStructuresAndAlgorithms.codingExercises;

import java.util.Scanner;

public class ReverseAString {

    //reverse a string
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println(String.copyValueOf(reverseString(text)));
    }

    public static char[] reverseString(String text){
        char[] chars = new char[text.length()];
        int index = 0;
        for(int i = text.length()-1; i >= 0 ; i--) {
            chars[index++] = text.charAt(i);
        }
        return chars;
    }
}
