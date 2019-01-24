package ex4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Converter {

    private Map<Character, Character[][]> lettersInAscii = new HashMap<>();
    private File file;

    public Converter(File file) throws IOException {
        this.file = file;
        doMapAsciiFromArrayLetters();
    }

    private void doMapAsciiFromArrayLetters() throws IOException {
        if (this.file == null) {
            throw new IllegalArgumentException("Null reference");
        }
        Letter[] tempLettersInAscii = Alphabet.readLettersFromFile(this.file);
        for (int i = 0; i < tempLettersInAscii.length; i++) {
            lettersInAscii.put(tempLettersInAscii[i].getLetter(), tempLettersInAscii[i].getLetterInAscii());
        }
    }

    public void printStringInAscii(String string) {
        string = string.toUpperCase();
        char[] charArray = string.toCharArray();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == ' ') {
                    System.out.print("    ");
                    continue;
                }
                Character[][] tempLettersInAscii = lettersInAscii.get(charArray[j]);
                boolean flag = false;
                for (int k = 0; k < 7; k++) {
                    if (!Character.isLetter(charArray[j])) {
                        flag = true;
                        break;
                    }
                    else
                        System.out.print(tempLettersInAscii[i][k]);
                }
                if (!flag)
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
