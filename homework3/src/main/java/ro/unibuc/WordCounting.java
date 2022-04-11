package ro.unibuc;
import java.util.Scanner;


public class WordCounting {
    public static void main(String[] args) {
        FileWordCounter fileWordCounter = new FileWordCounter();
        //TODO: add code here to read from console and get the length limit
        Scanner input= new Scanner(System.in);
        System.out.println("Lungimea maxima: ");
        int limit = input.nextInt();

        SizeN words = new SizeN();
        words.returnWords(limit,"src/test/resources/poezie1.txt");

        words.getWords();

    }
}
