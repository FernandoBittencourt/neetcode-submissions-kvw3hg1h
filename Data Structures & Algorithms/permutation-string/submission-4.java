class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        String hashS1=hash(s1);
        for(int i=0;i<=s2.length() - s1.length();i++){
            StringBuilder substringBuilder=new StringBuilder();
            for(int j=0;j<s1.length();j++){
                substringBuilder.append(s2.charAt(j+i));
            }
             String hashS2= hash(substringBuilder.toString());
             if(hashS2.equals(hashS1)){
                return true;
             }
        }
        return false;
    }

    private String hash(String s){
        int[] countLetter=new int[26];
        for(int i=0;i<s.length();i++){
            countLetter[s.charAt(i)-'a']++;
        }
        StringBuilder sBuilder=new StringBuilder();
        for(int i=0;i<countLetter.length;i++){
            sBuilder.append(countLetter[i]);
            sBuilder.append("#");
        }
        return sBuilder.toString();
    }
}
