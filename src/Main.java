import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(reversingLetters("Hello world"));
    }

    public static Map<String, Integer> countDuplicateCharactersMap(String s) {
        return null;
    }

    public static char findingFirstNonRepeatedCharacter(String s) {
        int EXTENDED_ASCII_CODES = 256;
        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flags[c] == -1) {
                flags[c] = i;
            } else {
                flags[c] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i =0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ?  Character.MIN_VALUE : s.charAt(position);
    }

    public static String reversingLetters(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean containsOnlyDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}