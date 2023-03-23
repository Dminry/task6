import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
            " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] elements = TEXT.toLowerCase().toCharArray();
        Map<Character, Integer> simbols = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            if (Character.isLetter(elements[i])) {
                Integer count = simbols.get(elements[i]);
                if (count == null) {
                    simbols.put(elements[i], 1);
                } else {
                    simbols.put(elements[i], ++count);
                }
            }

        }
        System.out.println(simbols);
        Integer max = getMax(simbols);
        Integer min = getMin(simbols);
        System.out.print("Максимальное количество : ");
        for (Map.Entry<Character, Integer> simbol : simbols.entrySet()) {
            if (Objects.equals(simbol.getValue(), max)) {
                System.out.println(simbol.getKey() + " = " + simbol.getValue() + " ");
            }

        }
        System.out.print("Минимальное количество : ");
        for (Map.Entry<Character, Integer> simbol : simbols.entrySet()) {
            if (Objects.equals(simbol.getValue(), min)) {
                System.out.print(simbol.getKey() + " = " + simbol.getValue() + " ");
            }

        }

    }

    private static Integer getMax(Map<Character, Integer> simbols) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> simbol : simbols.entrySet()) {
            if (simbol.getValue() > max) {
                max = simbol.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> simbols) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> simbol : simbols.entrySet()) {
            if (min > simbol.getValue()) {
                min = simbol.getValue();
            }
        }
        return min;
    }
}