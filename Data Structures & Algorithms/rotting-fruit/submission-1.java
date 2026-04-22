class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                for(int[] d : dirs){
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length
                       && grid[ni][nj] == 1){

                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if(rotted) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}