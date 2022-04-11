package ro.unibuc;
import java.util.*;
import java.util.Collections;
import java.util.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.function.Predicate;


public class FileWordCounter {

    List<String> cuvinte = new ArrayList<>();

    //HINT: you could make one generic method to reuse for all three methods above
    //HINT2: think about functional interfaces, one that verifies things in particular - Predicate ?

    public String readFromFile(String fileName){
        String words = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (words.length()==0){
                    words = data;
                }
                else {
                    words = words +" "+ data;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return words;
    }


    public List<String> getSizeOne(String fileName) {
        List<String> listOfWords = new ArrayList<String>();
        String Words = readFromFile(fileName);
        Predicate<String> SizeOne = word -> {return word.length() == 1;};

        String[] words = Words.split(" ");
        for (String w: words)
        {
            if (SizeOne.test(w)){
                listOfWords.add(w);
            }

        }

        return listOfWords;
    }

    public List<String> getSizeLessThan3(String fileName) {
        List<String> listOfWords = new ArrayList<String>();
        String Words = readFromFile(fileName);
        Predicate<String> Less3 = word -> {return word.length() < 3;};

        String[] words = Words.split(" ");

        for (String w: words)
        {
            if (Less3.test(w)){
                listOfWords.add(w);

            }
        }
        return listOfWords;
    }

    public List<String> countWordAppearances(String fileName, String word) {
        List<String> listOfWords = new ArrayList<String>();
        String Words = readFromFile(fileName);
        Predicate<String> Captain = myWord -> {return myWord.contains(word);};

        String[] words = Words.split(" ");
        for (String w: words)
        {
            if (Captain.test(w)){
                listOfWords.add(w);
            }
        }
        return listOfWords;
    }
}
