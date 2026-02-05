import java.util.*;
import java.io.*;

public class RepeatingSubstringTwoHashes {
    static final int MAXN = 100007;
    static final int P = 313;
    static final int MOD1 = 1000000007;
    static final int MOD2 = 1000000009;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    static Pair[] hashPref = new Pair[MAXN];
    static Pair[] powP = new Pair[MAXN];

    static Pair getHash(int l, int r, int n) {
        int h1 = (hashPref[r].first - hashPref[l - 1].first + MOD1) % MOD1;
        int h2 = (hashPref[r].second - hashPref[l - 1].second + MOD2) % MOD2;

        return new Pair(
                (int)(((long)h1 * powP[n - l].first) % MOD1),
                (int)(((long)h2 * powP[n - l].second) % MOD2)
        );
    }

    // Returns the index of the second occurrence of a word
    // or -1 if no word of length d occurs twice
    static int checkLength(int d, int n) {
        if (d == 0)
            return 0;

        Set<Pair> prevHash = new HashSet<>();
        for (int i = 1; i <= n - d + 1; ++i) {
            // h = H(s[i...i+d-1])
            Pair h = getHash(i, i + d - 1, n);
            if (prevHash.contains(h))
                return i;
            prevHash.add(h);
        }
        return -1;
    }

    static int binarySearch(int lo, int hi, int n) {
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (checkLength(mid, n) == -1)
                hi = mid - 1;
            else
                lo = mid;
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        powP[0] = new Pair(1, 1);
        for (int i = 1; i <= n; ++i) {
            powP[i] = new Pair(
                    (int)(((long)powP[i - 1].first * P) % MOD1),
                    (int)(((long)powP[i - 1].second * P) % MOD2)
            );
        }

        hashPref[0] = new Pair(0, 0);
        for (int i = 0; i < n; ++i) {
            hashPref[i + 1] = new Pair(
                    (int)(((long)hashPref[i].first + (long)powP[i].first * s.charAt(i)) % MOD1),
                    (int)(((long)hashPref[i].second + (long)powP[i].second * s.charAt(i)) % MOD2)
            );
        }

        int d = binarySearch(0, n - 1, n);
        if (d == 0) {
            System.out.println("-1");
        } else {
            int ind = checkLength(d, n);
            // Print s[ind..ind+d-1]
            for (int i = ind; i < ind + d; ++i)
                System.out.print(s.charAt(i - 1));
            System.out.println();
        }
    }
}