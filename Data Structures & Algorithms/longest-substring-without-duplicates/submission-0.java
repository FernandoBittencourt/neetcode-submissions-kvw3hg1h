class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int max=0;
        HashSet<Character> set = new HashSet<Character>();
        for(int j=0; j<s.length();j++){
            char c = s.charAt(j);
            while(set.contains(c)){ 
                set.remove(s.charAt(i));          
                i++;
            }
            set.add(c);
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}
