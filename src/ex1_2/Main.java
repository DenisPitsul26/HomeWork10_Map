package ex1_2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        MyDictionary myDictionary = new MyDictionary(new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex1_2\\dictionary.txt"));
        try {
            myDictionary.addWordToDictionary("six", "шість");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File fileIn = new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex1_2\\English.in.txt");
        File fileOut = new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex1_2\\Ukrainian.out.txt");

        DictionaryDAO dictionaryDAO = new DictionaryDAO(myDictionary);
        try {
            dictionaryDAO.translateToFile(fileIn, fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File serializableDictionary = new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex1_2\\serializableDictionary");
        try {
            SerializableDictionary.saveDictionary(serializableDictionary, myDictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MyDictionary myDictionarySerializable = SerializableDictionary.loadDictionary(serializableDictionary);
            System.out.println(myDictionarySerializable);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
