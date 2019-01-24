package ex4;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input String: ");
        String string = in.nextLine();
        Converter converter = null;
        try {
            converter = new Converter(new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex4\\abc.txt"));
            converter.printStringInAscii(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
