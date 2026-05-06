class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // build graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited
        
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, graph,state)){
                return false;
            }
        }
        return true;
    }


    private boolean dfs(int node, List<List<Integer>> graph, int[] state){
        if (state[node] == 1) return false; // ciclo
        if (state[node] == 2) return true;  // já processado

        state[node] = 1;
        for(int nei:graph.get(node)){
            if(!dfs(nei, graph,state)){
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
