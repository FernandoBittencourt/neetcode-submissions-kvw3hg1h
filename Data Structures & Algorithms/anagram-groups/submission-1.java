class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> result = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length;i++){
            String key = hash(strs[i]);
            
            if(result.get(key)!=null){
                List<String> list = result.get(key);
                list.add(strs[i]);
            } else{
                List<String> list =new ArrayList<String>();
                list.add(strs[i]);
                result.put(key, list);
            }
        }

        return result.values().stream().toList();
    }

    private String hash(String s){
        int[] count = new int[26];
        StringBuilder keyBuilder= new StringBuilder();
        char[] text = s.toCharArray();
        for(int i=0; i<text.length; i++){
            count[text[i]-'a']++;
        }
        for(int i=0;i<count.length;i++){
            keyBuilder.append(count[i]+"#");
        }
        return keyBuilder.toString();
    }
}
