package ex1_2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDictionary implements Serializable{

    private Map<String, String> dictionaryMap;
    private File dictionaryFile;

    public MyDictionary(File dictionaryFile) {
        try {
            this.dictionaryFile = dictionaryFile;
            dictionaryMap = fromStringListToMap(fromFileToStringList(dictionaryFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyDictionary() {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("one","один");
        dictionaryMap.put("two","два");
        dictionaryMap.put("three","три");
        dictionaryMap.put("four","чотири");
        dictionaryFile = new File("E:\\JavaOOP\\HomeWork#10_Map\\src\\ex1_2\\dictionary.txt");
    }

    public Map<String, String> getDictionaryMap() {
        return dictionaryMap;
    }

    private List<String> fromFileToStringList(File file) throws IOException {
        List<String> listWords = new ArrayList<>();
        try (BufferedReader bufRead = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufRead.readLine()) != null && !line.equals("\n")){
                listWords.add(line);
            }
        }
        return listWords;
    }

    private Map<String, String> fromStringListToMap(List<String> listWords){
        Map<String, String> vocabulary = new HashMap<>();
        for (int i = 0; i < listWords.size(); i++) {
            String line = listWords.get(i);
            String[] words = line.split(" - ");
            vocabulary.put(words[0], words[1]);
        }
        return vocabulary;
    }

    public void addWordToDictionary(String englishWord, String ukrainianWord) throws IOException{
        dictionaryMap.putIfAbsent(englishWord, ukrainianWord);
        String string = getStringFromFile(dictionaryFile);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(dictionaryFile))) {

            bf.write(string +"\n"+ englishWord +" - "+ ukrainianWord);
        }
    }

    private String getStringFromFile(File file) throws IOException{
        StringBuilder sb = new StringBuilder();
        try (BufferedReader buffRead = new BufferedReader(new FileReader(file))){
            String line;
            boolean flag = false;
            while ((line = buffRead.readLine()) != null){
                if (flag) {
                    sb.append(System.lineSeparator());
                    sb.append(line);
                }
                else
                    sb.append(line);
                flag = true;
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "MyDictionary{" +
                "dictionaryMap=" + dictionaryMap +
                '}';
    }
}
