import java.util.*;

public class Question1 {

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tokens = new int[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        int power = sc.nextInt();

        System.out.println(bagOfTokensScore(tokens, power));
    }
}