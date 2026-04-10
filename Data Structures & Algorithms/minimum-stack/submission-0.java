class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    public MinStack() {
        main=new Stack<Integer>();
        min=new Stack<Integer>();
    }
    
    public void push(int val) {
        main.push(val);
        if(min.empty()){
            min.push(val);
        } else{
            int valMin=Math.min(min.peek(), val);
            min.push(valMin);
        }
    }
    
    public void pop() {
        main.pop();
        min.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
