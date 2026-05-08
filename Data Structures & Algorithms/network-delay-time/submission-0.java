class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        for(int[] t : times){
            graph.computeIfAbsent(t[0], x->new ArrayList<>())
            .add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0});

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int node = current[0];
            int currentDist = current[1];

            // Ignora entrada velha
            if (currentDist > dist[node]) {
                continue;
            }

            List<int[]> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int[] neighbor : neighbors) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDist = currentDist + weight;

                // Relaxamento
                if (newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;

                    minHeap.offer(new int[]{nextNode, newDist});
                }
            }

        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            // Nó inalcançável
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
