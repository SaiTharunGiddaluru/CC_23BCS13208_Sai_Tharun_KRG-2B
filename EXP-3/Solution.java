class Solution {

    static final int MOD = 1000000007;

    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public int nthMagicalNumber(int n, int a, int b) {

        long low = Math.min(a, b);
        long high = (long) n * Math.min(a, b);

        long lcm = (long) a * b / gcd(a, b);

        while (low < high) {
            long mid = low + (high - low) / 2;

            long magicalCount =
                    mid / a + mid / b - mid / lcm;

            if (magicalCount >= n)
                high = mid;
            else
                low = mid + 1;
        }

        return (int) (low % MOD);
    }
}