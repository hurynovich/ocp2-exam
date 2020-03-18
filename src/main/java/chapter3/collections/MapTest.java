package chapter3.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    @Test
    public void mergeTest(){
        String text = "An ArrayList is an object that contains other objects. An ArrayList cannot contain\n" +
                "primitives. An array is a built-in data structure that contains other objects or primitives.";
        String[] words = text.split("[\\s,.]+");

        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            map.merge(word, 1, this::increment);
        }

        map.forEach(
                (k, v) -> System.out.printf("%s: %d%n", k, v)
        );
    }

    private Integer increment(Integer val, Integer startVal){
        return val + 1;
    }
}
