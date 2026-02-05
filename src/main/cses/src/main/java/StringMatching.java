import java.util.Scanner;

public class StringMatching {

    private static final long P = 31;
    private static final long MOD = (long) 1e6 + 7;
    private static long[] powers;

    static class StringHash {

        String n;
        long[] prefixSum;

        StringHash(String n) {
            this.n = n;
            this.prefixSum = new long[n.length() + 1];
            for (int i = 0; i < n.length(); i++) {
                prefixSum[i + 1] = (powers[i + 1] * n.charAt(i)) % MOD + prefixSum[i];
            }
        }

        public long getHash(int l, int r) {
            return (prefixSum[r] - prefixSum[l - 1]) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.next();
        String pattern = sc.next();

        if (target.length() < pattern.length()) {
            System.out.println(0);
            return;
        }

        // obliczanie potęg P
        powers = new long[target.length() + 1];
        powers[0] = 1;
        for (int i = 1; i <= target.length(); i++) {
            powers[i] = (powers[i - 1] * P) % MOD;
        }

        // policzy sumy prefiksowe dla napisu n (target) i m (pattern)
        StringHash targetString = new StringHash(target);
        StringHash patternStringHash = new StringHash(pattern);

        var patternHash = patternStringHash.getHash(1, pattern.length());
        int result = 0;

//        System.out.println("Pattern hash: " + patternHash);
        for (int l = 1; l < target.length() - pattern.length(); l++) {
            int r = l + pattern.length() - 1;

            var currentHash = targetString.getHash(l, r);
            var patternHashAdjusted = (patternHash * powers[l - 1]) % MOD;
            System.out.println("Hash for fragment %s-%s is %s. Pattern hash: %s".formatted(l, r, currentHash, patternHashAdjusted));
            if (patternHashAdjusted == currentHash) {
                result++;
            }
        }
        System.out.println(result);
    }
}
