package ro.unibuc;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 TODO:
 scrieti o clasa java care sa returneze toate cuvinetele de lungime > n dintr-un fisier text
 Lungimea n trebuie introdusa de la tastatura.

 In plus fata de lungime, care trebuie introdusa de la tastatura, putem filtra si dupa alte conditii(vedeti testele)
 */

public class SizeN {

    List<String> words = new ArrayList<String>();

    public void returnWords(int limit, String fileName){
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                String[] words = line.split(" ");

                for (String w: words)
                {
                    if( w.length()>limit && !(w.contains(",") || w.contains(";") || w.contains(".") || w.contains("!") || w.contains("?")
                            || w.contains("“") || w.contains("”") || w.contains(":") )){
                        this.words.add(w);
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void getWords(){
        System.out.println("Cuvintele cu lungime mai mare de limita data:");
        System.out.println(this.words);
    }

}
