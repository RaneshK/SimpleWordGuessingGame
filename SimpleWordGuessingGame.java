import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {


    public static void main(String[] args) {

        ArrayList<String> listOfWords = new ArrayList<String>();
        String wordToGuess = "";
        int numberOfGuesses = 5;
        String userGuess = "";
        Scanner scanner = new Scanner(System.in);

        // Read in the list of words
        try {
            File myObj = new File("Words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Add each word from the wordlist to the arrayList
                listOfWords.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Get a random number
        Random random = new Random();
        int randomNumber = random.nextInt(listOfWords.size());

        // Choose a word at random for the user to guess
        wordToGuess = listOfWords.get(randomNumber);

        // Tell the user how many guesses they have
        System.out.println("You have " + numberOfGuesses + " guesses");




        // Start the game
        while (numberOfGuesses != 0){
            // Give the user a hint
            System.out.println("The word starts with the letter " + wordToGuess.charAt(0) + " and the last letter is " + wordToGuess.charAt(wordToGuess.length() - 1));

            // Take the user's guess
            userGuess = scanner.nextLine();
            numberOfGuesses -= 1;

            // Check if the user has guessed the word correctly
            if (userGuess.equals(wordToGuess)){
                // The user has correctly guessed the word
                System.out.println("Congratulations you correctly guessed the word");
                numberOfGuesses = 0;
            }
        }
    }


}
