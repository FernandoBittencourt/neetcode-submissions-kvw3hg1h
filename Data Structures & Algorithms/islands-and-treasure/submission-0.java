class Solution {
    public void islandsAndTreasure(int[][] grid) {
       Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int[] d : dirs){
                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length
                   && grid[ni][nj] == Integer.MAX_VALUE){

                    grid[ni][nj] = grid[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
    }
}