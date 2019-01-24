package ex3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{5,4,12,5,12,5,54};
        String[] words = new String[]{"dsf","dsf","thtr","dsf","svt","rfd","svt","dsf","wsdc"};

        Map<Integer, Integer> countOfNumbers = countReplay(numbers);
        Map<String, Integer> countOfWords = countReplay2(words);

        countOfNumbers.forEach((key, value) -> System.out.println(key +" = "+ value));
        System.out.println();
        countOfWords.forEach((key, value) -> System.out.println(key +" - "+ value));

    }

    public static <T> Map<T,Integer> countReplay(T[] objects){
        Map<T, Integer> countOfObjects = new HashMap<>();
        for (T object : objects) {
            Integer element = countOfObjects.get(object);
            if (countOfObjects.containsKey(object)) {
                countOfObjects.put(object, element + 1);
            } else {
                countOfObjects.put(object, 1);
            }
        }
        return countOfObjects;
    }

    //або так
    public static <T> Map<T,Integer> countReplay2(T[] objects){
        Map<T, Integer> countOfObjects = new HashMap<>();
        for (T object : objects) {
            countOfObjects.merge(object, 1, (oldNumber,newNumber) -> oldNumber+newNumber);
        }
        return countOfObjects;
    }
}
