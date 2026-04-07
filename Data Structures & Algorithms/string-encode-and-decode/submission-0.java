class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        char[] text = str.toCharArray();
        List<String> result = new ArrayList<String>();
        while(i<text.length){
            String sNumber = "";
            while(text[i]!='#'){
                sNumber=sNumber+text[i];
                i++;
            }
            i++;
            int number = Integer.parseInt(sNumber);
            String value="";
            for(int j=i; j<i+number;j++){
                value=value+text[j];
            }
            result.add(value);
            i = i + number;
        }
        return result;
    }
}
