package collections;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class MapTest {

    /**
     * Understanding of {@link Map#merge(Object, Object, BiFunction)} method.
     */
    @Test
    public void mergeTest(){
        String text = "An ArrayList is an object that contains other objects. An ArrayList cannot contain\n" +
                "primitives. An array is a built-in data structure that contains other objects or primitives.";
        String[] words = text.split("[\\s,.]+");

        Map<String, Integer> map = new TreeMap<>();
        BiFunction<Integer, Integer, Integer> increment = (val, startVal) -> val + 1;

        for (String word : words) {
            map.merge(word, 1, increment);
        }

        map.forEach(
                (k, v) -> System.out.printf("%s: %d%n", k, v)
        );
    }



}
