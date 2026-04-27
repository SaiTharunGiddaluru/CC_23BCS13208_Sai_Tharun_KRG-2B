import java.util.*;

class subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
            int n = arr.length;

          int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
               List<Integer> subset = new ArrayList<>();

              for (int j = 0; j < n; j++) {
                      if ((mask & (1 << j)) != 0) {
                      subset.add(arr[j]);
                }
            }

            System.out.println(subset);
        }
    }
}