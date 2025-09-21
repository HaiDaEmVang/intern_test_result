import java.util.Scanner;

//testCases:
// 6 2 -> 13
// 5 2 -> 8
public class Main {
    public static long factorial(long n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
    public static long countMethod(int n, int k) {
        if (n == 1 || k == 1) {
            return n;
        } else {
            long result = 1;
            for (int i = 2; i <= k; i++) {
                for (int j = 1; j <= n/i; j++) {
                    long countNewPair = countMethod(n - i * j, k - 1);
                    result += factorial(j + countNewPair)/(factorial(j) * factorial(countNewPair));
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        System.out.println(countMethod(n, k));

    }
}
