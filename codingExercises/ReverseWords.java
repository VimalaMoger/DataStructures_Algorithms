package dataStructuresAndAlgorithms.codingExercises;

import java.util.Scanner;

public class ReverseWords {
    //reverse the order of words in a sentence
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().replaceAll("\\s+"," ");
        System.out.println(reverseWordsInSentence(line));
    }

    public static String reverseWordsInSentence(String line){
        String[] str = line.split(" ");
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i] + " ");
        }
        return sb.toString();
    }
    /**
     *   second approach
     *     Collections.reverse(Arrays.asList(str);
     *     String.join(" ", str);
     */
}
