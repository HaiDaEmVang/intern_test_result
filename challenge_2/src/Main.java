import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int countFrequent(int count) {
        return factorial(count)/(2*factorial(count-2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String s = input.next();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (n-- <= 0)
                break;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        for (int count : map.values())
            result += countFrequent(count);

        System.out.println(result);

    }
}