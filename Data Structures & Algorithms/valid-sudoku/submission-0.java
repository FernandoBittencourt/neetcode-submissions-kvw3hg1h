class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9;i++){
            HashSet<Character> set=new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(set.contains(board[i][j])){
                    return false;
                } else if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
            }
        }

        for(int j=0; j<9;j++){
            HashSet<Character> set=new HashSet<Character>();
            for(int i=0;i<9;i++){
                if(set.contains(board[i][j])){
                    return false;
                } else if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
            }
        }
        for(int m=0;m<3;m++){
            for(int n=0;n<3;n++){  
                HashSet set=new HashSet<Character>();              
                for(int i=0; i<3;i++){
                    for(int j=0;j<3;j++){
                        if(set.contains(board[i+m*3][j+n*3])){
                            return false;
                        } else if(board[i+m*3][j+n*3]!='.'){
                            set.add(board[i+m*3][j+n*3]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
