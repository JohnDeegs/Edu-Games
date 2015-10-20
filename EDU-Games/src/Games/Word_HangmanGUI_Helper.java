package Games;

public class Word_HangmanGUI_Helper {

    private String word;
    private String hint;

    public Word_HangmanGUI_Helper(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

    public String getWord() {
        return word;
    }

    public String getHint() {
        return hint;
    }

    //method to turn strin into char array
    public char[] SendToCharArray() {
        char[] temp = new char[word.length()];
        word = word.toUpperCase();

        //getchars copies characters from this string into the temp character array.
        word.getChars(0, word.length(), temp, 0);
        //return char array now filled with the chars from user entered string
        return temp;
    }
}