class Solution {
    public boolean isHappy(int n) {
        int slow=calculateDigits(n);
        int fast=calculateDigits(calculateDigits(n));
        while(slow!=1 && fast !=1){ 
            slow = calculateDigits(slow);
            fast = calculateDigits(calculateDigits(fast));
            if(slow==fast){
                return false;
            }
        }
        return true;
    }

    private int calculateDigits(int n){
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
