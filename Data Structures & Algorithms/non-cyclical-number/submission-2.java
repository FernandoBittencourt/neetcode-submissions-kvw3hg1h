class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<Integer>();
        while(n!=1){            
            int x = n % 10;
            int xx = (n / 10) % 10;
            int xxx = (n / 100) % 10;
            int xxxx = (n / 1000) % 10;
            n=x*x+xx*xx+xxx*xxx+xxxx*xxxx;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }
}
