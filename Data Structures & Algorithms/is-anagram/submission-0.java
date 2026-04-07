class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> sMap= new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap= new HashMap<Character, Integer>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for(int i=0;i<sCharArray.length;i++){
            Integer value = sMap.get(sCharArray[i]);
            if(value != null){
                value++;
                sMap.put(sCharArray[i], value);
            }else{
                sMap.put(sCharArray[i], 1);
            }
        }

         for(int i=0;i<tCharArray.length;i++){
            Integer value = tMap.get(tCharArray[i]);
            if(value != null){
                value++;
                tMap.put(tCharArray[i], value);
            }else{
                tMap.put(tCharArray[i], 1);
            }
        }

        for(Character key : tMap.keySet()){
            if(!tMap.get(key).equals(sMap.get(key))){
                return false;
            }
        }
        return true;
    }
}
