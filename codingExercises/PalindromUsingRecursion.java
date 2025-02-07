package dataStructuresAndAlgorithms.codingExercises;

import java.util.Scanner;

public class PalindromUsingRecursion {
    //LEVEL, RACECAR are Palindromes, comparing the reverse string with the original, reads the same backward or forward
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println("IsPalindrome " + isPalindrome(text, 0, text.length()-1));
    }

    public static boolean isPalindrome(String text, int left, int right){

        if(left > right)
            return false;

        if(text.charAt(left) != text.charAt(right)) {
            left++;
            right--;
            isPalindrome(text, left, right);
        }else
            return true;

        return false;
    }
}
