import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LizakThreeElementsInWindow {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] lizak = new int[n];
        for (int i = 0; i < lizak.length; i++) {
            lizak[i] = scanner.nextInt();
        }

        Map<Integer, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int shortestWindow = Integer.MAX_VALUE;
        boolean hasFragment = false;

        while (right < lizak.length) {
            // expand window to right
            if (!hasFragment) {
                int current = lizak[right++];
                window.put(current, window.getOrDefault(current, 0) + 1);
                if (window.get(current) == 3) {
                    hasFragment = true;
                    shortestWindow = Math.min(shortestWindow, right - left);
                }


            }
            // shrink window if possible
            while (hasFragment && left < right) {
                int leftElement = lizak[left++];

                if (window.get(leftElement) == 3) {
                    hasFragment = false;
                } else {
                    shortestWindow = Math.min(shortestWindow, right - left);
                }
                window.put(leftElement, window.get(leftElement) - 1);
            }
        }


        System.out.println(shortestWindow != Integer.MAX_VALUE ? shortestWindow : "NIE\n");
    }
}
