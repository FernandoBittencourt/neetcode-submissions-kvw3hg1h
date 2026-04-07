class KthLargest {

    private PriorityQueue <Integer> pQueue;
    private int kth;
    public KthLargest(int k, int[] nums) {
        kth=k;
        pQueue=new PriorityQueue <Integer>();
        for(int num: nums){
            pQueue.add(num);
        }
    }
    
    public int add(int val) {
        pQueue.add(val);
        while(pQueue.size()>kth){
            pQueue.poll();   
        }

        
        return pQueue.peek();

    }
}
