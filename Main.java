import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] a = new int[n + 1];
            int[] b = new int[n + 2];
            int[] best = new int[n + 2];
            long[] pref = new long[n + 2];

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = n; i >= 1; i--) {
                best[i] = Math.max(b[i], best[i + 1]);
            }

            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + best[i];
            }

            while (q-- > 0) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.print(pref[r] - pref[l - 1] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
