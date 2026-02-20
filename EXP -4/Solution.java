public class Solution {

    public int solve(int[] arr) {
        long mod = 1000000007L;
        int n = arr.length;
        long ans = 0;

        for (int i = 0; i < 31; i++) {
            long count = 0;

            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }

            long pairs = count * (n - count);
            ans = (ans + (pairs % mod) * (1L << i) % mod) % mod;
        }

        return (int)((2 * ans) % mod);
    }
}