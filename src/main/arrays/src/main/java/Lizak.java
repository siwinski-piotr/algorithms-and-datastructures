import java.util.Scanner;

public class Lizak {

    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        // lizak od 1 do n
        String lizak = "";

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        lizak = sc.next();


        record Pair(int a, int b) {
        }

        Pair[] ans = new Pair[(int) 10e6 + 7];

        int totalSum = 0;

        int firstOne = -1;
        int lastOne = -1;
        for (int i = 0; i < n; i++) {
            if (lizak.charAt(i) == 'W') {
                totalSum += 1;
                if (firstOne == -1) firstOne = i;
                lastOne = i;
            } else {
                totalSum += 2;
            }
            ans[totalSum] = new Pair(0, i);
        }

        ans[totalSum] = new Pair(0, n);

        // pierwsza 1 jest z lewej
        // np. L = 1, prawa = 7, n = 10

        if (firstOne <= (n - 1) - lastOne) {
            lizak = lizak.substring(firstOne + 1, lizak.length());
        } else {
            lizak = lizak.substring(0, lastOne + 1);
        }

        int currentSum = 0;
        for (int i = 0; i < lizak.length(); i++) {
            if (lizak.charAt(i) == 'W') {
                currentSum += 1;
            } else {
                currentSum += 2;
            }
            ans[currentSum] = new Pair(0, i);
        }
        System.out.println(lizak);

        ans[1] = new Pair(firstOne, firstOne);

        System.out.println("Przetwarzanie zapytań");
        while (m-- > 0) {
            int k = sc.nextInt();
            Pair an = ans[k];
            if (an != null) {
                System.out.println("%s %s".formatted(an.a + 1, an.b + 1));
            } else {
                System.out.println("NIE");
            }
        }

    }
}
