package dataStructuresAndAlgorithms.CodingExercises;

import java.util.Scanner;

public class PalindromeUsingWhile {
    //LEVEL, RACECAR are Palindromes, comparing the reverse string with the original, reads the same backward or forward
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println("isPalindrome " + isPalindrome(text));
    }

    public static boolean isPalindrome(String text){
        int left = 0, right = text.length()-1;

        while(left < right) {
            if(text.charAt(left) != text.charAt(right)) {
                left++;
                right--;
            }else
                return true;
        }
        return false;
    }
}
