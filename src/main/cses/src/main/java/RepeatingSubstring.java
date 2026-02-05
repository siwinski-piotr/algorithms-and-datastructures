import java.util.HashSet;
import java.util.Scanner;

public class RepeatingSubstring {

    public static int P = 313;
    public static long MOD = (long) 1e9 + 7;

    public static long[] pow;
    public static long[] sum;

    public static long getHash(int l, int r) {
        long raw = (sum[r] - sum[l - 1] + MOD) % MOD;
//         align the hash to start at position 0
        return (raw * pow[sum.length - 1 - l]) % MOD;
    }


    // sprawdza czy są 2 słowa długości 'len' w napisie 's'
    static int check(int len, String s) {
        var set = new HashSet<Long>();

        // wypisz wszystkie fragmenty dlugosci len
        /*
        0 1 2 3 4
        a b c d e
        len = 5
         */
        for (int i = 0; i + len <= s.length(); i++) {
//            var fragment = s.substring(i, i + len);
            var currentHash = getHash(i + 1, i + len);
            if (set.contains(currentHash)) {
                return i;
            }
            set.add(currentHash);
        }

        return -1;
    }

    static int binarySearch(int left, int right, String s) {
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (check(mid, s) == -1) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var s = sc.next();
        int n = s.length();

        sum = new long[n + 1];
        pow = new long[n + 1];
        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * P) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + s.charAt(i - 1) * pow[i - 1]) % MOD;
        }


        int maxLen = binarySearch(0, s.length() - 1, s);
        if (maxLen == 0) {
            System.out.println("-1");
        } else {
            int idx = check(maxLen, s);
            System.out.println(s.substring(idx, idx + maxLen));
        }

        // binary search po długości - znajdź ostatni pasujący
        // len:        1 2 3 4 5 6 7 8
        // check(len): 1 1 1 1 0 0 0 0
        //                   ^         4 to nasz wynik
    }
}
