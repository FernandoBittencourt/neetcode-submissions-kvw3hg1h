class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;

        int i=0;
        int j=rows-1;
        while(i<=j){
            int middle=(i+j)/2;
            int value = matrix[middle][0];
            if(value==target){
                return true;
            } else if(value<target){                
                i=middle+1;
            } else{
                j=middle-1;
            }
        }
        int row=j;
        if (row < 0) {
            return false;
        }
        int columns = matrix[0].length;
        i=0;
        j=columns-1;
        while(i<=j){
            int middle=(i+j)/2;
            if(matrix[row][middle]==target){
                return true;
            } else if(matrix[row][middle]<target){
                i=middle+1;
            } else{
                j=middle-1;
            }
        }
        return false;
    }


}
