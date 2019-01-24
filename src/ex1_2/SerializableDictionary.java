package ex1_2;
import java.io.*;

public class SerializableDictionary {

    public static void saveDictionary(File file, MyDictionary dictionary) throws IOException{
        if (file == null || dictionary == null) {
            throw new IllegalArgumentException("Null reference");
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(dictionary);
        } catch (IOException e) {
            throw e;
        }
    }

    public static MyDictionary loadDictionary(File file) throws IOException, ClassNotFoundException{
        if (file == null){
            throw new IllegalArgumentException("Null reference");
        }
        MyDictionary dictionary = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            dictionary = (MyDictionary) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw e;
        }
        return dictionary;
    }
}
