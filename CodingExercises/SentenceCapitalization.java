package dataStructuresAndAlgorithms.CodingExercises;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceCapitalization {
    //Capitalize First letter of each word in the sentence
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().replaceAll("\\s+"," "); //removes white spaces with single space
        System.out.println(capitalizeSentence(line));
    }

    public static String capitalizeSentence(String line){
        if(line == null || line.trim().isEmpty())
            return "String is empty";
        String[] str = line.toLowerCase().split(" ");
        int index = 0;
        for(var s : str){
            str[index++] =s.substring(0,1).toUpperCase() + s.substring(1,s.length());
        }
        //converting string array into a string
        System.out.println(String.join(" ",str)); //java 8+ String.join() //approach 1
        System.out.println(Stream.of(str).collect(Collectors.joining(" "))); //using stream approach 2
        return String.join(" ",str);
    }
}
