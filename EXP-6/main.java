import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        List<Integer>[] adj = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String s = names[i];
            String t = names[i + 1];

            int len = Math.min(s.length(), t.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s.charAt(j) != t.charAt(j)) {
                    int u = s.charAt(j) - 'a';
                    int v = t.charAt(j) - 'a';

                    adj[u].add(v);
                    indegree[v]++;
                    found = true;
                    break;
                }
            }

            if (!found && s.length() > t.length()) {
                System.out.println("Impossible");
                return;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int next : adj[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (topo.size() != 26) {
            System.out.println("Impossible");
            return;
        }

        for (int ch : topo) {
            System.out.print((char) (ch + 'a'));
        }
    }
}