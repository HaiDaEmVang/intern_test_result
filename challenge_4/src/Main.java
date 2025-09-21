import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t  = scanner.nextInt();
        int n, k, countSingle = 0;
        String s;
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            scanner.nextLine();
            s = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++)
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            countSingle = map.values().stream().filter(v -> v % 2 != 0).toList().size();

            int kSubmit = Math.max(0, countSingle - 1);

//          1. k == kSubmit -> 1 le hoac ko co le nao
//          2. k > kSubmit thi khi bo di kSubmit -> con lai cac ky tu chan hoac 1 le, k con lai ma chan thi cu remove cac ky tu chan -> van thoa man
            if (k >= kSubmit && (k - kSubmit) % 2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}