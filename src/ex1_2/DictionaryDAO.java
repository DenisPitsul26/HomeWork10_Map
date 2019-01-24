package ex1_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryDAO {

    private MyDictionary myDictionary;

    public DictionaryDAO(MyDictionary myDictionary) {
        this.myDictionary = myDictionary;
    }

    public MyDictionary getMyDictionary() {
        return myDictionary;
    }

    private List<String> fromFileToStringList(File file) throws IOException {
        List<String> englishWords;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufRead = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufRead.readLine()) != null){
                sb.append(line);
            }
            englishWords = new ArrayList<>(Arrays.asList(sb.toString().split("\\W+")));
        }

        return englishWords;
    }

    private List<String> translateStringList(List<String> englishWords){
        List<String> ukrainianWords = new ArrayList<>();

        for (String englishWord : englishWords) {
            ukrainianWords.add(myDictionary.getDictionaryMap().get(englishWord));
        }

        return ukrainianWords;
    }

    private void writeTextToFile(List<String> listOfWords, File file) throws IOException{
        if (file == null) {
            throw new IllegalArgumentException("Null reference.");
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file))){
            for (int i = 0; i < listOfWords.size(); i++) {
                if (i == listOfWords.size()-1)
                    sb.append(listOfWords.get(i)).append(".");
                else
                    sb.append(listOfWords.get(i)).append(" ");
            }
            bufWriter.write(sb.toString());
        }
    }

    public void translateToFile(File in, File out) throws IOException {
        List<String> englishWords = fromFileToStringList(in);
        List<String> ukrainianWords = translateStringList(englishWords);
        writeTextToFile(ukrainianWords, out);
    }

}
