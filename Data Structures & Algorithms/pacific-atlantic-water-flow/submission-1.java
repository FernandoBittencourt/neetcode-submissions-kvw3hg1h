class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
        boolean[][] atlantic=new boolean[heights.length][heights[0].length];

        
        //pacific column
        for(int i=0;i<heights.length;i++){
            dfs(heights, i, 0, pacific);
        }

        //pacific Row
        for(int j=0;j<heights[0].length;j++){
            dfs(heights, 0, j, pacific);
        }

        
        //atantic column
        for(int i=0;i<heights.length;i++){
            dfs(heights, i, heights[0].length-1, atlantic);
        }

        //atantic Row
        for(int j=0;j<heights[0].length;j++){
            dfs(heights, heights.length-1, j, atlantic);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> value = new ArrayList<Integer>();
                    value.add(i);
                    value.add(j);
                    result.add(value);
                }
            }
        }

        return result;

    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited){
        int current = heights[i][j];
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        if(i-1>=0 && current<=heights[i-1][j]){
            dfs(heights, i-1, j, visited);
        }
        if(i+1<heights.length && current<=heights[i+1][j]){
            dfs(heights, i+1, j, visited);
        }
        if(j-1>=0 && current<=heights[i][j-1]) {
            dfs(heights, i, j-1, visited);
        }
        if(j+1<heights[0].length && current<=heights[i][j+1]) {
            dfs(heights, i, j+1, visited);
        }
    }

}
