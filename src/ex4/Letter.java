package ex4;

public class Letter {
    private char letter;
    private Character[][] letterInAscii = new Character[7][7];

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Character[][] getLetterInAscii() {
        return letterInAscii;
    }
}
