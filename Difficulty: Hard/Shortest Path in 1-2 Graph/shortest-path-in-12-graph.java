import java.util.*;

class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {

        int maxNodes = V + edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < maxNodes; i++) {
            adj.add(new ArrayList<>());
        }

        int nextNode = V;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (weight == 1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                int intermediate = nextNode++;

                adj.get(u).add(intermediate);
                adj.get(intermediate).add(u);

                adj.get(intermediate).add(v);
                adj.get(v).add(intermediate);
            }
        }

        int[] distance = new int[nextNode];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == dest) {
                return distance[current];
            }

            for (int neighbor : adj.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return -1;
    }
}