class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i=0;
        int j=rows*columns-1;
        while(i<=j){
            int middle=(i+j)/2;
            if(matrix[middle/columns][middle%columns]==target){
                return true;
            } else if(matrix[middle/columns][middle%columns]<target){
                i=middle+1;
            } else{
                j=middle-1;
            }
        }
        return false;
    }


}
