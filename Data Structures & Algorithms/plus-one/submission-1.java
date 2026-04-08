class Solution {
    public int[] plusOne(int[] digits) {
        int flagPlus=1;
        for(int i=digits.length-1;i>=0;i--){
            int number = digits[i]+flagPlus;
            if(number==10){
                digits[i]=0;
                flagPlus=1;
            } else{
                digits[i]=number;
                flagPlus=0;
                break;
            }
        }

        if(flagPlus==1){
            int[] result= new int[digits.length+1];
            result[0]=1;
            for(int i=0;i<digits.length;i++){
                result[i+1]=digits[i];
            }
            return result;
        }
        return digits;
    }
}
