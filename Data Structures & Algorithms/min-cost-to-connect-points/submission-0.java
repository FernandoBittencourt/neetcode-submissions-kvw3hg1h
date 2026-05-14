class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Manhattan> pq =new PriorityQueue<Manhattan>((a,b)->a.cost-b.cost);
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int[] p1=points[i];
                int[] p2=points[j];
                int cost = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
                pq.add(new Manhattan(i,j, cost));
            }
        }
        int[] parent=new int[points.length];
        for(int i =0;i<parent.length;i++){
            parent[i]=i;
        }
        int cost=0;
        while(!pq.isEmpty()){
            Manhattan m = pq.poll();
            if(find(parent,m.id1)!=find(parent,m.id2)){
                union(parent, m.id1,m.id2);
                cost+=m.cost;
            }
        }
        return cost;
    }

    private int find(int[] parent, int x){
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent,int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
    
    private class Manhattan {
        public int id1;
        public int id2;
        public int cost;

        public Manhattan(int id1,int id2, int cost){
            this.id1=id1;
            this.id2=id2;
            this.cost=cost;
        }
    }
}
