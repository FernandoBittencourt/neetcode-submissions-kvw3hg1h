class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        int[] result=new int[2];
        for(int[] e: edges){
            if(find(parent, e[0])==find(parent, e[1])){
                result[0]=e[0];
                result[1]=e[1];
            } else{
                union(parent, e[0], e[1]);
            }
        }
        return result;
    }

    private int find(int[] parent, int i){
        while(parent[i] != i){
            i = parent[i];
        }
        return i;
    }

    private void union(int[] parent, int i, int j){
        int parentI = find(parent, i);
        int parentJ = find(parent, j);
        parent[parentI] = parentJ;
    }
}
