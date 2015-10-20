package Games;

import java.util.LinkedList;
import java.util.Random;

public class WordRepository_HangmanGUI_Helper {

    //Linked List to store all words and catagories,
    //we use a linked list as we need to store two items the food and the hint
    private LinkedList<Word_HangmanGUI_Helper> words;

    public WordRepository_HangmanGUI_Helper() {
        words = new LinkedList();

        Word_HangmanGUI_Helper newWord = new Word_HangmanGUI_Helper("Pizza", "Food");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Apple", "Fruit");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Cookie", "Treat");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Chicken", "Meat");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Beans", "Food");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Spain", "Place in Europe");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Dublin", "Place in Ireland");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Galway", "Place in Ireland");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("London", "Place in England");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Up", "Movie");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Dispicable me", "Movie");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Shrek", "Movie");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Monsters Inc", "Movie");
        words.add(newWord);
        newWord = new Word_HangmanGUI_Helper("Minecraft", "Video Game");
        words.add(newWord);
    }

    //get a random word from the repository to play the game
    public Word_HangmanGUI_Helper GetRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}