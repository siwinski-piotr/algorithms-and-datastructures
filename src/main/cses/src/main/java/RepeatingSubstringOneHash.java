import java.util.*;
import java.io.*;

public class RepeatingSubstringOneHash {
    static final int MAXN = 100007;
    static final int P = 313;
    static final int MOD = 1000000007;

    static int[] hashPref = new int[MAXN];
    static int[] powP = new int[MAXN];

    static int getHash(int l, int r, int n) {
        int h = (hashPref[r] - hashPref[l - 1] + MOD) % MOD;
        return (int)(((long)h * powP[n - l]) % MOD);
    }

    // Returns the index of the second occurrence of a word
    // or -1 if no word of length d occurs twice
    static int checkLength(int d, int n) {
        if (d == 0)
            return 0;

        Set<Integer> prevHash = new HashSet<>();
        for (int i = 1; i <= n - d + 1; ++i) {
            // h = H(s[i...i+d-1])
            int h = getHash(i, i + d - 1, n);
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

        powP[0] = 1;
        for (int i = 1; i <= n; ++i) {
            powP[i] = (int)(((long)powP[i - 1] * P) % MOD);
        }

        hashPref[0] = 0;
        for (int i = 0; i < n; ++i) {
            hashPref[i + 1] = (int)(((long)hashPref[i] + (long)powP[i] * s.charAt(i)) % MOD);
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