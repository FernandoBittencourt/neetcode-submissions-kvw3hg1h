class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else {
                if(stack.empty()){
                    return false;
                }
                char pop= stack.pop();
                if(c==')' && pop != '('){
                    return false;
                } else if(c==']' && pop != '['){
                    return false;
                } else if(c=='}' && pop != '{'){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
