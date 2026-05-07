class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0; i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] p:prerequisites){
            graph.get(p[1]).add(p[0]);
        }
        int[] state = new int[numCourses]; //0->not visited, 1->visiting, 2->visited
        List<Integer> result=new ArrayList();
        for(int i=0;i<numCourses;i++){
            if(!dfs(graph, state, i, result)){
                return new int[0];
            }
        }
        
        int[] courses=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            courses[numCourses-1-i]=result.get(i);
        }
        return courses;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int i, List<Integer> result){
        if(state[i]==1){
            return false;
        }
        if(state[i]==2){
            return true;
        }
        state[i]=1;
        for(int j:graph.get(i)){
            if(!dfs(graph, state, j, result)){
                return false;
            }
        }
        state[i]=2;
        result.add(i);
        return true;
    }
}
