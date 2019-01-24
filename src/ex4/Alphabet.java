package ex4;

import java.io.*;

public class Alphabet {

    public static Letter[] readLettersFromFile(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Null reference");
        }
        Letter[] letters = new Letter[26];
        int indexOfLetter = -1;
        int lineNumberIndex = 0;
        String string;
        try (BufferedReader is = new BufferedReader(new FileReader(file))) {
            while ((string = is.readLine()) != null) {
                if (string.length() == 1) {
                    indexOfLetter++;
                    letters[indexOfLetter] = new Letter();
                    letters[indexOfLetter].setLetter(string.charAt(0));
                    lineNumberIndex = 0;
                }
                else {
                    for (int i = 0; i < 7; i++) {
                        if (string.charAt(i) != ' ') {
                            letters[indexOfLetter].getLetterInAscii()[lineNumberIndex][i] = '*';
                        }
                        else {
                            letters[indexOfLetter].getLetterInAscii()[lineNumberIndex][i] = ' ';
                        }
                    }
                    lineNumberIndex++;
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return letters;
    }

}
