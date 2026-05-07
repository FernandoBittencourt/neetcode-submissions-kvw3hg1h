class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph= new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited=new boolean[n];
        if(!dfs(graph, 0,-1,visited)){
            return false;
        }

        for(int i=0; i<n;i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
;
    private boolean dfs(List<List<Integer>> graph, int node,int parent,boolean[] visited){
        if(visited[node]){
            return false;
        }

        visited[node]=true;
        for(int neighbor: graph.get(node)){
            if (neighbor == parent) {
                continue;
            }
            if(!dfs(graph, neighbor, node,visited)){
                return false;
            }
        }
        return true;
    }
}
