import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        countDuplicateCharactersMap("Hello world!");
        System.out.println(Character.toChars(128149));
    }

    public static Map<Character, Integer> countDuplicateCharactersMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
           map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        return map;
    }

    public static Map<Character, Long> countDuplicatedCharacterStream(String s) {
        return s.chars()
                .mapToObj(Character.class::cast)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}