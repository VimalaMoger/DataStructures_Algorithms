package dataStructuresAndAlgorithms.codingExercises;

import java.util.Scanner;

public class CountVowels {

//find the number of vowels in a string
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("Number of vowels present in the text " + countVowels(text));
    }

    public static int countVowels(String text){
        if(text.length() <= 0 )
            return 1;
        text = text.replace("\\s", ""); //removes white spaces
        String vowels = "aeiou";
        int count = 0;
        for(int i = 0; i< text.length(); i++) {
            //if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' ||
            //     text.charAt(i) == 'o' || text.charAt(i) == 'u') {   //Approach one

            // if(vowels.contains(Character.toString(text.charAt(i)))){//character sequence  //second approach

            if(vowels.indexOf(text.charAt(i)) != -1){  //3rd approach
                count++;
            }
        }
        return count;
    }
}
