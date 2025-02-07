package dataStructuresAndAlgorithms.codingExercises;

import java.util.Scanner;

public class Rotations {
    //rotate two characters to the right or end
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println(String.valueOf(rotateString(text)));
    }

    public static char[] rotateString(String text){
        char[] chars = new char[text.length()];
        int index = 0;
        for(int i = 0; i < text.length() ; i++) {
            if (i <= 1){
                chars[text.length() - (i+1)] = text.charAt(1-i);
            }else{
                chars[index++] = text.charAt(i);
            }
        }
        return chars;
    }
}
