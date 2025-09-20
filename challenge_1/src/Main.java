import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Map<String, Integer> CARD_VALUES = Map.ofEntries(
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("T", 10),
            Map.entry("J", 11),
            Map.entry("Q", 12),
            Map.entry("K", 13),
            Map.entry("A", 1)
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> suitCounts = new HashMap<>();
        Map<Integer, Integer> rankCounts = new HashMap<>();

        boolean isStraight = false, isFlush = false, isPair = false, isThree = false;
        boolean aIsOne = true;
        int pairCount = 0;

        int lastIndex = 0;
        int currentStreak = 0;

        for (Character ch : input.toCharArray()) {
            if (ch.equals(' ')) continue;

            if (ch.equals('H') || ch.equals('C') || ch.equals('D') || ch.equals('S')) {
                suitCounts.put(ch.toString(), suitCounts.getOrDefault(ch.toString(), 0) + 1);
            } else {
                if (ch.equals('T') || ch.equals('J') || ch.equals('Q') || ch.equals('K')) {
                    aIsOne = false;
                }
                rankCounts.put(CARD_VALUES.get(ch.toString()), rankCounts.getOrDefault(CARD_VALUES.get(ch.toString()), 0) + 1);
            }
        }

        for(Integer count : suitCounts.values()) {
            if (count == 5) {
                isFlush = true;
                break;
            }
        }

//        chuyen gia tri mac dinh tu 1 (A) sang 14 de kiem tra sanh
        if (!aIsOne) {
            rankCounts.put(14, rankCounts.getOrDefault(1, 0));
            rankCounts.remove(1);
        }

        for(Integer key : rankCounts.keySet().stream().sorted().toList()) {
            if (rankCounts.get(key) == 4) {
                System.out.println("Tu quy");
                return;
            } else if (rankCounts.get(key) == 3) {
                isThree = true;
            } else if (rankCounts.get(key) == 2) {
                isPair = true;
                pairCount++;
            }

            if (rankCounts.get(key) == 1 && (lastIndex == 0 || key == lastIndex + 1)) {
                lastIndex = key;
                currentStreak++;
                if (currentStreak == 5) {
                    isStraight = true;
                }
            } else {
                currentStreak = 0;
                lastIndex = 0;
            }
        }

        if (isFlush && isStraight) {
            System.out.println("Thung pha sanh");
        } else if (isFlush) {
            System.out.println("Thung");
        } else if (isStraight) {
            System.out.println("Sanh");
        } else if (isThree && isPair) {
            System.out.println("Cu lu");
        } else if (isThree) {
            System.out.println("Sam");
        } else if (isPair && pairCount == 2) {
            System.out.println("Thu");
        }else if (isPair) {
            System.out.println("Doi");
        } else {
            System.out.println("Mau thau");
        }
    }
}