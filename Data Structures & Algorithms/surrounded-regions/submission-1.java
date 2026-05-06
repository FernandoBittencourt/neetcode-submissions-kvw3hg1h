class Solution {
    public void solve(char[][] board) {
        boolean[][] cantChange = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length;i++){
            dfs(board, i, 0, cantChange);
            dfs(board, i, board[0].length-1, cantChange);
        }
        for(int j=1;j<board[0].length-1;j++){
            dfs(board, 0, j, cantChange);
            dfs(board, board.length-1, j, cantChange);
        }

        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O' && !cantChange[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] cantChange){
        if(i<0 || i== board.length || j<0 || j== board[0].length){
            return;
        }
        if(cantChange[i][j]){
            return;
        }
        if(board[i][j]=='O'){
            cantChange[i][j]=true;
            dfs(board, i-1, j, cantChange);
            dfs(board, i+1, j, cantChange);
            dfs(board, i, j-1, cantChange);
            dfs(board, i, j+1, cantChange);
        }

    }
}
