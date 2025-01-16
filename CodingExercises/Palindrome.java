package dataStructuresAndAlgorithms.CodingExercises;

import java.util.Scanner;

public class Palindrome {
//LEVEL is a Palindrome, comparing the reverse string with the original, reads the same backward or forward
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println("isPalindrome " + isPalindrome(text));
    }

    public static boolean isPalindrome(String text){
        char[] chars = text.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = text.length()-1; i >= 0 ; i--) {
            sb.append(text.charAt(i));
        }
        return String.copyValueOf(chars).equals(sb.toString());
    }
}
