class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<stones.length;i++){
            pQueue.add(stones[i]);
        }
        
        while(pQueue.size()>1){
            int polled1 = pQueue.poll();
            int polled2 = pQueue.poll();
            int result=Math.abs(polled1-polled2);
            if(result>0){
                pQueue.add(result);
            }
        }
        return pQueue.size()==1? pQueue.poll(): 0;
    }
}
